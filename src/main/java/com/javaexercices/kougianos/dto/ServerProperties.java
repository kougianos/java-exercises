package com.javaexercices.kougianos.dto;

import com.javaexercices.kougianos.config.YamlPropertySourceFactory;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@PropertySource(value = "classpath:server-properties.yml", factory = YamlPropertySourceFactory.class)
@ConfigurationProperties(prefix = "server")
@Data
public class ServerProperties {
    private Map<String, String> application;
    private Map<String, List<String>> config;
    private Map<String, Credential> users;
    private List<Crypto> cryptos;

    @Data
    public static class Credential {
        private String username;
        private String password;
    }

    @ToString
    @Getter
    public enum Crypto {
        BTC("Bitcoin"),
        ETH("Ethereum"),
        ADA("Cardano");
        private final String value;

        Crypto(String value) {
            this.value = value;
        }
    }
}
