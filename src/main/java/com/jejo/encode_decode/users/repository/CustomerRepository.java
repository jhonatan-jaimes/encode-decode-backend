package com.jejo.encode_decode.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jejo.encode_decode.users.customer.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
  
}
