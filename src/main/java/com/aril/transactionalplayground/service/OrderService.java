package com.aril.transactionalplayground.service;

import com.aril.transactionalplayground.model.Order;
import com.aril.transactionalplayground.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final LogService logService;
    private final ReportService reportService;

    @Transactional(timeout = 3)
    public void createOrder() {
        Order order = getOrder();
        log.info("Creating order with customer name: {}", order.getCustomerName());
        Order save = orderRepository.save(order);
        logService.createLog("Order created");

        // this try-catch block is used to catch the exception thrown by the method. convert runtime exception to checked exception
        try {
            reportService.timeoutDontEffectOrderService(); // reportService.timeoutEffectOrderService();
        } catch (Exception e) {
            log.error("Error", e);
        }

        reportService.throwExceptionDontRollback(); // reportService.throwExceptionRollback();

        reportService.createReport(save.getStatus().name());
        log.info("Order created");
    }

    private static Order getOrder() {
        Order order = new Order();
        order.setCustomerName("John Doe");
        order.setAmount(100.0);
        order.setStatus(Order.OrderStatus.PENDING);
        return order;
    }
}
