package com.jejo.encode_decode.users.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jejo.encode_decode.users.customer.Customer;
import com.jejo.encode_decode.users.customer.Users;
import com.jejo.encode_decode.users.dto.CreatedCustomerDto;
import com.jejo.encode_decode.users.dto.CustomerDto;
import com.jejo.encode_decode.users.dto.UserDto;
import com.jejo.encode_decode.users.repository.CustomerRepository;
import com.jejo.encode_decode.users.repository.UsersRepository;
import com.jejo.encode_decode.users.service.CustomerService;

@Service
public class CustomerImplement implements CustomerService {

  private final CustomerRepository customerRepository;
  private final UsersRepository usersRepository;
  private final PasswordEncoder passwordEncoder;

  @Autowired
  public CustomerImplement(CustomerRepository customerRepository, UsersRepository usersRepository, PasswordEncoder passwordEncoder){
    this.customerRepository = customerRepository;
    this.usersRepository =   usersRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public CustomerDto createdCustomer(CreatedCustomerDto ccdto) {
    String password = passwordEncoder.encode(ccdto.password());
    Customer customer = new Customer(null, ccdto.name(), ccdto.lastname(), ccdto.email(), 
      new Users(null, ccdto.username(), password, null));

      customer.getUser().setCustomer(customer);
      customerRepository.save(customer);
      
    return new CustomerDto(customer.getName(), customer.getLastname(), customer.getEmail());
  }

  @Override
  public boolean validUser(UserDto udto) {
    Users user = usersRepository.findByUsername(udto.username())
      .orElseThrow(() -> new RuntimeException("Usuario o contraseña no encontrados"));

    return passwordEncoder.matches(udto.password(), user.getPassword());
  }
}
