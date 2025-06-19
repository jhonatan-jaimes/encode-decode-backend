package com.jejo.encode_decode.implement;

import com.jejo.encode_decode.entity.DecodeEntity;
import com.jejo.encode_decode.entity.EncodeEntity;
import com.jejo.encode_decode.maps.BibliotecaGeneral;
import com.jejo.encode_decode.service.TextService;
import org.springframework.stereotype.Service;

@Service
public class TextImplement implements TextService {

    @Override
    public EncodeEntity encodeEntity(EncodeEntity text) {
        EncodeEntity encodeEntity = new EncodeEntity();
        if(text == null || text.getText().isEmpty()){
            encodeEntity.setText("El texto no puede ser vacio.");
            return encodeEntity;
        }
        char[] spell = text.getText().toCharArray();
        StringBuilder newText = new StringBuilder();
        for (char c : spell){
            String encodeValue = BibliotecaGeneral.getValue(c);
            if(encodeValue == null){
                encodeEntity.setText("El símbolo '" + c + "' no tiene un mapeo definido.");
                return encodeEntity;
            }else {
                newText.append(encodeValue);
            }
        }
        encodeEntity.setText(newText.toString());
        return encodeEntity;
    }

    @Override
    public DecodeEntity decodeEntity(DecodeEntity decodeEntity) {
        return null;
    }

}
