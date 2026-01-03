package com.jejo.encode_decode.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jejo.encode_decode.users.dto.CreatedCustomerDto;
import com.jejo.encode_decode.users.dto.CustomerDto;
import com.jejo.encode_decode.users.dto.UserDto;
import com.jejo.encode_decode.users.service.CustomerService;
/*
* @RestController
@RequestMapping("/auth")
public class CustomerController {

  private final CustomerService customerService;

  @Autowired
  public CustomerController(CustomerService customerService){
    this.customerService = customerService;
  }

  @PostMapping("/created")
  ResponseEntity<CustomerDto> saveCustomer(CreatedCustomerDto createdCustomerDto){
    return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createdCustomer(createdCustomerDto));
  }

  @PostMapping("/valid")
  ResponseEntity<Boolean> validUser(UserDto userDto){
    return ResponseEntity.status(HttpStatus.OK).body(customerService.validUser(userDto));
  }
}
* */


