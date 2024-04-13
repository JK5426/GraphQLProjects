package com.learing.graphql.controllers;

import com.learing.graphql.entities.Order;
import com.learing.graphql.entities.User;
import com.learing.graphql.services.OrderService;
import com.learing.graphql.services.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OrderController {

    private final UserService userService;
    private final OrderService orderService;

    public OrderController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @MutationMapping
    public Order createOrder(@Argument String orderDetail,@Argument String address,@Argument int price,@Argument int userId){
        User user = userService.getUser(userId);
        Order order = new Order();
        order.setOrderDetail(orderDetail);
        order.setAddress(address);
        order.setPrice(price);
        order.setUser(user);
        return orderService.createOrder(order);
    }
    @MutationMapping
    public Order updateOrder(@Argument int orderId,@Argument String orderDetail,@Argument String address,@Argument int price,@Argument int userId){
        User user = userService.getUser(userId);
        Order order = new Order();
        order.setOrderId(orderId);
        order.setOrderDetail(orderDetail);
        order.setAddress(address);
        order.setPrice(price);
        order.setUser(user);
        return orderService.updateOrder(order);
    }

    @QueryMapping
    public List<Order> getOrders(){
        return orderService.getAllOrders();
    }

    @QueryMapping
    public Order getOrder(@Argument int orderId){
        return  orderService.getOrder(orderId);
    }

    @MutationMapping
    public Boolean deleteOrder(@Argument int orderId){
        return orderService.deleteOrder(orderId);
    }
}
