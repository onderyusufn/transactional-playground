package com.aril.transactionalplayground;

import com.aril.transactionalplayground.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TransactionDemo implements CommandLineRunner {

    private final OrderService orderService;

    public TransactionDemo(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void run(String... args) {
        orderService.createOrder();
    }
}
