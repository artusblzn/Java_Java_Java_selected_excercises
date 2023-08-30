/**
 * Leibnitz’s method for computing π is based on the following convergent series:
 * 
 * π/4 = 1 − 1/3 + 1/5 − 1/7 + ...
 * 
 * How many iterations does it take to compute π to a value between 3.141 and 3.142 using this
 * series? Write a Java program to find out.
 */

package chapter06;

public class PiCalculator {
    public static void main(String[] args) {
        double pi = 0;
        int numOfIterations = 0;

        do {
            if (numOfIterations % 2 != 0) {
                pi -= 4.0 / ((numOfIterations++ * 2) + 1);
            } else {
                pi += 4.0 / ((numOfIterations++ * 2) + 1);
            }
        } while (pi < 3.141 || pi > 3.142);
        System.out.println(numOfIterations + " iterations to achieve " + pi);
    }

}
