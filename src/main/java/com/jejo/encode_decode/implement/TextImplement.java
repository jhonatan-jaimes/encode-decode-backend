package com.jejo.encode_decode.implement;

import com.jejo.encode_decode.entity.DecodeEntity;
import com.jejo.encode_decode.entity.EncodeEntity;
import com.jejo.encode_decode.maps.BibliotecaGeneral;
import com.jejo.encode_decode.maps.ChatacterToNumber;
import com.jejo.encode_decode.maps.NumberToCharacter;
import com.jejo.encode_decode.service.TextService;
import com.jejo.encode_decode.utility.Code;
import org.springframework.stereotype.Service;

@Service
public class TextImplement implements TextService {

    private final Code code = new Code();

    @Override
    public EncodeEntity encodeEntity(EncodeEntity text) {
        // Creo la entidad que voy a devolver en mi controlador
        EncodeEntity encodeEntity = new EncodeEntity();
        // Compruebo si el texto que se envia no este vacio
        if(text == null || text.getText().isEmpty()){
            encodeEntity.setText("El texto no puede ser vacio.");
            return encodeEntity;
        }
        // Creo un StringBuilder para poder unir el codigo de encriptacion al texto que viene del frontend
        StringBuilder str = new StringBuilder();
        // Busco el codigo ramdom {"123", "135", "159", "139", "157"} y este se une al texto a encode
        String ramdomCode = code.codeRamdom();
        // Se une el codigo ramdom al str
        str.append(ramdomCode);
        // Se une el texto al codigo ramdom para que ambos sean encode
        str.append(text.getText());
        // Se convierte el str(StringBuilder) a string y se separa en caracteres
        char[] spell = str.toString().toCharArray();
        // Creo un nuevo StringBuilder para usar al final
        StringBuilder newText = new StringBuilder();
        // El primer for empieza a recorrer las palabras
        for (char c : spell){
            // Obtengo el valor de la primera letra almacenada en la biblioteca general
            String encodeValue = BibliotecaGeneral.getValue(c);
            // se verifica que el objeto no es null
            if(encodeValue == null){
                encodeEntity.setText("El símbolo '" + c + "' no tiene un mapeo definido.");
                return encodeEntity;
            // Si el string no es null sigue la ejecucion
            }else {
                // Creo otro StringBuilder, ya que necesito encadenar strings
                StringBuilder nt1 = new StringBuilder();
                // Se añade el primer string al StringBuilder después de validar
                nt1.append(encodeValue);
                // Se convierte el stringBuilder a string otra vez
                String tx = nt1.toString();
                // Se separan las letras nuevamente de la variable tx
                char[] spll = tx.toCharArray();
                // Creo un nuevo for para recorrer de nuevo letra a letra
                for (char i : spll){
                    // Nuevo stringBuilder para encadenar strings
                    StringBuilder nt2 = new StringBuilder();
                    // Se obtiene el valor del primer char que recorremos
                    String enVal = ChatacterToNumber.getNumero(i);
                    // Este valor se encadena al stringBuilder
                    nt2.append(enVal);
                    // Se hacen dos cosas, una convertir el string a numero y se multiplica por el codeRamdom
                    int n = Integer.parseInt(nt2.toString()) * Integer.parseInt(ramdomCode);
                    // Se vuelve a convertir el resultado a string nuevamente "Es un numero"
                    String l = String.valueOf(n);
                    // En este último recorrido se hace para transformar los numeros a letras
                    for(int x = 0; x < l.length(); x+=2){
                        // Se separa cuantos index va a obtener del string
                        int indexs = Math.min(x + 2, l.length());
                        // Se obtienen los dos primeros numeros del string y luego los dos numeros
                        String par = l.substring(x, indexs);
                        // Buscamos el numero en la biblioteca para para colocar la letra que le corresponde
                        String cb = NumberToCharacter.obtenerCaracter(par);
                        // Si el numero no se encuentra en la biblioteca se mapea directamente el numero
                        if (cb == null){
                            newText.append(par);
                        // De lo contrario se mapea la letra que viene de la biblioteca
                        } else {
                            newText.append(cb);
                        }
                    }
                }
            }
        }
        // Se introduce el stringBuilder a la entidad y lo convertimos con toString y lo retornamos al frontend
        encodeEntity.setText(newText.toString());
        // Se devuelve la entidad
        return encodeEntity;
    }

    @Override
    public DecodeEntity decodeEntity(DecodeEntity decodeEntity) {
        return null;
    }

}
