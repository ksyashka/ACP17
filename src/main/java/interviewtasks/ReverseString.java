package interviewtasks;

public class ReverseString {


    public static String reverse(String word) {

        if (word == null || word.length() == 1)
            return word;
        return reverse(word.substring(1)) + word.charAt(0);

    }

    public static void main(String[] args) {
        String word = "abcdef";
        String expected = "fedcba";
        String actual = reverse(word);

        System.out.println(expected.equals(actual));
    }


}