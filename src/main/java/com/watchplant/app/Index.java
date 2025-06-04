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
    PerenualService perenualService = new PerenualService(
      "sk-tDl168253372af59510459"
    );
    String response = perenualService.fetchGetPlantDetails("1");

    return response;
  }

  public static void main(String[] args) {
    SpringApplication.run(Index.class, args);
  }

  @Bean
  public DriverManagerDataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.h2.Driver");
    dataSource.setUrl("jdbc:h2:mem:testdb"); // In-memory H2 database
    dataSource.setUsername("sa");
    dataSource.setPassword("");
    return dataSource;
  }
}
