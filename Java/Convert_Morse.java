import java.util.*;

public class Convert_Morse {



    public static void main(String[] args) {
        // Debugging
        System.out.println(convertToString("... --- ..."));
        System.out.println(convertToDots(convertToString("... --- ...")));
        System.out.println(convertToDots( "TEST TEST TEST 212 @12"));

    }
 
    public static Character lookup(String m) {
        // takes in a morse code string and returns the corresponding character
        // if the morse code string is not in the morse code dictionary, return null
        // if the morse code string is in the morse code dictionary, return the corresponding character
        for (Character key : morseCode.keySet()) {
            if ( morseCode.get(key).equals(m) ) {
                return key;
            }
        }
        return ' ';
    }
    // convert dots and dashes to letters given a string of dots and dashes
    public static String convertToString(String message) {
        //  for each word in the message, look up the corresponding morse code
        //  and add the letter to the result
        String[] words = message.split(" ");
        String result = "";
        for (String word : words) {
            result += lookup(word);
        }
        return result;


    }

    public static String convertToDots(String message) {
        StringBuilder sb = new StringBuilder();
        for (char i : message.toLowerCase().toCharArray()) {
            String morsed = morseCode.get(i);
            if (morsed != null ) {
                sb.append(morsed).append(" ");
            } else {
                sb.append("|");
            }
        }
        return sb.toString();
    }
    // Create a Hashmape of morse code characters
    public static HashMap<Character, String> morseCode = new HashMap<Character, String>();
    static {
        morseCode.put('a', ".-");
        morseCode.put('b', "-...");
        morseCode.put('c', "-.-.");
        morseCode.put('d', "-..");
        morseCode.put('e', ".");
        morseCode.put('f', "..-.");
        morseCode.put('g', "--.");
        morseCode.put('h', "....");
        morseCode.put('i', "..");
        morseCode.put('j', ".---");
        morseCode.put('k', "-.-");
        morseCode.put('l', ".-..");
        morseCode.put('m', "--");
        morseCode.put('n', "-.");
        morseCode.put('o', "---");
        morseCode.put('p', ".--.");
        morseCode.put('q', "--.-");
        morseCode.put('r', ".-.");
        morseCode.put('s', "...");
        morseCode.put('t', "-");
        morseCode.put('u', "..-");
        morseCode.put('v', "...-");
        morseCode.put('w', ".--");
        morseCode.put('x', "-..-");
        morseCode.put('y', "-.--");
        morseCode.put('z', "--..");
        morseCode.put('1', ".----");
        morseCode.put('2', "..---");
        morseCode.put('3', "...--");
        morseCode.put('4', "....-");
        morseCode.put('5', ".....");
        morseCode.put('6', "-....");
        morseCode.put('7', "--...");
        morseCode.put('8', "---..");
        morseCode.put('9', "----.");
        morseCode.put('0', "-----");
        morseCode.put('.', ".-.-.-");
        morseCode.put(',', "-..--");
        morseCode.put('?', "..--..");
        morseCode.put('/', "-..-.");
        morseCode.put('\'', ".----.");
        morseCode.put('!', "-.-.--");
        morseCode.put('(', "-.--.");
        morseCode.put(')', "-.--.-");
        morseCode.put('&', ".-...");
        morseCode.put(':', "---...");
        morseCode.put(';', "-.-.-.");
        morseCode.put('=', "-...-");
        morseCode.put('+', ".-.-.");
        morseCode.put('-', "-....-");
        morseCode.put('_', "..--.-");
        morseCode.put('\"', ".-..-.");
        morseCode.put('$', "...-..-");
        morseCode.put('@', ".--.-.");
        morseCode.put('à', ".--.-");
        morseCode.put('ä', ".-.-");
        morseCode.put('å', ".--.-");
        morseCode.put('æ', ".-.-");
        morseCode.put('ć', "-.-..");
        morseCode.put('ĉ', "-.-..");
        morseCode.put('ç', "-.-..");
        morseCode.put('đ', "..-..");
        morseCode.put('ð', "..--.");
        morseCode.put('é', "..-..");
        morseCode.put('è', ".-..-");
        morseCode.put('ę', "..-..");
        morseCode.put('ĝ', "--.-.");
        morseCode.put('ĥ', "----");
        morseCode.put('ĵ', ".---.");
        morseCode.put('ł', ".-..-");
        morseCode.put('ń', "--.--");
        morseCode.put('ñ', "--.--");
        morseCode.put('ó', "---.");
        morseCode.put('ö', "---.");
        morseCode.put('ø', "---.");
        morseCode.put('ś', "...-...");
        morseCode.put('ŝ', "...-.");
        morseCode.put('š', "----");
        morseCode.put('þ', ".--..");
        morseCode.put('ü', "..--");
        morseCode.put('ŭ', "..--");
        morseCode.put('ź', "--..-.");
        morseCode.put('ż', "--..-");


    }






}