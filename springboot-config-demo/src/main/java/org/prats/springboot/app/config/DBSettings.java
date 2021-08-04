package org.prats.springboot.app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

@Configuration
@ConfigurationProperties(prefix = "db")
public class DBSettings {

    private String connection;
    private String host;
    private String port;

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "DBSettings{" +
                "connection='" + connection + '\'' +
                ", host='" + host + '\'' +
                ", port='" + port + '\'' +
                '}';
    }

}
