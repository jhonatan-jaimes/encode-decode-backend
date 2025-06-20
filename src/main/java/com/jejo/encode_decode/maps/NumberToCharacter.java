package com.jejo.encode_decode.maps;

import java.util.HashMap;
import java.util.Map;

public class NumberToCharacter {
    public static final Map<String, String> numberToCharacter = new HashMap<>();

    static {
        // Letras minúsculas
        numberToCharacter.put("10", "a");
        numberToCharacter.put("11", "b");
        numberToCharacter.put("12", "c");
        numberToCharacter.put("13", "d");
        numberToCharacter.put("14", "e");
        numberToCharacter.put("15", "f");
        numberToCharacter.put("16", "g");
        numberToCharacter.put("17", "h");
        numberToCharacter.put("18", "i");
        numberToCharacter.put("19", "j");
        numberToCharacter.put("20", "k");
        numberToCharacter.put("21", "l");
        numberToCharacter.put("22", "m");
        numberToCharacter.put("23", "n");
        numberToCharacter.put("24", "ñ");
        numberToCharacter.put("25", "o");
        numberToCharacter.put("26", "p");
        numberToCharacter.put("27", "q");
        numberToCharacter.put("28", "r");
        numberToCharacter.put("29", "s");
        numberToCharacter.put("30", "t");
        numberToCharacter.put("31", "u");
        numberToCharacter.put("32", "v");
        numberToCharacter.put("33", "w");
        numberToCharacter.put("34", "x");
        numberToCharacter.put("35", "y");
        numberToCharacter.put("36", "z");

        // Letras mayúsculas
        numberToCharacter.put("37", "A");
        numberToCharacter.put("38", "B");
        numberToCharacter.put("39", "C");
        numberToCharacter.put("40", "D");
        numberToCharacter.put("41", "E");
        numberToCharacter.put("42", "F");
        numberToCharacter.put("43", "G");
        numberToCharacter.put("44", "H");
        numberToCharacter.put("45", "I");
        numberToCharacter.put("46", "J");
        numberToCharacter.put("47", "K");
        numberToCharacter.put("48", "L");
        numberToCharacter.put("49", "M");
        numberToCharacter.put("50", "N");
        numberToCharacter.put("51", "Ñ");
        numberToCharacter.put("52", "O");
        numberToCharacter.put("53", "P");
        numberToCharacter.put("54", "Q");
        numberToCharacter.put("55", "R");
        numberToCharacter.put("56", "S");
        numberToCharacter.put("57", "T");
        numberToCharacter.put("58", "U");
        numberToCharacter.put("59", "V");
        numberToCharacter.put("60", "W");
        numberToCharacter.put("61", "X");
        numberToCharacter.put("62", "Y");
        numberToCharacter.put("63", "Z");

        // Símbolos
        numberToCharacter.put("64", "!");
        numberToCharacter.put("65", "#");
        numberToCharacter.put("66", "$");
        numberToCharacter.put("67", "%");
        numberToCharacter.put("68", "&");
        numberToCharacter.put("69", "*");
        numberToCharacter.put("70", "+");
        numberToCharacter.put("71", "_");
        numberToCharacter.put("72", "=");
        numberToCharacter.put("73", "?");
        numberToCharacter.put("74", "@");
        numberToCharacter.put("75", "^");
        numberToCharacter.put("76", "-");
    }

    public static String obtenerCaracter(String codigo) {
        return numberToCharacter.get(codigo);
    }
}

