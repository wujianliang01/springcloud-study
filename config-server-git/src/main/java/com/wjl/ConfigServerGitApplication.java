package com.wjl;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigServerGitApplication {

    public static void main(String args[]){

        new SpringApplicationBuilder(ConfigServerGitApplication.class).web(true).run(args);

        System.out.println("ConfigServerGitApplication Start Success...");
    }
}
