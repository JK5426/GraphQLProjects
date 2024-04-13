package com.learing.graphql.services;

import com.learing.graphql.entities.Order;
import com.learing.graphql.helper.ExceptionHelper;
import com.learing.graphql.repositories.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    // creating order
    public Order createOrder(Order order){
        return orderRepo.save(order);
    }
    // getting all users
    public List<Order> getAllOrders(){
        return orderRepo.findAll();
    }
    // getting single order
    public Order getOrder(int orderId){
        return orderRepo.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
    }
    // updating order
    public Order updateOrder(Order order){
        Order orderFromDb = orderRepo.findById(order.getOrderId()).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        if(null != order.getOrderDetail()) {
            orderFromDb.setOrderDetail(order.getOrderDetail());
        }
        if(null != order.getAddress()) {
            orderFromDb.setAddress(order.getAddress());
        }
        if(null != order.getPrice()) {
            orderFromDb.setPrice(order.getPrice());
        }
        if(null != order.getUser()) {
            orderFromDb.setUser(order.getUser());
        }
        return orderRepo.save(orderFromDb);
    }
    // deleting order
    public boolean deleteOrder(int orderId){
        Order order = orderRepo.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        orderRepo.delete(order);
        return true;
    }
}
