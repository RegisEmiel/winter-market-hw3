package ru.geekbrains.spring.winter.market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.spring.winter.market.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
