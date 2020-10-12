package com.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Range;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.ComplexShardingStrategyConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.StandardShardingStrategyConfiguration;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author jameszhou
 */
@Configuration
@Import(DbProperties.class)
public class DbConfig {

    @Bean
    public DataSource createDataSource(DbProperties dbProperties) throws SQLException {

        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(orderTableRuleConfig());
        shardingRuleConfig.getTableRuleConfigs().add(userAreaTableRuleConfig());

        Properties properties = new Properties();
        // 显示SQL日志，INFO级别
        properties.setProperty("sql.show", "true");

        return ShardingDataSourceFactory.createDataSource(createDataSourceMap(dbProperties), shardingRuleConfig, properties);
    }


    /**
     * 订单分片策略
     *
     * @return
     */
    private TableRuleConfiguration orderTableRuleConfig() {
        // 配置Order表分库 + 分表策略
        TableRuleConfiguration orderTableRuleConfig = new TableRuleConfiguration("tb_order", "db0${1..2}.tb_order0${1..2}");
        orderTableRuleConfig.setDatabaseShardingStrategyConfig(new StandardShardingStrategyConfiguration("id", this::doSharding));
        orderTableRuleConfig.setTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("id", new MyPreciseShardingAlgorithm(), new MyRangeShardingAlgorithm()));
        return orderTableRuleConfig;
    }

    /**
     * 用户-收货区域 分片策略 复合分片策略, userId+areaId 奇数差db01、偶数差db02
     */
    private TableRuleConfiguration userAreaTableRuleConfig() {
        // 配置Order表分库 + 分表策略
        TableRuleConfiguration orderTableRuleConfig = new TableRuleConfiguration("tb_user_area", "db0${1..2}.tb_user_area");
        orderTableRuleConfig.setDatabaseShardingStrategyConfig(new ComplexShardingStrategyConfiguration("user_id,area_id", new ComplexKeysShardingAlgorithm() {
            @Override
            public Collection<String> doSharding(Collection availableTargetNames, ComplexKeysShardingValue shardingValue) {

                System.out.println(JSON.toJSONString(availableTargetNames));
                System.out.println(JSON.toJSONString(shardingValue.getLogicTableName()));
                System.out.println(JSON.toJSONString(shardingValue.getColumnNameAndRangeValuesMap()));
                System.out.println(JSON.toJSONString(shardingValue.getColumnNameAndShardingValuesMap()));

                Map<String, Collection<Integer>> collectionMap = shardingValue.getColumnNameAndShardingValuesMap();

                Integer userId = collectionMap.getOrDefault("user_id",Collections.emptyList()).stream().findFirst().orElse(0);
                Integer areaId = collectionMap.getOrDefault("area_id",Collections.emptyList()).stream().findFirst().orElse(0);
                // 操作条件没有userId或areaId时全款扫描
                if(userId == 0 || areaId == 0){
                    return availableTargetNames;
                }
                Integer index = (userId + areaId) % availableTargetNames.size();
                List<String> availableTargetNameList = (List<String>) availableTargetNames.stream().sorted().collect(Collectors.toList());
                return Collections.singleton(availableTargetNameList.get(index));
            }
        }));
        return orderTableRuleConfig;
    }


    /**
     * 创建数据源
     *
     * @param dbProperties
     * @return
     */
    private Map<String, DataSource> createDataSourceMap(DbProperties dbProperties) {
        Map<String, DataSource> map = new HashMap<>(2);
        dbProperties.getDb().forEach((k, v) -> {
            DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
            dataSource.setUrl(v.getUrl());
            dataSource.setUsername(v.getUsername());
            dataSource.setPassword(v.getPassword());
            map.put(k, dataSource);
        });
        return map;
    }


    /**
     * 用于处理BETWEEN AND, >, <, >=, <=分片，如果不配置RangeShardingAlgorithm，SQL中的BETWEEN AND将按照全库路由处理。
     */
    private class MyRangeShardingAlgorithm implements RangeShardingAlgorithm<Long> {

        @Override
        public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<Long> shardingValue) {
            List<String> availableTargetNameList = availableTargetNames.stream().sorted().collect(Collectors.toList());
            // 区间
            Range<Long> range = shardingValue.getValueRange();
            if (range.lowerEndpoint() > 0 && range.upperEndpoint() <= 100L) {
                return availableTargetNameList.subList(0, 0);
            }
            if (range.lowerEndpoint() > 100L) {
                return availableTargetNameList.subList(0, 0);
            }
            return availableTargetNameList;
        }
    }


    /**
     * 分片策略写法1,针对 =、IN 查询生效
     */
    private class MyPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {
        @Override
        public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
            Integer index = Math.toIntExact(shardingValue.getValue() % availableTargetNames.size());
            List<String> availableTargetNameList = availableTargetNames.stream().sorted().collect(Collectors.toList());
            return availableTargetNameList.get(index);
        }
    }

    /**
     * 分片策略写法1
     */
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
        Integer index = Math.toIntExact(shardingValue.getValue() % availableTargetNames.size());
        List<String> availableTargetNameList = availableTargetNames.stream().sorted().collect(Collectors.toList());
        return availableTargetNameList.get(index);
    }
}
