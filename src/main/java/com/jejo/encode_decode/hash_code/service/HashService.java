package com.jejo.encode_decode.hash_code.service;

import com.jejo.encode_decode.hash_code.dto.HashDto;
import com.jejo.encode_decode.hash_code.dto.HashOutDot;

public interface HashService {
  HashOutDot getHash(HashDto hashDto);
}
