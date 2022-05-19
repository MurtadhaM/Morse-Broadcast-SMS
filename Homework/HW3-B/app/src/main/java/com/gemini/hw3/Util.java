package com.gemini.hw3;
/**
 * Murtadha Marzouq
 */

import java.util.Random;

public class Util {
  private static final String _NUM = "1234567890";
  private static final String _UCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final String _LCASE = "abcdefghijklmnopqrstuvwxyz";
  private static final String _SYMB = "!@#$%/.";

  public static String getPassword(int length){
    Random rand = new Random();
    boolean num = true;
    boolean upper = true;
    boolean lower = true;
    boolean special = true;

    String CHAR_SET = "";
    CHAR_SET = CHAR_SET.concat(_NUM);
    CHAR_SET = CHAR_SET.concat(_UCASE);
    CHAR_SET = CHAR_SET.concat(_LCASE);
    CHAR_SET = CHAR_SET.concat(_SYMB);

    StringBuffer randStr = new StringBuffer();
    for(int i=0; i<length; i++){
      int randomIndex = getRandomIndex(CHAR_SET.length());
      char ch = CHAR_SET.charAt(randomIndex);
      randStr.append(ch);
    }
    return  randStr.toString();
  }

  private static int getRandomIndex(int len){
    Random rand = new Random();
    int randomInt = 0;
    for(int i=0; i<10000; i++){
      for(int j=0; j<1000;j++){
        randomInt = rand.nextInt(len);
      }
    }
    return randomInt;
  }

}
