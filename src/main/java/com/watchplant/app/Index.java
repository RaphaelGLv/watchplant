package com.watchplant.app;

import com.watchplant.app.services.PerenualService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Index {

  @RequestMapping("/")
  String home() {
    return "Hello World";
  }

  public static void main(String[] args) {
    SpringApplication.run(Index.class, args);
  }
}
