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
public static int sockMerchant(int n, List<Integer> ar) {
        int[] freq = new int[101];
        for (int i = 0; i < ar.size(); i++) {
            freq[ar.get(i)]++;
        }

        int sum = 0;
        for (int i = 0; i < 101; i++) {
            sum += freq[i] / 2;
        }
        return sum;
    }
    public static int pageCount(int n, int p) {
        int lefttoright = p / 2;
        int righttoleft = (n % 2 == 1) ? (n - p) / 2: (n - p + 1) / 2;
        return (lefttoright < righttoleft) ? lefttoright: righttoleft;
    }

    public static int maxMin(int k, List<Integer> arr) {
        Collections.sort(arr);
        int unfairpoint = arr.get(k - 1) - arr.get(0);
        for (int i = k; i < arr.size(); i++) {
            if (unfairpoint > arr.get(i) - arr.get(i - k + 1)) {
                unfairpoint = arr.get(i) - arr.get(i - k + 1);
            }
        }
        return unfairpoint;

    }

      public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<Integer>());
        }
        int lastAnswer = 0;
        for (int i = 0; i < queries.size(); i++) {
            int opt = queries.get(i).get(0);
            int x = queries.get(i).get(1);
            int y = queries.get(i).get(2);
            if (opt == 1) {
                int idx = (x ^ lastAnswer) % n;
                arr.get(idx).add(y);
            }
            else if (opt == 2) {
                int idx = (x^lastAnswer)% n;
                lastAnswer = arr.get(idx).get((y % arr.get(idx).size()));
                res.add(lastAnswer);
            }
        }
        return res;
    }


}

public class MonthHackerrank {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.txt"));


        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            String[] queriesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> queriesRowItems = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowTempItems[j]);
                queriesRowItems.add(queriesItem);
            }

            queries.add(queriesRowItems);
        }

        for (int i = 0; i < q - 2; i++) {
            // String[] queriesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            String[] queriesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> queriesRowItems = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowTempItems[j]);
                queriesRowItems.add(queriesItem);
            }

            queries.add(queriesRowItems);
        }

        List<Integer> result = Result2.dynamicArray(n, queries);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close(); 

    }
}