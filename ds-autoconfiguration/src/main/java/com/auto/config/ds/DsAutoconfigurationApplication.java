package com.auto.config.ds;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@ConditionalOnClass({org.hsqldb.Database.class})
public class DsAutoconfigurationApplication implements CommandLineRunner{

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().generateUniqueName(true).addScript("embedded-database-schema.sql")
				.addScript("embedded-database-data.sql").build();
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
