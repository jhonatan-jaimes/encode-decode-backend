package com.jejo.encode_decode.service;

import com.jejo.encode_decode.entity.DecodeEntity;
import com.jejo.encode_decode.entity.EncodeEntity;

public interface TextService {
    EncodeEntity encodeEntity(EncodeEntity encodeEntity);
    DecodeEntity decodeEntity(DecodeEntity decodeEntity);
}
