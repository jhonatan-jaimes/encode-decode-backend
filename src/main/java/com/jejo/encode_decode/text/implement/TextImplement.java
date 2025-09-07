package com.jejo.encode_decode.text.implement;

import com.jejo.encode_decode.text.entity.TextEntity;
import com.jejo.encode_decode.text.maps.*;
import com.jejo.encode_decode.text.service.TextService;
import com.jejo.encode_decode.text.utility.Code;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TextImplement implements TextService {

    private final Code code = new Code();

    @Override
    public TextEntity encodeEntity(TextEntity text) {
        TextEntity textEntity = new TextEntity();

        if (text == null || text.getText().isEmpty()) {
            throw new IllegalArgumentException("El texto no puede estar vacio.");
        }

        int randomCode = code.codeRandom();
        String combined = randomCode + text.getText();

        final String encode = Arrays.stream(combined.split(""))
                .map(CharacterToCode::getValue)
                .map(CharacterToNumber::codeToNumber)
                .flatMap(List::stream)
                .map(e -> NumberToCharacter.numberToNumber(e, randomCode))
                .flatMap(e -> Stream.of(e.substring(0,2), e.substring(2,4)))
                .map(NumberToCharacter::obtenerCharacter)
                .collect(Collectors.joining());

        textEntity.setText(encode);
        return textEntity;
    }

    @Override
    public TextEntity decodeEntity(TextEntity text) {
        TextEntity textEntity = new TextEntity();

        if (text == null || text.getText().isEmpty()) {
            throw new IllegalArgumentException("El texto no puede estar vacio.");
        }

        String finalText = "";
        String codeEncode = "";

        for (Character c : text.getText().toCharArray()){
            String n1 = SimbolToNumber.obtenerNumero(c.toString());
            if (n1 == null){
                throw new IllegalArgumentException("Letra no utilizada, " + c + " no existe");
            } else {
                codeEncode += n1;
            }
        }

        String numEncode = "";
        int blockSize = 4;
        int divisor = Integer.parseInt(codeEncode.substring(0,blockSize)) / 10;
        for (int i = 0; i < codeEncode.length(); i += blockSize){
            int block = Math.min(i + blockSize, codeEncode.length());
            String sub = codeEncode.substring(i, block);
            int numero = Integer.parseInt(sub) / divisor;
            numEncode += NumberToCharacter.obtenerCharacter(String.valueOf(numero));
        }

        blockSize = 2;
        for(int j = 0; j < numEncode.length(); j += blockSize){
            int block = Math.min(j + blockSize, numEncode.length());
            String sub = numEncode.substring(j, block);
            if(CodeToCharacter.getValue(sub) == null){
                throw new IllegalArgumentException("No se puede decodificar el texto, " +
                        "no es codificado con este sistema.");
            }
            finalText += CodeToCharacter.getValue(sub);
        }

        finalText = finalText.replace(Integer.toString(divisor), "");

        textEntity.setText(finalText);

        return textEntity;
    }

}
