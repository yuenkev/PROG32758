package ca.sheridan.nov02.Database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    // Placeholder for beans
    @Bean
    public NamedParameterJdbcTemplate goName(DataSource ds){
        return new NamedParameterJdbcTemplate(ds);
    }

}
