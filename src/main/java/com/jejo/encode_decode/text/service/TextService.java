package com.jejo.encode_decode.text.service;

import com.jejo.encode_decode.text.entity.TextEntity;

public interface TextService {
    TextEntity encodeEntity(TextEntity textEntity);
    TextEntity decodeEntity(TextEntity textEntity);
}
