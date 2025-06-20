package com.jejo.encode_decode.maps;

import java.util.HashMap;
import java.util.Map;

public class ChatacterToNumber {
    public static final Map<Character, String> characterToNumber = new HashMap<>();
    static {
        // Letras minúsculas a números (como Strings)
        characterToNumber.put('a', "10");
        characterToNumber.put('b', "11");
        characterToNumber.put('c', "12");
        characterToNumber.put('d', "13");
        characterToNumber.put('e', "14");
        characterToNumber.put('f', "15");
        characterToNumber.put('g', "16");
        characterToNumber.put('h', "17");
        characterToNumber.put('i', "18");
        characterToNumber.put('j', "19");
        characterToNumber.put('k', "20");
        characterToNumber.put('l', "21");
        characterToNumber.put('m', "22");
        characterToNumber.put('n', "23");
        characterToNumber.put('ñ', "24");
        characterToNumber.put('o', "25");
        characterToNumber.put('p', "26");
        characterToNumber.put('q', "27");
        characterToNumber.put('r', "28");
        characterToNumber.put('s', "29");
        characterToNumber.put('t', "30");
        characterToNumber.put('u', "31");
        characterToNumber.put('v', "32");
        characterToNumber.put('w', "33");
        characterToNumber.put('x', "34");
        characterToNumber.put('y', "35");
        characterToNumber.put('z', "36");
    }

    public static String getNumero(char letra) {
        return characterToNumber.get(letra);
    }

}
