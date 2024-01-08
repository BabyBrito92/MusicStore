package com.MusicStore.MusicStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class MusicStoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(MusicStoreApplication.class, args);
	}

}
