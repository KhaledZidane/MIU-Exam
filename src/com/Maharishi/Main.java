package com.Maharishi;

public class Main {

    public static void main(String[] args) {
        //System.out.println(is123Array(new int[]{1, 2, 3, 3, 2, 1, 1, 2, 3}));
        //System.out.println(is121Array(new int[]{1, 1, 2, 1, 2, 1, 1}));
        System.out.println(isPairedN(new int[]{3}, 3));
    }

    /*
    * A 123 array is an array that contains multiple
    * repetitions of the values 1, 2, 3 in that order.
    * For example {1, 2, 3, 1, 2, 3, 1, 2, 3} is a 123 array
    * but {1, 2, 3, 1, 2} is not.
    * */
    static int is123Array(int[] a) {
        if (a.length == 0 || a.length % 3 != 0) {
            return 0;
        }

        for (int i = 0; i < a.length; i += 3) {
            if (a[i] != 1 || a[i + 1] != 2 || a[i + 2] != 3) {
                return 0;
            }
        }

        return 1;
    }

    /*
    * Define an array to be a 121 array if all elements are
    * either 1 or 2 and it begins with one or more 1s
    * followed by a one or more 2s and then ends with
    * the same number of 1s that it begins with.
    * Write a method named is121Array that
    * returns 1 if its array argument is a 121 array,
    * otherwise, it returns 0.
    * */
    static int is121Array(int[] a) {
        int oneCountB = 0;
        int oneCountE = 0;
        int two = 0;

        if (a[0] != 1) {
            return 0;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                continue;
            }
            else if (a[i] == 2) {
                two = 2;
            }
            else
                return 0;
        }

        if(two == 0){
            return 0;
        }

        for (int i = 0; i < a.length/2; i++) {
            if (a[i] == 1) {
                oneCountB++;
            }
        }

        for (int i = a.length-1; i >= a.length/2; i--) {
            if (a[i] == 1) {
                oneCountE++;
            }
        }

        if (oneCountB == oneCountE)
            return 1;
        else
            return 0;
    }

    /*
    * An array is defined to be paired-N if it contains
    * two distinct elements that sum to N for some
    * specified value of N and the indexes of those
    * elements also sum to N. Write a function named
    * isPairedN that returns 1 if its array parameter is a paired-N array.
    * The value of N is passed as the second parameter.
    * */
    static int isPairedN(int[] a, int n) {
        if (n > a.length || a.length < 2 || n < 1 || a == null) {
            return 0;
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int elementSum = a[i] + a[j];
                int indexSum = i + j;
                if (elementSum == n && indexSum == n) {
                    return 1;
                }
            }
        }

        return 0;
    }
}
