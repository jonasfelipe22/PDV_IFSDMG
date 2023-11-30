package com.posdesenvolvimentoweb.springbootcommysql;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.posdesenvolvimentoweb.springbootcommysql")
@EntityScan(basePackages = "com.posdesenvolvimentoweb.springbootcommysql.model")
public class SpringBootComMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootComMysqlApplication.class, args);
	}

}
