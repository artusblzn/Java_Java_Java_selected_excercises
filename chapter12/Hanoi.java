/**
 * EXERCISE 12.24 Challenge: Towers of Hanoi. According to legend, some Bud- dhist monks were given
 * the task of moving 64 golden disks from one diamond needle to another needle, using a third
 * needle as a backup. To begin with, the disks were stacked one on top of the other from largest to
 * smallest (Fig. 12.37). The rules were that only one disk can be moved at a time and that a larger
 * disk can never go on top of a smaller one. The end of the world was supposed to occur when the
 * monks finished the task! Write a recursive method, move(int N, char A, char B, char C), that will
 * print out directions the monks can use to solve the towers of Hanoi problem. For example, here’s
 * what it should output for the three-disk case, move(3, "A", "B", "C"):
 * 
 * Move 1 disk from A to B.
 * 
 * Move 1 disk from A to C.
 * 
 * Move 1 disk from B to C.
 * 
 * Move 1 disk from A to B.
 * 
 * Move 1 disk from C to A.
 * 
 * Move 1 disk from C to B.
 * 
 * Move 1 disk from A to B.
 */


package chapter12;

public class Hanoi {
    public static void move(int nDisks, char A, char B, char C) {
        if (nDisks == 0) {
            return;
        }
        Hanoi.move(nDisks - 1, A, C, B);
        System.out.println("Move 1 disk from " + A + " to " + B);
        Hanoi.move(nDisks - 1, C, B, A);
    }

    public static void main(String[] args) {
        move(3, 'A', 'B', 'C');
    }
}
