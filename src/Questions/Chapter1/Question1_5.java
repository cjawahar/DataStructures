package Questions.Chapter1;
/*
    Implement a method to perform basic string compression
    using the counts of repeated characters.
    'aabcccccaaa' == 'a2b1c5a3'
    If the compressed string does not shrink, return the original.
 */
public class Question1_5 {
    public static void main(String[] args) {
        String input = "aabcccccaaa";
        System.out.println(compressStr(input));
    }

    // THIS ENTIRE METHOD IS JUST FOR RETURNING ORIGINAL STRING IF COMPRESSED DOESN'T SHRINK.
    public static int countDuplicates(String str) {
        if (str == null || str.isEmpty()) return 0;

        char lastLetter = str.charAt(0); // Starting at beginning of str.
        int size = 0, count = 1;         // Count starts at 1 to account for initial lastLetter.

        // Start at 1 since 0 is lastLetter.
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == lastLetter) {
                count++;
            } else {
                lastLetter = str.charAt(i); // Replace lastLetter if not a match.
                // Since we are replacing aa with a2, we need to get the length of the 'size' var.
                // This will either be 1 for counts of 0-9, 2 for 10 - 99 and so forth.
                // Don't directly add the count itself to the size, defeats the purpose.
                // The initial one is for the initial letter itself.
                size += 1 + String.valueOf(count).length();
                count = 1; // Reset count to 1.
            }
        }
        //One final addition to account for very last letter as for loop hits the end.
        size += 1 + String.valueOf(count).length();
        return size;
    }

    public static String compressStr(String input) {
        int size = countDuplicates(input); // This will be the size of the final output string.
        if (size == 0 || size >= input.length()) return input;  // Stipulated in the problem

        // SAME process now, start with first letter of input string.
        StringBuffer newString = new StringBuffer();
        char lastLetter = input.charAt(0);
        int count = 1; // Same idea as the count in countDuplicates.

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == lastLetter) {
                count++;
            } else {
                // Add lastLetter and it's count to string buffer.
                newString.append(lastLetter);
                newString.append(count);
                // Reset count and lastLetter to next letter in input.
                lastLetter = input.charAt(i);
                count = 1;
            }
        }
        // One last append for last letter and it's count.
        newString.append(lastLetter);
        newString.append(count);

        return newString.toString();
    }
}
