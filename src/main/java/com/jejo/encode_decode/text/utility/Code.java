package com.jejo.encode_decode.text.utility;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Code {
    private final Map<Integer, String> codeRandom = new HashMap<>();

    public Code() {
        codeRandom.put(0,"123");
        codeRandom.put(1,"135");
        codeRandom.put(2,"159");
        codeRandom.put(3,"139");
        codeRandom.put(4,"157");
    }

    public String codeRandom(){
        Random random = new Random();
        int aleatorio = random.nextInt(5);
        return codeRandom.get(aleatorio);
    }
}
