package com.hms.billingms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.billingms.model.Payment;

public interface PaymentInterface extends JpaRepository<Payment , Long> {

}
