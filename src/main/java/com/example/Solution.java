package com.example;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    public static void plusMinus(List<Integer> arr) {
        int nPos = 0;
        int nNeg = 0;
        int nZero = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > 0) {
                nPos++;
            } else if (arr.get(i) < 0) {
                nNeg++;
            } else
                nZero++;
        }
        System.out.println(String.format("%.6f", (double) nPos / arr.size()));
        System.out.println(String.format("%.6f", ((double) nNeg / arr.size())));
        System.out.println(String.format("%.6f", ((double) nZero / arr.size())));
    }

    public static int lonelyinteger(List<Integer> a) {
        int[] arr = new int[101];
        for (int i = 0; i < a.size(); i++) {
            arr[a.get(i)]++;
        }
        for (int i = 0; i < 101; i++) {
            if (arr[i] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        long leftSum = 0;
        long rightSum = 0;
        int arrsize = arr.size();
        for (int i = 0; i < arrsize; i++) {
            leftSum += arr.get(i).get(i);
            rightSum += arr.get(i).get(arrsize - i - 1);
        }
        if (rightSum > leftSum) {
            return (int) (rightSum - leftSum);
        } else
            return (int) (leftSum - rightSum);
    }

    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            result.add(0);
        }
        for (int i = 0; i < arr.size(); i++) {
            result.set(arr.get(i), result.get(arr.get(i)) + 1);
        }
        return result;
    }

    public static void findZigZagSequence(int[] a, int n) {
        Arrays.sort(a);
        int mid = (n - 1) / 2;
        int temp = a[mid];
        a[mid] = a[n - 1];
        a[n - 1] = temp;

        int st = mid + 1;
        int ed = n - 2;
        while (st <= ed) {
            temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;
            st = st + 1;
            ed = ed - 1;
        }
        for (int i = 0; i < n; i++) {
            if (i > 0)
                System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();
    }

    public static void miniMaxSum(List<Integer> arr) {
        long sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
        }
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            if (sum - arr.get(i) < min) {
                min = sum - arr.get(i);
            }
            if (sum - arr.get(i) > max) {
                max = sum - arr.get(i);
            }
        }
        System.out.println(min + " " + max);
    }

    public static String timeConversion(String s) {
        int len = s.length();
        String AMpart = s.substring(len - 2, len);
        String hourPart = s.substring(0, 2);
        StringBuilder res = new StringBuilder();
        int hour = Integer.parseInt(hourPart);
        if (AMpart.equals("AM")) {
            if (hour >= 12) {
                int newHour = (hour + 12) % 24;
                if (newHour < 10)
                    res.append("0").append(newHour);
                else
                    res.append(newHour);
            } else
                res.append(hourPart);
        } else if (AMpart.equals("PM")) {
            if (hour < 12) {
                res.append(hour + 12);
            } else {
                res.append(hourPart);
            }
        }
        res.append(s.substring(2, len - 2));
        return res.toString();
    }

    public static int findMedian(List<Integer> arr) {
        int[] a = new int[arr.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = arr.get(i);
        }
        Arrays.sort(a);

        return a[arr.size() / 2];
    }

    public static int towerBreakers(int n, int m) {
        if (m == 1) {
            return 2;
        } else {
            if (n % 2 == 0)
                return 2;
            else
                return 1;
        }
    }

    public static String caesarCipher(String s, int k) {
        // Write your code here
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                char nchar = (char) (((int) s.charAt(i) + k - (int) 'a') % 26 + (int) 'a');
                res.append(nchar);
            } else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                char nchar = (char) (((int) s.charAt(i) + k - (int) 'A') % 26 + (int) 'A');
                res.append(nchar);
            } else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.txt"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
