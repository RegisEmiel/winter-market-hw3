package ru.geekbrains.spring.winter.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.winter.market.dtos.ProductDto;
import ru.geekbrains.spring.winter.market.entities.Product;
import ru.geekbrains.spring.winter.market.entities.User;
import ru.geekbrains.spring.winter.market.exceptions.ResourceNotFoundException;
import ru.geekbrains.spring.winter.market.services.OrderService;
import ru.geekbrains.spring.winter.market.services.ProductService;
import ru.geekbrains.spring.winter.market.services.UserService;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final UserService userService;
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(Principal principal /*, @RequestBody OrderData orderData */) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException()); // TODO: HW FIX
        orderService.createOrder(user);
    }
}
