package com.kwai.dp.job;

import io.elasticjob.lite.api.ShardingContext;
import io.elasticjob.lite.api.simple.SimpleJob;
import io.elasticjob.lite.springboot.annotation.ElasticJobConf;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author malingling <malingling@kuaishou.com>
 * Created on 2018-11-16
 */

@ElasticJobConf(name = "MySimpleJob", cron = "0/10 * * * * ?",
        shardingItemParameters = "0=0,1=1", description = "简单任务")
public class MySimpleJob implements SimpleJob {

    public void execute(ShardingContext shardingContext) {
        String shardParamter = shardingContext.getShardingParameter();
        System.out.println("分片参数："+shardParamter);
        int value = Integer.parseInt(shardParamter);
        for (int i = 0; i < 1000; i++) {
            if (i % 2 == value) {
                String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
                System.out.println(time + ":开始执行简单任务" + i);
            }
        }
    }

}
