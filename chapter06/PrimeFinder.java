/**
 * EXERCISE 6.25 Your employer is developing encryption software and wants you to develop a Java
 * Swing Program that will display all of the primes less than N, where N is a number to be entered
 * by the user. In addition to displaying the primes themselves, provide a count of how many there
 * are.
 * 
 * I just created a class do find the prime numbers. I'm not going to create the interface using
 * Swing.
 */

package chapter06;

import java.util.LinkedList;

public class PrimeFinder {

    private int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public boolean isPrime(int number) {
        // Just for simplicity
        if (number == 2 || number == 3 || number == 5) {
            return true;
        }
        // All positive integers that are pairs (except 2) are not primes
        // or that end in 5 (except 5) are not primes
        if (number % 2 == 0 || (number % 10 == 5)) {
            return false;
        }
        // If the sum of the digits of number is divisible by 3, it's not prime (except 3)
        if (this.sumOfDigits(number) % 3 == 0) {
            return false;
        }
        // If a given number is divisible by any prime number lesser or equal than its square root,
        // than the given number is not prime
        double sqrt = Math.sqrt(number);
        for (double prime : this.findPrimes((int) sqrt + 1)) {
            if (number % prime == 0) {
                return false;
            }
        }
        return true;
    }

    public LinkedList<Integer> findPrimes(int number) {
        LinkedList<Integer> primeNumbers = new LinkedList<Integer>();

        // 1 is not a prime number, so let's start from 2.
        for (int i = 2; i < number; i++) {
            if (this.isPrime(i)) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }
}
