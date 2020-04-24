public class binaryToDecimal {

    public static int convertToDecimal(String input) {
        // Binary starts at - 32 16 8 4 2 1
        // Multiply by two for each digit.
        int conversion = 1;
        int result = 0;

        for (int i = 1; i <= input.length(); i++) {
            // Start from end of input string. Remember index starts at 0.
            if (input.charAt(input.length() - i) == '1')
                result += conversion;
            conversion *= 2; // Multiply by 2 for each iteration.
        }
        return result;
    }

    public static void main(String[] args) {
        String binary = "10110";
        System.out.println(convertToDecimal(binary));
    }
}
