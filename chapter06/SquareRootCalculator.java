package chapter06;

public class SquareRootCalculator {
    public static void main(String[] args) {
        double squareRoot = 50;
        int testValue = 100;
        int numOfIterations = 0;

        while (squareRoot != Math.sqrt(testValue)) {
            squareRoot = ((testValue / squareRoot) + squareRoot) / 2;
            numOfIterations++;
        }
        System.out.println("Square root of " + testValue + " = " + squareRoot + " achieved in "
                + numOfIterations + " iterations");

    }
}
