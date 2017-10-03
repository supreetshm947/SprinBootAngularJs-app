package com.example.fullstackangular.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories("com.example.fullstackangular.repository")
@EnableTransactionManagement
public class DatabaseConfig {

}
