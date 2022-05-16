package com.gemini.hw3;



import androidx.fragment.app.Fragment;

import com.gemini.hw3.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Random;

public class Util extends  Thread {
    private static final String _NUM = "1234567890";
    private static final String _UCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String _LCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String _SYMB = "!@#$%/.";
    private int count = 10;
  private int length = 10;
    public  ArrayList<String> passwords = new ArrayList<String>();


    public Util(int count, int length){
      this.count = count;
      this.length = length;

    }
  private ActivityMainBinding binding;
    @Override
    public void run(){
      System.out.println("Thread started");
      for(int i=0; i<=count; i++) {
        System.out.println("Thread # " + (i +1) + " started");
        Util util =  new Util(count, length);
        passwords.add(util.getPassword(length));
        System.out.println("Password # " + ( i +1) + ": " + passwords.get(i));
        System.out.println("Thread # " + (i +1)+ " ended");
      }
      System.out.println("Thread ended");





    }

    public  String getPassword(int length){
        Random rand = new Random();
        boolean num = true;
        boolean upper = true;
        boolean lower = true;
        boolean special = true;

        String CHAR_SET = "";
        CHAR_SET = CHAR_SET.concat(_NUM); //append numbers to character set
        CHAR_SET = CHAR_SET.concat(_UCASE); //append uppercase
        CHAR_SET = CHAR_SET.concat(_LCASE); //append lowercase
        CHAR_SET = CHAR_SET.concat(_SYMB); //append special characters

        StringBuffer randStr = new StringBuffer();
        for(int i=0; i<length; i++){ //using randomly generated size of password
            int randomIndex = getRandomIndex(CHAR_SET.length()); //get random index
            char ch = CHAR_SET.charAt(randomIndex); //select character at random index
            randStr.append(ch); //append selected character to password substring
        }
        return  randStr.toString(); //return password string
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
