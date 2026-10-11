package com.jejo.encode_decode.hash_code;

import com.jejo.encode_decode.hash_code.dto.HashDto;
import com.jejo.encode_decode.hash_code.dto.HashOutDot;

public interface HashService {
  HashOutDot getHash(HashDto hashDto);
}
