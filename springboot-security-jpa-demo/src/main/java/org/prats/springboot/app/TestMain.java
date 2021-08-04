package org.prats.springboot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.prats.springboot.app.repository")
@EntityScan(basePackages = "org.prats.springboot.app.entities")
public class TestMain {

    public static void main(String[] args) { SpringApplication.run(TestMain.class, args); }

}
