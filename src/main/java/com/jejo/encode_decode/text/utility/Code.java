package com.jejo.encode_decode.text.utility;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Code {

    /*
     * Mapa de diferentes tipos de multiplicacion con el cual el código se va a codificar los numeros del
     * encode, para tener guardado en el hash para luego decodificarlo.
     * */
    private final Map<Integer, Integer> codeRandom = new HashMap<>();

    public Code() {
        codeRandom.put(0,121);
        codeRandom.put(1,123);
        codeRandom.put(2,125);
        codeRandom.put(3,127);
        codeRandom.put(4,129);
        codeRandom.put(5,141);
        codeRandom.put(6,143);
        codeRandom.put(7,145);
        codeRandom.put(8,147);
        codeRandom.put(9,149);
        codeRandom.put(10,161);
        codeRandom.put(11,163);
        codeRandom.put(12,165);
        codeRandom.put(13,167);
        codeRandom.put(14,169);
        codeRandom.put(15,181);
        codeRandom.put(16,183);
        codeRandom.put(17,185);
        codeRandom.put(18,187);
        codeRandom.put(19,189);
    }

    /*
    * Metodo que me devuelve l codigo con el que se va a codificar el texto.
    * */
    public int codeRandom(){
        Random random = new Random();
        int aleatorio = random.nextInt(20);
        return codeRandom.get(aleatorio);
    }
}
