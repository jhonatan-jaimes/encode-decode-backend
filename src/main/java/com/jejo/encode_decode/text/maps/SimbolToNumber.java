package com.jejo.encode_decode.text.maps;

import java.util.HashMap;
import java.util.Map;

public class SimbolToNumber {
    public static final Map<String, String> simbolToNumber = new HashMap<>();

    static {
        simbolToNumber.put("a", "10");
        simbolToNumber.put("b", "11");
        simbolToNumber.put("c", "12");
        simbolToNumber.put("d", "13");
        simbolToNumber.put("e", "14");
        simbolToNumber.put("f", "15");
        simbolToNumber.put("g", "16");
        simbolToNumber.put("h", "17");
        simbolToNumber.put("i", "18");
        simbolToNumber.put("j", "19");
        simbolToNumber.put("k", "20");
        simbolToNumber.put("l", "21");
        simbolToNumber.put("m", "22");
        simbolToNumber.put("n", "23");
        simbolToNumber.put("ñ", "24");
        simbolToNumber.put("o", "25");
        simbolToNumber.put("p", "26");
        simbolToNumber.put("q", "27");
        simbolToNumber.put("r", "28");
        simbolToNumber.put("s", "29");
        simbolToNumber.put("t", "30");
        simbolToNumber.put("u", "31");
        simbolToNumber.put("v", "32");
        simbolToNumber.put("w", "33");
        simbolToNumber.put("x", "34");
        simbolToNumber.put("y", "35");
        simbolToNumber.put("z", "36");

        simbolToNumber.put("A", "37");
        simbolToNumber.put("B", "38");
        simbolToNumber.put("C", "39");
        simbolToNumber.put("D", "40");
        simbolToNumber.put("E", "41");
        simbolToNumber.put("F", "42");
        simbolToNumber.put("G", "43");
        simbolToNumber.put("H", "44");
        simbolToNumber.put("I", "45");
        simbolToNumber.put("J", "46");
        simbolToNumber.put("K", "47");
        simbolToNumber.put("L", "48");
        simbolToNumber.put("M", "49");
        simbolToNumber.put("N", "50");
        simbolToNumber.put("Ñ", "51");
        simbolToNumber.put("O", "52");
        simbolToNumber.put("P", "53");
        simbolToNumber.put("Q", "54");
        simbolToNumber.put("R", "55");
        simbolToNumber.put("S", "56");
        simbolToNumber.put("T", "57");
        simbolToNumber.put("U", "58");
        simbolToNumber.put("V", "59");
        simbolToNumber.put("W", "60");
        simbolToNumber.put("X", "61");
        simbolToNumber.put("Y", "62");
        simbolToNumber.put("Z", "63");

        simbolToNumber.put("!", "64");
        simbolToNumber.put("#", "65");
        simbolToNumber.put("$", "66");
        simbolToNumber.put("%", "67");
        simbolToNumber.put("&", "68");
        simbolToNumber.put("*", "69");
        simbolToNumber.put("+", "70");
        simbolToNumber.put("_", "71");
        simbolToNumber.put("=", "72");
        simbolToNumber.put("?", "73");
        simbolToNumber.put("@", "74");
        simbolToNumber.put("^", "75");
        simbolToNumber.put("-", "76");

    }

    /*
    * Metodo que recive un parametro desde la implementacion lo busca en la biblioteca y
    * devuelve el valor.
    * */
    public static String obtenerNumero(String codigo) {
        return simbolToNumber.get(codigo);
    }
}
