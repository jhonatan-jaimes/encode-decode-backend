package com.jejo.encode_decode.text.maps;

import java.util.HashMap;
import java.util.Map;

public class BibliotecaGeneral {
    public static final Map<Character, String> bibliotecaGeneralL = new HashMap<>();

    static {
        // Números a dos letras
        bibliotecaGeneralL.put('1', "aa");
        bibliotecaGeneralL.put('2', "ah");
        bibliotecaGeneralL.put('3', "ao");
        bibliotecaGeneralL.put('4', "aw");
        bibliotecaGeneralL.put('5', "be");
        bibliotecaGeneralL.put('6', "bm");
        bibliotecaGeneralL.put('7', "bt");
        bibliotecaGeneralL.put('8', "cc");
        bibliotecaGeneralL.put('9', "ck");

        // Letras minúsculas a dos letras
        bibliotecaGeneralL.put('a', "cr");
        bibliotecaGeneralL.put('b', "cz");
        bibliotecaGeneralL.put('c', "dh");
        bibliotecaGeneralL.put('d', "do");
        bibliotecaGeneralL.put('e', "dw");
        bibliotecaGeneralL.put('f', "ee");
        bibliotecaGeneralL.put('g', "em");
        bibliotecaGeneralL.put('h', "et");
        bibliotecaGeneralL.put('i', "fc");
        bibliotecaGeneralL.put('j', "fk");
        bibliotecaGeneralL.put('k', "fr");
        bibliotecaGeneralL.put('l', "fz");
        bibliotecaGeneralL.put('m', "gh");
        bibliotecaGeneralL.put('n', "go");
        bibliotecaGeneralL.put('ñ', "gw");
        bibliotecaGeneralL.put('o', "he");
        bibliotecaGeneralL.put('p', "hm");
        bibliotecaGeneralL.put('q', "ht");
        bibliotecaGeneralL.put('r', "ic");
        bibliotecaGeneralL.put('s', "ik");
        bibliotecaGeneralL.put('t', "ir");
        bibliotecaGeneralL.put('u', "iz");
        bibliotecaGeneralL.put('v', "jh");
        bibliotecaGeneralL.put('w', "jo");
        bibliotecaGeneralL.put('x', "jw");
        bibliotecaGeneralL.put('y', "ke");
        bibliotecaGeneralL.put('z', "km");

        // Letras mayúsculas a dos letras
        bibliotecaGeneralL.put('A', "kt");
        bibliotecaGeneralL.put('B', "lc");
        bibliotecaGeneralL.put('C', "lk");
        bibliotecaGeneralL.put('D', "lr");
        bibliotecaGeneralL.put('E', "lz");
        bibliotecaGeneralL.put('F', "mh");
        bibliotecaGeneralL.put('G', "mo");
        bibliotecaGeneralL.put('H', "mw");
        bibliotecaGeneralL.put('I', "ne");
        bibliotecaGeneralL.put('J', "nm");
        bibliotecaGeneralL.put('K', "nt");
        bibliotecaGeneralL.put('L', "oc");
        bibliotecaGeneralL.put('M', "ok");
        bibliotecaGeneralL.put('N', "or");
        bibliotecaGeneralL.put('Ñ', "oz");
        bibliotecaGeneralL.put('O', "ph");
        bibliotecaGeneralL.put('P', "po");
        bibliotecaGeneralL.put('Q', "pw");
        bibliotecaGeneralL.put('R', "qe");
        bibliotecaGeneralL.put('S', "qm");
        bibliotecaGeneralL.put('T', "qt");
        bibliotecaGeneralL.put('U', "rc");
        bibliotecaGeneralL.put('V', "rk");
        bibliotecaGeneralL.put('W', "rr");
        bibliotecaGeneralL.put('X', "rz");
        bibliotecaGeneralL.put('Y', "sh");
        bibliotecaGeneralL.put('Z', "so");

        // Símbolos a dos letras
        bibliotecaGeneralL.put('!', "sw");
        bibliotecaGeneralL.put('#', "te");
        bibliotecaGeneralL.put('$', "tm");
        bibliotecaGeneralL.put('%', "tt");
        bibliotecaGeneralL.put('&', "uc");
        bibliotecaGeneralL.put('*', "uk");
        bibliotecaGeneralL.put('+', "ur");
        bibliotecaGeneralL.put('-', "uz");
        bibliotecaGeneralL.put('=', "vh");
        bibliotecaGeneralL.put('?', "vo");
        bibliotecaGeneralL.put('@', "vw");
        bibliotecaGeneralL.put('^', "ve");
        bibliotecaGeneralL.put('_', "vm");
        bibliotecaGeneralL.put(' ', "vt");

    }
    // para acceder a los valores
    public static String getValue(char key) {
        return bibliotecaGeneralL.get(key);
    }
}

