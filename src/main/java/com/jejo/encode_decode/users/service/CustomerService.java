package com.jejo.encode_decode.users.service;

import com.jejo.encode_decode.users.dto.CreatedCustomerDto;
import com.jejo.encode_decode.users.dto.CustomerDto;
import com.jejo.encode_decode.users.dto.UserDto;

public interface CustomerService {
  boolean validUser(UserDto udto);
  CustomerDto createdCustomer(CreatedCustomerDto ccdto);
}
