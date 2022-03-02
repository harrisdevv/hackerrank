package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Result2 {

    /*
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     * 1. STRING_ARRAY strings
     * 2. STRING_ARRAY queries
     */

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        // maybe some word is the same, i can save it queries for future queries
        int cnt;
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < queries.size(); i++) {
            cnt = 0;
            for (int j = 0; j < strings.size(); j++) {
                if (strings.get(j).equals(queries.get(i))) {
                    cnt++;
                }
            }
            res.add(cnt);
        }
        return res;
    }

    public static long flippingBits(long n) {
        // 2^32 - 1
        return (long) n ^ (4294967295l);
    }

    public static String pangrams(String s) {
        boolean isPangram = true;
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i))) {
                freq[Character.toLowerCase(s.charAt(i)) - 'a']++;
            }
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0) {
                isPangram = false;
                break;
            }
        }
        return isPangram ? "pangram" : "not pangram";
    }

    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
        Collections.sort(A);
        Collections.sort(B, Collections.reverseOrder());
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) + B.get(i) < k) {
                return "NO";
            }
        }
        return "YES";
    }

    public static int birthday(List<Integer> s, int d, int m) {
        if (m > s.size()) 
            return -1;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += s.get(i);
        }
        int nway = 0;
        if (sum == d)
            nway++;
        for (int i = 0; i + m < s.size(); i++) {
            sum += s.get(i + m);
            sum -= s.get(i);
            if (sum == d) {
                nway++;
            }
        }
        return nway;
    }

}

public class MonthHackerrank {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.txt"));
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] sTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> s = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int sItem = Integer.parseInt(sTemp[i]);
            s.add(sItem);
        }

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        int result = Result2.birthday(s, d, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}