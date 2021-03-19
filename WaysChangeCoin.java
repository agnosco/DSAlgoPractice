package practice;

public class WaysChangeCoin {
    public static void main(String[] args) {

    }

    // Add any helper functions you may need here
    Character rotateAndGetChar(int start, int length, int c, int rotationFactor) {
        return (char)((((c -start ) + rotationFactor) % length) + start);
    }

    String rotationalCipher(String input, int rotationFactor) {
        // Write your code here
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                sb.append(rotateAndGetChar(48, 9, input.charAt(i), rotationFactor));
            } else if (Character.isLowerCase(input.charAt(i))) {
                sb.append(rotateAndGetChar(97, 26, input.charAt(i), rotationFactor));
            } else if (Character.isUpperCase(input.charAt(i))) {
                sb.append(rotateAndGetChar(65, 26, input.charAt(i), rotationFactor));
            } else {
                sb.append(input.charAt(i));
            }
        }

        return sb.toString();
    }

}
