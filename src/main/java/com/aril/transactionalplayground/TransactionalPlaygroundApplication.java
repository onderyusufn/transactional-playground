package com.aril.transactionalplayground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TransactionalPlaygroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionalPlaygroundApplication.class, args);
    }

}
