package com.hms.billingms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.hms.billingms.controller.PaymentController;
import com.hms.billingms.model.Payment;
import com.hms.billingms.repository.PaymentRepository;

@SpringBootTest(classes = {PaymentAppTest.class})
public class PaymentAppTest {

	@Mock
	PaymentRepository paymentRepository;
	
	
	@InjectMocks
	PaymentController paymentController;
	
	public List<Payment>mypayment;
	
	@Test   //junit cannot excecute until we specify the test method 
	@Order(1)              // if you want to execute this method 1st
	
	public void test_getAllPayments() {
	
	 List<Payment>mypayment = new ArrayList<Payment>();
	 mypayment.add(new Payment(1L, 3000, LocalDate.of(2022,10, 22),123456789,333,LocalDate.of(2025, 05, 04)));
	 mypayment.add(new Payment(2L, 1000, LocalDate.of(2022, 06, 05), 123456789, 258, LocalDate.of(2030, 04, 03)));
			
	 when(paymentRepository.findAll()).thenReturn(mypayment);		//Mocking
		assertEquals(2,paymentController.getAllPayments().size());	//assert to validate
	 
	}
	
	@Test   
	@Order(2)            
	
	public void test_addPayment() {
		
		Payment payment = new Payment(3L, 1000, LocalDate.of(2022, 07, 05), 123456789, 258, LocalDate.of(2030, 04, 03));
		
		when(paymentRepository.save(payment)).thenReturn(payment);
		assertEquals(payment,paymentController.addPayment(payment));
	}
	}
	

