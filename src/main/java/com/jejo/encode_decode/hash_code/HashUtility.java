package com.jejo.encode_decode.hash_code;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HashUtility {
  /*
   * Una lista con los caracteres a utilizar para la creacion de los hash que ban en el short-link,
   * van de 0 - 9, a - z, A - Z excluyendo la "ñ, Ñ", o vocales con tilde.
   * */
  private final List<String> charUtb = new ArrayList<>();

  public HashUtility() {
    for (char chr = '0'; chr <= '9'; chr++) {
      charUtb.add(String.valueOf(chr));
    }

    for (char chr = 'a'; chr <= 'z'; chr++) {
      charUtb.add(String.valueOf(chr));
    }

    for (char chr = 'A'; chr <= 'Z'; chr++) {
      charUtb.add(String.valueOf(chr));
    }
  }

  /*
   * Metodo statico que le crea un hash de 8 caracteres con la biblioteca de arriba, devuelve el hash
   * pasa ser incorporado al short-link.
   * */
  public String hash(int lenght){
    Random random = new Random();
    StringBuilder hash = new StringBuilder();
    for (int i = 0; i < lenght; i++) {
      hash.append(charUtb.get(random.nextInt(62)));
    }
    return hash.toString();
  }
}
