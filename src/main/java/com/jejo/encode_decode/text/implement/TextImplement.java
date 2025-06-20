package com.jejo.encode_decode.text.implement;

import com.jejo.encode_decode.text.entity.TextEntity;
import com.jejo.encode_decode.text.maps.BibliotecaGeneral;
import com.jejo.encode_decode.text.maps.CharacterToNumber;
import com.jejo.encode_decode.text.maps.NumberToCharacter;
import com.jejo.encode_decode.text.service.TextService;
import com.jejo.encode_decode.text.utility.Code;
import org.springframework.stereotype.Service;

@Service
public class TextImplement implements TextService {

    private final Code code = new Code();

    @Override
    public TextEntity encodeEntity(TextEntity text) {
        TextEntity textEntity = new TextEntity();

        if (text == null || text.getText().isEmpty()) {
            textEntity.setText("El texto no puede ser vacío.");
            return textEntity;
        }

        String randomCode = code.codeRandom();
        String combined = randomCode + text.getText();
        StringBuilder finalText = new StringBuilder();

        for (char c : combined.toCharArray()) {
            String encodeValue = BibliotecaGeneral.getValue(c);
            if (encodeValue == null) {
                textEntity.setText("El símbolo '" + c + "' no tiene un mapeo definido.");
                return textEntity;
            }
            for (char i : encodeValue.toCharArray()) {
                String enVal = CharacterToNumber.getNumero(i);
                if (enVal == null) {
                    textEntity.setText("El carácter '" + i + "' no tiene un número mapeado.");
                    return textEntity;
                }
                int multiplied = Integer.parseInt(enVal) * Integer.parseInt(randomCode);
                String multipliedStr = String.valueOf(multiplied);
                for (int x = 0; x < multipliedStr.length(); x += 2) {
                    int endIndex = Math.min(x + 2, multipliedStr.length());
                    String pair = multipliedStr.substring(x, endIndex);
                    String mappedChar = NumberToCharacter.obtenerCaracter(pair);
                    finalText.append(mappedChar != null ? mappedChar : pair);
                }
            }
        }

        textEntity.setText(finalText.toString());
        return textEntity;
    }

    @Override
    public TextEntity decodeEntity(TextEntity text) {
        return null;
    }

}
