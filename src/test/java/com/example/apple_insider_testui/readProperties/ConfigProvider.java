package com.example.apple_insider_testui.readProperties;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();

    static Config readConfig(){
        return ConfigFactory.systemProperties().hasPath("testProfile")
                ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
                : ConfigFactory.load("application.conf");
    }

    String URL = readConfig().getString("url");

    String DEMO_PASSWORD = readConfig().getString("usersParams.demo.password");
    String DEMO_LOGIN = readConfig().getString("usersParams.demo.login");
}
