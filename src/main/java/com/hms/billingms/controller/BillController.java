package com.hms.billingms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hms.billingms.model.Bill;
import com.hms.billingms.model.JwtRequest;
import com.hms.billingms.model.JwtResponse;
import com.hms.billingms.repository.BillRepository;
import com.hms.billingms.service.UserService;
import com.hms.billingms.utility.JWTUtility;

@RestController
public class BillController {
	
	@Autowired
	private BillRepository billRepository;
	
	@Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;
	
    @Autowired
    private UserService userService;
	
	@GetMapping("/billhello")  //
	public String getHello() {
		return "hello world 6";
	}
	
	@PostMapping("/issuebill")   //To issue bill
	public Bill issueBill(@RequestBody Bill bill) {
		
		return billRepository.save(bill);
	}

	@GetMapping("/issuebill") //To get all the bills
	public List<Bill> getAllBills() {
		
		return billRepository.findAll();
	}

	 @PostMapping("/authenticate")
	 public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception{
		
		 try {
	            authenticationManager.authenticate(          
	                    new UsernamePasswordAuthenticationToken(   
	                            jwtRequest.getUsername(),
	                            jwtRequest.getPassword()
	                    )
	            );
	        } catch (BadCredentialsException e) {
	            throw new Exception("INVALID_CREDENTIALS", e);
	        }
	        
	        final UserDetails userDetails= userService.loadUserByUsername(jwtRequest.getUsername());
	        
	        final String token = jwtUtility.generateToken(userDetails);
	        
	        return  new JwtResponse(token);
		 
	 }
	
}
