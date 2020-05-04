package Questions.Chapter1;
/*
    You have a method - isSubstring, which checks if one word is
    a substring of another. Given s1 and s2, see if you can determine
    if s2 is a rotation of s1 with only 1 call to isSubstring.
    "waterbottle" goes with "erbottlewat"
 */
public class Question1_8 {
    public static void main(String[] args) {
        String[][] pairs = {{"waterbottle", "erbottlewat"}};
        for (String[] pair : pairs) {
            String s1 = pair[0];
            String s2 = pair[1];
            boolean is_a_rotation = isRotation(s1, s2);
            System.out.println(is_a_rotation);
        }
    }
    // Rotated words should still be the same length
    // There will be an letterPoint where the rotation occurs.
    public static boolean isRotation(String s1, String s2) {
        int length = s1.length();
        if (length == s2.length() && length > 0) {
            // Dupe s1 twice, and see if s2 exists.
            String s1_twice = s1.concat(s1);
            return isSubstring(s1_twice, s2);
        }
        return false;
    }

    public static boolean isSubstring(String s1, String s2) {
        return s1.contains(s2);
    }
}
