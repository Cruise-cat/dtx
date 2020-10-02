package com.cruise.dtx.discoverserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * TODO
 *
 * @author Cruise
 * @version 1.0
 * @since 2020/9/30
 */
@SpringBootApplication
@EnableEurekaServer
public class DiscoverServer {

    public static void main(String[] args) {
        SpringApplication.run(DiscoverServer.class, args);
    }
}

