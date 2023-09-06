/**
 * EXERCISE 7.9 Write a method that converts its String parameter so that letters are written in
 * blocks five characters long. For example, consider the following two versions of the same
 * sentence:
 * 
 * "This is how we would ordinarily write a sentence."
 * 
 * "Thisi showw ewoul dordi naril ywrit easen tence."
 */

package chapter07;

public class BlockConverter {
    public static String convert(String plain) {
        StringBuffer blocked = new StringBuffer();
        String plainWithoutSpaces = plain.replaceAll(" ", "");

        for (int i = 0; i < Math.ceil(plainWithoutSpaces.length() / 5.0); i++) {
            int endIndex = ((i * 5 + 5) <= plainWithoutSpaces.length()) ? ((i * 5) + 5)
                    : plainWithoutSpaces.length();

            blocked.append(plainWithoutSpaces.substring(i * 5, endIndex));

            if (endIndex < plainWithoutSpaces.length()
                    && plainWithoutSpaces.charAt(endIndex) != '.') {
                blocked.append(" ");
            }
        }
        return blocked.toString();
    }
}
