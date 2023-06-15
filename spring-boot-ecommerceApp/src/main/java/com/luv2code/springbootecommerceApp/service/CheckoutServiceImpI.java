package com.luv2code.springbootecommerceApp.service;

import com.luv2code.springbootecommerceApp.dao.CustomerRepository;
import com.luv2code.springbootecommerceApp.dto.Purchase;
import com.luv2code.springbootecommerceApp.dto.PurchaseResponse;
import com.luv2code.springbootecommerceApp.entity.Customer;
import com.luv2code.springbootecommerceApp.entity.Order;
import com.luv2code.springbootecommerceApp.entity.OrderItem;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
@Service
public class CheckoutServiceImpI implements CheckoutService{

    private CustomerRepository customerRepository;

    public CheckoutServiceImpI(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        //retrieve the order info from dto
        Order order = purchase.getOrder();

        //generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        //populate order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        //populate order with billingAddress and shippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getBillingAddress());

        //populate customer with order
        Customer customer = purchase.getCustomer();
        customer.add(order);

        //save to the database
        customerRepository.save(customer);

        //return a response
        return new PurchaseResponse(orderTrackingNumber);

    }

    private String generateOrderTrackingNumber() {

        //generate a random UUID number (UUID version-4)
        return UUID.randomUUID().toString();
    }
}
