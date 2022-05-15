public class LRS {

  public static void main(String[] args) {
    String word = "ABABBAABAA";
    String subString = "";

    for (int i = word.length() - 1; i > 0; i--) {
      subString = word.substring(word.length() - i).toLowerCase();
      word = word.toLowerCase();

      String temp = word.replaceFirst(subString, "");
      if (temp.contains(subString)) {

        System.out.println(subString);
        break;
      }

    }

  }

}
