package com.jejo.encode_decode.text.service;

import com.jejo.encode_decode.text.dto.TextDto;
import com.jejo.encode_decode.text.entity.TextEntity;

public interface TextService {

    // Metodo que al momento de implementar devuelve el texto codificado.
    TextEntity encodeEntity(TextDto textEntity);

    // Metodo que al implementar devuelve el texto decodificado.
    TextEntity decodeEntity(TextDto textEntity);
}
