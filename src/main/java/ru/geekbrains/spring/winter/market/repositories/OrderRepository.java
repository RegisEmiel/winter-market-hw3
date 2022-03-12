package ru.geekbrains.spring.winter.market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.spring.winter.market.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
