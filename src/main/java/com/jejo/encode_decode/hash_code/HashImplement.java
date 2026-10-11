package com.jejo.encode_decode.hash_code;

import com.jejo.encode_decode.hash_code.dto.HashDto;
import com.jejo.encode_decode.hash_code.dto.HashOutDot;
import org.springframework.stereotype.Service;

@Service
public class HashImplement implements HashService {

  private final HashUtility hashUtility;

  public HashImplement() {
    hashUtility = new HashUtility();
  }

  @Override
  public HashOutDot getHash(HashDto hashDto) {

    return new HashOutDot(hashUtility.hash(hashDto.value()));
  }
}
