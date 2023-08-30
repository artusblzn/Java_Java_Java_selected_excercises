/**
 * EXERCISE 6.28 Revise the application in the previous problem so that the bar charts are displayed
 * vertically. For example, if the user inputs 5, 2, 3, and 4, the program should display
 * 
 */

package chapter06;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GraphPrinter {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 3, 4);

        for (Integer i = Collections.max(numbers); i > 0; i--) {
            for (int number : numbers) {
                if (number >= i) {
                    System.out.print("** ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.print("\n");
        }
    }
}
