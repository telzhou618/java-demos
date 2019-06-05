package com.example.demo.job;

import com.cxytiandi.elasticjob.annotation.ElasticJobConf;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import lombok.extern.java.Log;

/**
 * @author: zhougaojun
 * @date: 2019/06/05
 * @description:
 */
@Log
@ElasticJobConf(name = "MySimpleJob", cron = "0/5 * * * * ?", shardingTotalCount = 3, shardingItemParameters = "0=A,1=B,2=C", description = "简单任务", jobParameter = "parameter")
public class MySimpleJob implements SimpleJob {

    @Override
    public void execute(ShardingContext shardingContext) {
        log.info(String.format("Thread ID: %s, 作业分片总数: %s, " +
                        "当前分片项: %s.当前参数: %s," +
                        "作业名称: %s.作业自定义参数: %s"
                ,
                Thread.currentThread().getId(),
                shardingContext.getShardingTotalCount(),
                shardingContext.getShardingItem(),
                shardingContext.getShardingParameter(),
                shardingContext.getJobName(),
                shardingContext.getJobParameter()
        ));
    }

}