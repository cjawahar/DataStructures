package Questions.Chapter1;
/*
    Implement an algorithm to determine if a string has all unique characters.
 */
public class Question1_1 {
    // Is this an ASCII or Unicode string? It would matter.
    public static void main(String[] args) {
        String unique = "Am I unique?";
        System.out.println(unique + ": " + checkUnique(unique));

        String[] words = {"abcde", "yolo", "POTUS", "CIA", "FBI", "Apple"};
        for (String word : words) {
            System.out.println(word + ": " + checkUnique(word));
        }
    }

    // ASCII contains 256 characters - but 128 - 255 is extended ASCII or ANSI
    // Technically not part of the same set as 0-127.
    public static boolean checkUnique(String input) {
        // Can't be unique if length greater than usual set of chars.
        if (input.length() > 128) {
            return false;
        }
        // This method uses another dataStructure.
        boolean[] charSet = new boolean[128];
        for (int i = 0; i < input.length(); i++) {
            int val = input.charAt(i);
            // Check if value exists in set already
            // Either return false or add val to set.
            if (charSet[val]) {
                return false;
            } else {
                charSet[val] = true;
            }
        }
        return true; // if loop finishes, string is unique.
    }
}
