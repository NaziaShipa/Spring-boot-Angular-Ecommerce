package com.luv2code.springbootecommerceApp.controller;

import com.luv2code.springbootecommerceApp.dto.Purchase;
import com.luv2code.springbootecommerceApp.dto.PurchaseResponse;
import com.luv2code.springbootecommerceApp.service.CheckoutService;

import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }


    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {

        PurchaseResponse purchaseResponse =checkoutService.placeOrder(purchase);

        return purchaseResponse;
    }
}
