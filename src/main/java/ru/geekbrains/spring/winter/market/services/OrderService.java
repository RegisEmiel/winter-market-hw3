package ru.geekbrains.spring.winter.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.winter.market.entities.Order;
import ru.geekbrains.spring.winter.market.entities.OrderItem;
import ru.geekbrains.spring.winter.market.entities.User;
import ru.geekbrains.spring.winter.market.model.Cart;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final ProductService productService;

    public void createOrder(User user) {

    }
}
