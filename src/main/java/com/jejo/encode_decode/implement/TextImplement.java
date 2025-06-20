package com.jejo.encode_decode.implement;

import com.jejo.encode_decode.entity.DecodeEntity;
import com.jejo.encode_decode.entity.EncodeEntity;
import com.jejo.encode_decode.maps.BibliotecaGeneral;
import com.jejo.encode_decode.maps.ChatacterToNumber;
import com.jejo.encode_decode.maps.NumberToCharacter;
import com.jejo.encode_decode.service.TextService;
import com.jejo.encode_decode.utility.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TextImplement implements TextService {

    private final Code code = new Code();

    @Override
    public EncodeEntity encodeEntity(EncodeEntity text) {
        EncodeEntity encodeEntity = new EncodeEntity();
        if(text == null || text.getText().isEmpty()){
            encodeEntity.setText("El texto no puede ser vacio.");
            return encodeEntity;
        }
        StringBuilder str = new StringBuilder();
        String ramdomCode = code.codeRamdom();
        str.append(ramdomCode);
        str.append(text.getText());
        char[] spell = str.toString().toCharArray();
        StringBuilder newText = new StringBuilder();
        for (char c : spell){
            String encodeValue = BibliotecaGeneral.getValue(c);
            if(encodeValue == null){
                encodeEntity.setText("El símbolo '" + c + "' no tiene un mapeo definido.");
                return encodeEntity;
            }else {
                StringBuilder nt1 = new StringBuilder();
                nt1.append(encodeValue);
                String tx = nt1.toString();
                char[] spll = tx.toCharArray();
                for (char i : spll){
                    StringBuilder nt2 = new StringBuilder();
                    String enVal = ChatacterToNumber.getNumero(i);
                    nt2.append(enVal);
                    int n = Integer.parseInt(nt2.toString()) * Integer.parseInt(ramdomCode);
                    String l = String.valueOf(n);
                    for(int x = 0; x < l.length(); x+=2){
                        int indexs = Math.min(x + 2, l.length());
                        String par = l.substring(x, indexs);
                        String cb = NumberToCharacter.obtenerCaracter(par);
                        if (cb == null){
                            newText.append(par);
                        } else {
                            newText.append(cb);
                        }
                    }
                }
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
