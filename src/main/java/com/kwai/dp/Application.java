package com.kwai.dp;

import io.elasticjob.lite.springboot.annotation.EnableElasticJob;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author malingling <malingling@kuaishou.com>
 * Created on 2018-11-17
 */

@SpringBootApplication
@EnableElasticJob
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
