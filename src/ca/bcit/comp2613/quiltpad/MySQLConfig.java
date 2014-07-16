package ca.bcit.comp2613.quiltpad;

import javax.persistence.PersistenceUnit;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;


@EnableAutoConfiguration
@ImportResource("applicationContext.xml")

public class MySQLConfig {

	
}
