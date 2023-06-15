package com.luv2code.springbootecommerceApp.dao;

import com.luv2code.springbootecommerceApp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
