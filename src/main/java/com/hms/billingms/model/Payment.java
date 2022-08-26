package com.hms.billingms.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long paymentNo;
	
	@Column(nullable = false)
	private int total;
	
	@Column(nullable = false)
	private LocalDateTime payTime;
	
	@Column(nullable = false)
	private int creditCardNo;
	
	@Column(nullable = false)
	private int creditCardCVV;
	
	@Column(nullable = false)
	private int creditCardExpiryDate;
	
	

	public Payment(Long paymentNo, int total, LocalDateTime payTime, int creditCardNo, int creditCardCVV,
			int creditCardExpiryDate) {
		super();
		this.paymentNo = paymentNo;
		this.total = total;
		this.payTime = payTime;
		this.creditCardNo = creditCardNo;
		this.creditCardCVV = creditCardCVV;
		this.creditCardExpiryDate = creditCardExpiryDate;
	}

	public Long getPaymentNo() {
		return paymentNo;
	}

	public void setPaymentNo(Long paymentNo) {
		this.paymentNo = paymentNo;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public LocalDateTime getPayTime() {
		return payTime;
	}

	public void setPayTime(LocalDateTime payTime) {
		this.payTime = payTime;
	}

	public int getCreditCardNo() {
		return creditCardNo;
	}

	public void setCreditCardNo(int creditCardNo) {
		this.creditCardNo = creditCardNo;
	}

	public int getCreditCardCVV() {
		return creditCardCVV;
	}

	public void setCreditCardCVV(int creditCardCVV) {
		this.creditCardCVV = creditCardCVV;
	}

	public int getCreditCardExpiryDate() {
		return creditCardExpiryDate;
	}

	public void setCreditCardExpiryDate(int creditCardExpiryDate) {
		this.creditCardExpiryDate = creditCardExpiryDate;
	}
	
		
	
}
