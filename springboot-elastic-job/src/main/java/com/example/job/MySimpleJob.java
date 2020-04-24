package com.example.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.elasticjob.lite.annotation.ElasticSimpleJob;
import org.springframework.stereotype.Component;

/**
 * @author zhougaojun
 */
@Component
@ElasticSimpleJob(cron = "*/3 * * * * ?", shardingTotalCount = 2)
public class MySimpleJob implements SimpleJob {

    @Override
    public void execute(ShardingContext shardingContext) {
        switch (shardingContext.getShardingItem()) {
            case 0:
                System.out.println("hello from shard 0");
                break;
            case 1:
                System.out.println("hello from shard 1");
                break;
        }
    }

}