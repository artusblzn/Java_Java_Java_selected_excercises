/**
 * EXERCISE 11.24 Challenge: In Unix systems, there’s a program named grep that can list the lines
 * in a text file containing a certain string. Write a Java version of this program that prompts the
 * user for the name of the file and the string to search for.
 * 
 * As I used automated tests, I decided to not implement the main function.
 */

package chapter11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Grep {
    public static String[] listLines(String s, String[] lines) {
        Vector<String> validLines = new Vector<String>();

        for (String line : lines) {
            if (line.contains(s)) {
                validLines.add(line);
            }
        }
        return validLines.toArray(new String[validLines.size()]);
    }

    public static String[] getFileLines(String filename) throws IOException {
        BufferedReader inStream = new BufferedReader(new FileReader(filename));
        Vector<String> lines = new Vector<String>();
        String line = inStream.readLine();
        while (line != null) {
            lines.add(line);
            line = inStream.readLine();
        }
        inStream.close();

        return lines.toArray(new String[lines.size()]);
    }

}
