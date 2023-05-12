package com.github.fnunezzz.kafkaparallelprocessingjava;

import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@EnableAutoConfiguration
@Configuration
public class AppConfig {

    @Bean("datasource")
    @Primary
    @org.springframework.boot.context.properties.ConfigurationProperties(prefix = "datasource.postgres")
    public DataSource getDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

}
