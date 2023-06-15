package com.luv2code.springbootecommerceApp.dto;

import com.luv2code.springbootecommerceApp.entity.Address;
import com.luv2code.springbootecommerceApp.entity.Customer;
import com.luv2code.springbootecommerceApp.entity.Order;
import com.luv2code.springbootecommerceApp.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

}
