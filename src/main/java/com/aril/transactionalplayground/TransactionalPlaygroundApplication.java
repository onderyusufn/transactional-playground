package com.aril.transactionalplayground;

import com.aril.transactionalplayground.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@RequiredArgsConstructor
public class TransactionalPlaygroundApplication implements CommandLineRunner {

    private final OrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(TransactionalPlaygroundApplication.class, args);
    }

    @Override
    public void run(String... args) {
        orderService.createOrder();
    }
}
