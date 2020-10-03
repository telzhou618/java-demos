package com.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.StandardShardingStrategyConfiguration;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
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

        // 配置Order表分库 + 分表策略
        TableRuleConfiguration orderTableRuleConfig = new TableRuleConfiguration("tb_order","db0${1..2}.tb_order0${1..2}");
        orderTableRuleConfig.setDatabaseShardingStrategyConfig(new StandardShardingStrategyConfiguration("id", this::doSharding));
        orderTableRuleConfig.setTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("id", new MyPreciseShardingAlgorithm()));

        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(orderTableRuleConfig);

        Properties properties = new Properties();
        // 显示SQL日志，INFO级别
        properties.setProperty("sql.show", "true");

        return ShardingDataSourceFactory.createDataSource(createDataSourceMap(dbProperties), shardingRuleConfig, properties);
    }


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

    private class MyPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

        @Override
        public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
            Integer index = Math.toIntExact(shardingValue.getValue() % availableTargetNames.size());
            List<String> availableTargetNameList = availableTargetNames.stream().sorted().collect(Collectors.toList());
            return availableTargetNameList.get(index);
        }
    }

    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
        Integer index = Math.toIntExact(shardingValue.getValue() % availableTargetNames.size());
        List<String> availableTargetNameList = availableTargetNames.stream().sorted().collect(Collectors.toList());
        return availableTargetNameList.get(index);
    }
}
