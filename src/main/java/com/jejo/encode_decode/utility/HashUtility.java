package com.jejo.encode_decode.utility;

import com.jejo.encode_decode.hash_code.dto.HashDto;

import java.util.List;
import java.util.Random;

public class HashUtility {
  /*
   * Una lista con los caracteres a utilizar para la creacion de los hash que ban en el short-link,
   * van de 0 - 9, a - z, A - Z excluyendo la "ñ, Ñ", o vocales con tilde.
   * */
  private static final List<String> charUtb = List.of(
      "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
      "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
      "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
      "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
      "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
  );

  /*
   * Metodo statico que le crea un hash de 8 caracteres con la biblioteca de arriba, devuelve el hash
   * pasa ser incorporado al short-link.
   * */
  public static String hash(int lenght){
    Random random = new Random();
    StringBuilder hash = new StringBuilder();
    for (int i = 0; i < lenght; i++) {
      hash.append(charUtb.get(random.nextInt(62)));
    }
    return hash.toString();
  }
}
