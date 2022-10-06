package com.nazmul.eShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = { "com.nazmul.eShop.service", "com.nazmul.eShop.ServiceImpl" })
@EntityScan("com.nazmul.eShop.model")
@ComponentScan({ "com.nazmul.eShop.controller" })
@EnableJpaRepositories("com.nazmul.eShop.repository")

@SpringBootApplication
public class EShopPosApplication {

	public static void main(String[] args) {
		SpringApplication.run(EShopPosApplication.class, args);
	}

}
