package com.aril.transactionalplayground.repository;

import com.aril.transactionalplayground.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
