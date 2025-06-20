package com.jejo.encode_decode.utility;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Code {
    private final Map<Integer, String> codeRamdom = new HashMap<>();

    public Code() {
        codeRamdom.put(0,"123");
        codeRamdom.put(1,"135");
        codeRamdom.put(2,"159");
        codeRamdom.put(3,"139");
        codeRamdom.put(4,"157");
    }

    public String codeRamdom(){
        Random random = new Random();
        int aleatorio = random.nextInt(5);
        return codeRamdom.get(aleatorio);
    }
}
