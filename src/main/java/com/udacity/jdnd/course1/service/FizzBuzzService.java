package com.udacity.jdnd.course1.service;

public class FizzBuzzService {

    /**
     * If number is divisible by 3, return "Fizz". If divisible by 5,
     * return "Buzz", and if divisible by both, return "FizzBuzz". Otherwise,
     * return the number itself.
     *
     * @Throws IllegalArgumentException for values < 1
     */
    public String fizzBuzz(int number) throws IllegalArgumentException {
        StringBuilder sb = new StringBuilder();
        if (number <= 0) {
            throw new IllegalArgumentException();
        }
        boolean divBy3 = divBy(number, 3);
        boolean divBy5 = divBy(number, 5);
        if (divBy3 && divBy5) {
            sb.append("FizzBuzz");
        } else if (divBy3) {
            sb.append("Fizz");
        } else if (divBy5) {
            sb.append("Buzz");
        } else {
            return String.valueOf(number);
        }
        return sb.toString();
    }

    private boolean divBy(int num, int div) {
        return num % div == 0;
    }
}
