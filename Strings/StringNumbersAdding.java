
public class StringNumbersAdding extends TextProgram {

    /*Reading numbers and adding them. */
    public void run() {
        while (true) {
            String n1 = readLine("Enter first number:");
            String n2 = readLine("Enter second number:");
            println(n1 + " + " + n2 + " = " + addNumericStrings(n1, n2));
            println();
        }
    }


    /**
     * Given two string representations of nonnegative integers, adds the
     * numbers represented by those strings and returns the result.
     *
     * @param n1 The first number.
     * @param n2 The second number.
     * @return A String representation of n1 + n2
     */
    private String addNumericStrings(String n1, String n2) {

        // Add leading zeros to the shorter string
        if (n1.length() < n2.length()) {
            n1 = addLeadingZeros(n1, n2.length() - n1.length());
        } else if (n2.length() < n1.length()) {
            n2 = addLeadingZeros(n2, n1.length() - n2.length());
        }

        int[] firstNumber = stringToArrayOfNumbers(n1);
        int[] secondNumber = stringToArrayOfNumbers(n2);

        int[] result = new int[firstNumber.length + 1];     // Increase the size by 1 to accommodate carry

        boolean carry = false;

        for (int i = firstNumber.length - 1; i >= 0; i--) {
            int sum = firstNumber[i] + secondNumber[i];
            if (carry) {
                sum++;
                carry = false;
            }
            if (sum >= 10) {
                carry = true;
                sum -= 10;                  //If sum greater than 10 leave only last digit
            }
            result[i + 1] = sum;
        }

        result = handleFinalCarry(result, carry);

        return arrayToString(result);
    }

    /*Checks if there is a carry on the last(greatest) digits, if it is turns first digit in number into 1
     *If not, deletes additional digit from the beginning of number*/
    private int[] handleFinalCarry(int[] result, boolean carry) {
        if (carry) {
            result[0] = 1;                                                     // Set the first digit to 1 if there is a carry
        } else {
            result = Arrays.copyOfRange(result, 1, result.length);       // Remove the extra digit if there is no carry
        }
        return result;
    }


    /**
     * Add zeros to the beginning of stringified number
     * to equalize it length with larger number
     *
     * @param diff difference between length of strings
     */
    private String addLeadingZeros(String str, int diff) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < diff; i++) {
            sb.append("0");
        }
        sb.append(str);
        return sb.toString();
    }

    /*Converts string to array where each string char equals to an element of array*/
    private int[] stringToArrayOfNumbers(String number) {
        int[] array = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            array[i] = number.charAt(i) - '0';
        }
        return array;
    }

    /*Converts an array of integers to string
     * On first step turns it into stringBuilder to make process conversion easier
     * And then converts stringBuilder to regular string*/
    private String arrayToString(int[] array) {
        StringBuilder number = new StringBuilder();
        for (int i : array) {
            number.append(i);
        }
        return number.toString();
    }

}
