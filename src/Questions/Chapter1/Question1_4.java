package Questions.Chapter1;
/*
    Write a method to replace all spaces in a string with
    '%20'.
    For Java, use a character array to perform operation
    in place.
 */
public class Question1_4 {
    public static void main(String[] args) {
        // Each string should have extra spaces at end to accommodate '%20'
        // 3 spaces needed for each space (1 character).
        String input = "Mr John Smith";
        //     Answer = Mr%20John%20Smith

        // Need to represent extra space for the string at the end.
        // 2 spaces = 6 extra spaces needed. Adjust size.
        // This was manual for the above input string.
        char[] holderArr = new char[input.length() + 2 * 2 + 1];
        for (int i = 0; i < input.length(); i++) {
            holderArr[i] = input.charAt(i);
        }
        System.out.println(replaceSpaces(holderArr, input.length()));
    }

    public static String replaceSpaces(char[] inputArr, int length) {
        // Find out how many spaces exist
        int spaceCount = 0;
        int index;

        for (int i = 0; i < length; i++) {
            if (inputArr[i] == ' ') {
                spaceCount++;
            }
        }
        // Index and length will be separate.
        index = length + spaceCount * 2;
        inputArr[index] = '\0';

        for (int i = length - 1; i >= 0; i--) {
            // When a space is found, enough space
            // will be available for replacement str
            if (inputArr[i] == ' ') {
                inputArr[index - 1] = '0';
                inputArr[index - 2] = '2';
                inputArr[index - 3] = '%';
                index = index - 3;
            }
            // Overwrite original input string to move to end of inputArray.
            else {
                inputArr[index - 1] = inputArr[i];
                index--;
            }
        }
        return new String(inputArr);
    }
}
