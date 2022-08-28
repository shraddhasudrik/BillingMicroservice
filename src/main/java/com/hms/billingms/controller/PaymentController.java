package com.hms.billingms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hms.billingms.model.Payment;
import com.hms.billingms.repository.PaymentRepository;


@RestController
public class PaymentController {

	@Autowired
	private PaymentRepository paymentRepository;
	
	@PostMapping("/addpayment")   //To add payment
	public Payment addPayment(@RequestBody Payment payment) {
		
		return paymentRepository.save(payment);
	}
	
	
	@GetMapping("/addpayment") //To get all the payments
	public List<Payment> getAllPayments(){
		
		return paymentRepository.findAll();
		
	}
}
