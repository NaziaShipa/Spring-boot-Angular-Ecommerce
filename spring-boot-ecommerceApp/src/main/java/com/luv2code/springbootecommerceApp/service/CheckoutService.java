package com.luv2code.springbootecommerceApp.service;

import com.luv2code.springbootecommerceApp.controller.CheckoutController;
import com.luv2code.springbootecommerceApp.dto.Purchase;
import com.luv2code.springbootecommerceApp.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
