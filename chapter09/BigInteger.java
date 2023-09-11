/**
 * EXERCISE 9.22 Challenge: Design and implement a BigInteger class that can add and subtract
 * integers with up to 25 digits. Your class should also include methods for input and output of the
 * numbers. If you’re really ambitious, include methods for multiplication and division.
 * 
 * Note1: This implementation works with integers larger than 25 digits.
 * 
 * Note2: I suppose the data input is correct. Therefore I didn't make tests testing the input
 * itself;
 * 
 * Note3: The implementation does not accept negative integers. Make that possible would take a lot
 * of time and testing.
 */

package chapter09;

public class BigInteger {
    public static String normalize(String value1, String value2) {
        if (value1.length() - value2.length() < 0) {
            value1 = "0".repeat(value2.length() - value1.length()) + value1;
        }
        return value1;
    }

    public static String add(String value1, String value2) {
        StringBuffer result = new StringBuffer(Math.max(value1.length(), value2.length()));
        // Make both Strings have the same length
        value1 = BigInteger.normalize(value1, value2);
        value2 = BigInteger.normalize(value2, value1);

        int carry = 0;

        for (int i = value1.length() - 1; i >= 0; i--) {
            int helper = Integer.parseInt(value1.substring(i, i + 1))
                    + Integer.parseInt(value2.substring(i, i + 1)) + carry;
            result.insert(0, Integer.toString(helper % 10));
            carry = helper >= 10 ? 1 : 0;
        }
        if (carry > 0) {
            result.insert(0, Integer.toString(carry));
        }
        return result.toString();
    }

    public static String subtract(String value1, String value2) {
        // Make both Strings have the same length
        value1 = BigInteger.normalize(value1, value2);
        value2 = BigInteger.normalize(value2, value1);

        StringBuffer result;
        // If value2 is bigger than value1, call same method but with inverted params
        if (BigInteger.compare(value1, value2) < 0) {
            result = new StringBuffer(BigInteger.subtract(value2, value1));
            result.insert(0, '-');
            return result.toString();
        }

        result = new StringBuffer();
        int carry = 0;

        for (int i = value1.length() - 1; i >= 0; i--) {
            int minuend = Integer.parseInt(value1.substring(i, i + 1)) - carry;
            int subtrahend = Integer.parseInt(value2.substring(i, i + 1));
            carry = (minuend < subtrahend) ? 1 : 0;
            int helper = (carry * 10) + minuend - subtrahend;
            result.insert(0, Integer.toString(helper));
        }
        return BigInteger.trimBigInt(result.toString());
    }

    public static String trimBigInt(String value) {
        StringBuffer trimmedBigInt = new StringBuffer(value);

        for (int i = 0; i < value.length() - 1 && value.charAt(i) == '0'; i++) {
            trimmedBigInt.deleteCharAt(0);
        }
        return trimmedBigInt.toString();
    }

    public static int compare(String value1, String value2) {
        if (value1.length() > value2.length()) {
            return 1;
        } else if (value2.length() > value1.length()) {
            return -1;
        }
        for (int i = 0; i < value1.length(); i++) {
            if (Integer.valueOf(value2.charAt(i)) > Integer.valueOf(value1.charAt(i))) {
                return -1;
            } else if (Integer.valueOf(value2.charAt(i)) < Integer.valueOf(value1.charAt(i))) {
                return 1;
            }
        }
        return 0;
    }

    // The multiplication method used ist repeated addition
    public static String multiply(String value1, String value2) {
        String result = "0";
        // while value2 greater than 0
        while (BigInteger.compare(value2, "0") > 0) {
            result = BigInteger.add(result, value1);
            value2 = BigInteger.subtract(value2, "1");
        }
        return result;
    }


    // The division method used is repeated subtraction
    // During every iteration it will subtract the divisor from the dividend
    // until the dividend is lesser or equal than the divisor - 1
    public static String divide(String value1, String value2) {
        String result = "0";

        // The other BigInteger method are used because we can have really large numbers here
        while (BigInteger.compare(value1, BigInteger.subtract(value2, "1")) > 0) {
            value1 = BigInteger.subtract(value1, value2);
            result = BigInteger.add(result, "1");
        }

        return result;
    }
}
