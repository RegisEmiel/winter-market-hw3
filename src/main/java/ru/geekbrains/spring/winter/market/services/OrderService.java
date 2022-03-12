package ru.geekbrains.spring.winter.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.winter.market.dtos.OrderDataDTO;
import ru.geekbrains.spring.winter.market.entities.Order;
import ru.geekbrains.spring.winter.market.entities.OrderItem;
import ru.geekbrains.spring.winter.market.entities.Product;
import ru.geekbrains.spring.winter.market.entities.User;
import ru.geekbrains.spring.winter.market.exceptions.ResourceNotFoundException;
import ru.geekbrains.spring.winter.market.model.Cart;
import ru.geekbrains.spring.winter.market.model.CartItem;
import ru.geekbrains.spring.winter.market.repositories.OrderRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final ProductService productService;
    private final OrderRepository orderRepository;
    private final CartService cartService;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Transactional
    public void createOrder(User user, OrderDataDTO orderData) {
        Cart cart = cartService.getCurrentCart();
        List<OrderItem> orderItemList = new LinkedList<>();

        Order order = new Order();
        order.setId(0L);
        order.setUser(user);
        order.setAddress(orderData.getAddress());
        order.setPhone(orderData.getPhone());
        order.setTotalPrice(cart.getTotalPrice());

        for (CartItem item: cart.getItems()) {
            Optional<Product> product = productService.findById(item.getProductId());
            if (product.isEmpty())
                throw new ResourceNotFoundException("Product id = " + item.getProductId() + " not found");

            OrderItem newOrderItem = new OrderItem(null,
                    product.get(),
                    order,
                    item.getQuantity(),
                    item.getPricePerProduct(),
                    item.getPrice());

            orderItemList.add(newOrderItem);
        }
        order.setItems(orderItemList);

        orderRepository.save(order);
    }
}
