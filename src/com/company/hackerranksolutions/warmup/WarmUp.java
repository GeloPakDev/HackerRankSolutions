package com.company.hackerranksolutions.warmup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class WarmUp {

    public static int simpleArraySum(List<Integer> ar) {
        //Create field for saving values in it , like container
        int sum = 0;
        //Loop will fulfill the elements until the input size of the array
        for (Integer integer : ar) {
            //plus and assign the value for the element
            sum += integer;
        }
        //return fulfilled field
        return sum;
    }

    public static List<Integer> compareThree(List<Integer> list1, List<Integer> list2) {
        int counterList1 = 0;
        int counterList2 = 0;
        for (int i = 0; i < list1.size(); i++) {
            if (!Objects.equals(list1.get(i), list2.get(i))) {
                if (list1.get(i) > list2.get(i)) {
                    counterList1++;
                } else {
                    counterList2++;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        result.add(counterList1);
        result.add(counterList2);

        return result;
    }

    private static int diagonalDifference(List<List<Integer>> list) {
        //create fields for storing the values which we get from indexes
        int leftToRight = 0;
        int rightToLeft = 0;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            //traverse , increment and add 1 on each iteration
            leftToRight += list.get(i).get(i);
            //here we traverse in the back side "get(size - i - 1);"
            rightToLeft += list.get(i).get(size - i - 1);
        }
        return Math.abs(leftToRight - rightToLeft);
    }

    private static long aVeryBigSum(List<Long> array) {
        long sum = 0;
        for (Long aLong : array) {
            sum += aLong;
        }
        return sum;
    }

    private static void staircase(int n) {
        //number of symbols start from 1 value
        for (int numSymbols = 1; numSymbols <= n; numSymbols++) {
            //Spaces which are added to the line of the symbol
            int numSpaces = n - numSymbols;
            //Print spaces(We are using the "print"
            for (int i = 0; i < numSpaces; i++) {
                System.out.print(' ');
            }
            //Print the actual hashTag
            for (int i = 0; i < numSymbols; i++) {
                System.out.print('#');
            }
            System.out.println();
        }
    }

    private static void miniMaxSum(List<Long> arr) {
        long min = 0;
        long max = 0;
        int size = arr.size();
        //loop for counting the min
        Collections.sort(arr);

        for (int i = 0; i < size - 1; i++) {
            min += arr.get(i);
        }
        //loop for counting the max
        for (int i = 1; i < size; i++) {
            max += arr.get(i);
        }
        System.out.println(min + " " + max);
    }

    private static int birthdayCakeCandles(List<Integer> list) {
        int max = 0;
        int count = 0;

        for (int i : list) {
            if (i == max) {
                count++;
            }
            if (i > max) {
                max = i;
                count = 1;
            }
        }
        return count;
    }

    private static String timeConversion(String s) {
        int hour = Integer.parseInt(s.substring(0, 2));
        int minute = Integer.parseInt(s.substring(3, 5));
        int second = Integer.parseInt(s.substring(6, 8));
        String amPM = s.substring(8, 10);


        hour += ((amPM.equals("PM") && hour != 12) ? 12 : 0);
        hour -= ((amPM.equals("AM") && hour == 12) ? 12 : 0);

        return String.format("%02d", hour) + ":" + String.format("%02d", minute) + ":" + String.format("%02d", second);


    }

    public static void plusMinus(List<Integer> arr) {
        double size = arr.size();
        double positiveCounter = 0;
        double negativeCounter = 0;
        double zeroCounter = 0;
        double negativeResult;
        double positiveResult;
        double zeroResult;

        for (Integer integer : arr) {
            if (integer > 0) {
                positiveCounter++;
            } else if (integer < 0) {
                negativeCounter++;
            } else {
                zeroCounter++;
            }
        }

        positiveResult = positiveCounter / size;
        negativeResult = negativeCounter / size;
        zeroResult = zeroCounter / size;

        System.out.format("%.6f\n", positiveResult);
        System.out.format("%.6f\n", negativeResult);
        System.out.format("%.6f\n", zeroResult);
    }
}