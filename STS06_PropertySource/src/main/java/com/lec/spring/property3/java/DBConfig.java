package com.lec.spring.property3.java;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.lec.spring.property2.xml.DBConn;

@Configuration
public class DBConfig {
	@Value("${admin.id}")
	private String id;
	@Value("${admin.pw}")
	private String pw;
	@Value("${db.url}")
	private String url;
	@Value("${db.port}")
	private String port;

	public static PropertySourcesPlaceholderConfigurer Properties() {
		System.out.println("Properties() 호출");
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();

		Resource[] locations = new Resource[2];
		locations[0] = new ClassPathResource("admin.auth");
		locations[1] = new ClassPathResource("db.info");
		configurer.setLocations(locations);
		return configurer;
	}
	
	   @Bean
	   public DBConn dbConfig() {
	      DBConn conn = new DBConn();
	      
	      conn.setId(id);
	      conn.setPw(pw);
	      conn.setUrl(url);
	      conn.setPort(port);

	      return conn;
	   }
	
}
