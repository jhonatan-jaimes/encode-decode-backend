package com.jejo.encode_decode.text.maps;

import java.util.HashMap;
import java.util.Map;

public class CodeToCharacter {
    public static final Map<String, Character> codeToCharacter = new HashMap<>();

    static {
        // Números invertidos
        codeToCharacter.put("vq", '0');
        codeToCharacter.put("aa", '1');
        codeToCharacter.put("ah", '2');
        codeToCharacter.put("ao", '3');
        codeToCharacter.put("aw", '4');
        codeToCharacter.put("be", '5');
        codeToCharacter.put("bm", '6');
        codeToCharacter.put("bt", '7');
        codeToCharacter.put("cc", '8');
        codeToCharacter.put("ck", '9');

        // Letras minúsculas invertidas
        codeToCharacter.put("cr", 'a');
        codeToCharacter.put("cz", 'b');
        codeToCharacter.put("dh", 'c');
        codeToCharacter.put("do", 'd');
        codeToCharacter.put("dw", 'e');
        codeToCharacter.put("ee", 'f');
        codeToCharacter.put("em", 'g');
        codeToCharacter.put("et", 'h');
        codeToCharacter.put("fc", 'i');
        codeToCharacter.put("fk", 'j');
        codeToCharacter.put("fr", 'k');
        codeToCharacter.put("fz", 'l');
        codeToCharacter.put("gh", 'm');
        codeToCharacter.put("go", 'n');
        codeToCharacter.put("gw", 'ñ');
        codeToCharacter.put("he", 'o');
        codeToCharacter.put("hm", 'p');
        codeToCharacter.put("ht", 'q');
        codeToCharacter.put("ic", 'r');
        codeToCharacter.put("ik", 's');
        codeToCharacter.put("ir", 't');
        codeToCharacter.put("iz", 'u');
        codeToCharacter.put("jh", 'v');
        codeToCharacter.put("jo", 'w');
        codeToCharacter.put("jw", 'x');
        codeToCharacter.put("ke", 'y');
        codeToCharacter.put("km", 'z');

        // Letras mayúsculas invertidas
        codeToCharacter.put("kt", 'A');
        codeToCharacter.put("lc", 'B');
        codeToCharacter.put("lk", 'C');
        codeToCharacter.put("lr", 'D');
        codeToCharacter.put("lz", 'E');
        codeToCharacter.put("mh", 'F');
        codeToCharacter.put("mo", 'G');
        codeToCharacter.put("mw", 'H');
        codeToCharacter.put("ne", 'I');
        codeToCharacter.put("nm", 'J');
        codeToCharacter.put("nt", 'K');
        codeToCharacter.put("oc", 'L');
        codeToCharacter.put("ok", 'M');
        codeToCharacter.put("or", 'N');
        codeToCharacter.put("oz", 'Ñ');
        codeToCharacter.put("ph", 'O');
        codeToCharacter.put("po", 'P');
        codeToCharacter.put("pw", 'Q');
        codeToCharacter.put("qe", 'R');
        codeToCharacter.put("qm", 'S');
        codeToCharacter.put("qt", 'T');
        codeToCharacter.put("rc", 'U');
        codeToCharacter.put("rk", 'V');
        codeToCharacter.put("rr", 'W');
        codeToCharacter.put("rz", 'X');
        codeToCharacter.put("sh", 'Y');
        codeToCharacter.put("so", 'Z');

        // Símbolos invertidos
        codeToCharacter.put("sw", '!');
        codeToCharacter.put("te", '#');
        codeToCharacter.put("tm", '$');
        codeToCharacter.put("tt", '%');
        codeToCharacter.put("uc", '&');
        codeToCharacter.put("uk", '*');
        codeToCharacter.put("ur", '+');
        codeToCharacter.put("uz", '-');
        codeToCharacter.put("vh", '=');
        codeToCharacter.put("vo", '?');
        codeToCharacter.put("vw", '@');
        codeToCharacter.put("ve", '^');
        codeToCharacter.put("vm", '_');
        codeToCharacter.put("vt", ' ');
    }

    /*
     * Metodo que recive un parametro desde la implementacion lo busca en la biblioteca y
     * devuelve el valor.
     * */
    public static Character getValue(String key) {
        return codeToCharacter.get(key);
    }
}
