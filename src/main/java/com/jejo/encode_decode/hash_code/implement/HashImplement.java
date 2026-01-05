package com.jejo.encode_decode.hash_code.implement;

import com.jejo.encode_decode.hash_code.dto.HashDto;
import com.jejo.encode_decode.hash_code.dto.HashOutDot;
import com.jejo.encode_decode.hash_code.service.HashService;
import com.jejo.encode_decode.utility.HashUtility;
import org.springframework.stereotype.Service;

@Service
public class HashImplement implements HashService {

  @Override
  public HashOutDot getHash(HashDto hashDto) {

    return new HashOutDot(HashUtility.hash(hashDto.lenght()));
  }
}
