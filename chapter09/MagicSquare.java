/**
 * EXERCISE 9.18 Write a program that tests whether a 3 × 3 array, input by the user, is a magic
 * square. A magic square is an N × N matrix of numbers in which every number from 1 to N 2 must
 * appear just once, and every row, column, and diagonal must add up to the same total—for example,
 * 
 * 6 7 2
 * 
 * 1 5 9
 * 
 * 8 3 4
 */

package chapter09;

import java.util.Vector;

public class MagicSquare {
    public static boolean isMagicSquare(int[][] square) {
        Vector magicSquareNumbers = new Vector((int) Math.pow(square.length, 2));

        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                if (square[i][j] < 0 || square[i][j] > Math.pow(square.length, 2)
                        || magicSquareNumbers.contains((Integer) square[i][j])) {
                    return false;
                }
                magicSquareNumbers.add((Integer) square[i][j]);
            }
        }
        return true;
    }
}
