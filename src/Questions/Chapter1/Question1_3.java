package Questions.Chapter1;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
    Given two strings, write a method to decide if one
    is a permutation of the other.

    Case-sensitivity and whitespace?
    Assume strings are case sensitive and whitespace counts.
 */
public class Question1_3 {
    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = isPermutation2(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
    }

    public static String sort(String s) {
        char[] elements = s.toCharArray();
        Arrays.sort(elements);
        return new String(elements);
    }

    public static boolean isPermutation(String s, String t) {
        if (s.length() != t.length()) {
            return false; //Immediate check.
        }
        String sortedS = sort(s);
        String sortedT = sort(t);

        // You can do this as well
        // Lists use Collections.sort(), Arrays use Arrays.sort()
//        List<String> listS = Arrays.asList(s.split(""));
//        List<String> listT = Arrays.asList(t.split(""));
//        Collections.sort(listS);
//        Collections.sort(listT);
//        return listS.equals(listT);

        return sortedS.equals(sortedT);
    }

    public static boolean isPermutation2(String s, String t) {
        if (s.length() != t.length()) {
            return false; //Immediate check.
        }
        int[] letters = new int[128]; // Regular ASCII set.
        // Add first word into char array
        char[] s_array = s.toCharArray();
        for (char c : s_array) { // count number of each char in s.
            letters[c]++;
        }
        // Iterate over second word and check against char array
        for (int i = 0; i < t.length(); i++) {
            int c = (int) t.charAt(i);
            if (--letters[c] < 0) { // Subtract each found letter.
                return false;
            }
        }
        return true;
    }
}
