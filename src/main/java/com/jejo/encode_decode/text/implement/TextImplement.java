package com.jejo.encode_decode.text.implement;

import com.jejo.encode_decode.text.entity.TextEntity;
import com.jejo.encode_decode.text.maps.*;
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
            String encodeValue = CharacterToCode.getValue(c);
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
                int blockSize = 2;
                for (int x = 0; x < multipliedStr.length(); x += blockSize) {
                    int endIndex = Math.min(x + blockSize, multipliedStr.length());
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
        TextEntity textEntity = new TextEntity();

        if (text == null || text.getText().isEmpty()) {
            textEntity.setText("El texto no puede ser vacío.");
            return textEntity;
        }

        String finalText = "";
        String codeEncode = "";
        for (Character c : text.getText().toCharArray()){
            String n1 = SimbolToNumber.obtenerNumero(c.toString());
            if(n1 != null){
                codeEncode += n1;
            } else {
                codeEncode += c.toString();
            }
        }

        String numEncode = "";
        int blockSize = 4;
        Integer divisor = Integer.parseInt(codeEncode.substring(0,blockSize)) / 10;
        for (int i = 0; i < codeEncode.length(); i += blockSize){
            int block = Math.min(i + blockSize, codeEncode.length());
            String sub = codeEncode.substring(i, block);
            int numero = Integer.parseInt(sub) / divisor;
            numEncode += NumberToCharacter.obtenerCaracter(String.valueOf(numero));
        }

        blockSize = 2;
        for(int j = 0; j < numEncode.length(); j += blockSize){
            int block = Math.min(j + blockSize, numEncode.length());
            String sub = numEncode.substring(j, block);
            finalText += CodeToCharacter.getValue(sub);
        }

        finalText = finalText.replace(divisor.toString(), "");

        textEntity.setText(finalText);

        return textEntity;
    }

}
