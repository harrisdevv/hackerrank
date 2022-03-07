package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

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
        int righttoleft = (n % 2 == 1) ? (n - p) / 2 : (n - p + 1) / 2;
        return (lefttoright < righttoleft) ? lefttoright : righttoleft;
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
            } else if (opt == 2) {
                int idx = (x ^ lastAnswer) % n;
                lastAnswer = arr.get(idx).get((y % arr.get(idx).size()));
                res.add(lastAnswer);
            }
        }
        return res;
    }

    public static int month[];

    public static void updateLeapYear(int year) {
        if (year % 400 == 0) {
            month[2] = 29;
        } else if (year % 100 == 0) {
            month[2] = 28;
        } else if (year % 4 == 0) {
            month[2] = 29;
        } else {
            month[2] = 28;
        }
    }

    public static void storeMonth() {
        month[1] = 31;
        month[2] = 28;
        month[3] = 31;
        month[4] = 30;
        month[5] = 31;
        month[6] = 30;
        month[7] = 31;
        month[8] = 31;
        month[9] = 30;
        month[10] = 31;
        month[11] = 30;
        month[12] = 31;
    }

    public static int findPrimeDates(int d1, int m1, int y1, int d2, int m2, int y2) {
        storeMonth();

        int result = 0;

        while (true) {
            int x = d1;
            x = x * 100 + m1;
            x = x * 10000 + y1;
            if (x % 4 == 0 || x % 7 == 0) {
                result = result + 1;
            }
            if (d1 == d2 && m1 == m2 && y1 == y2) {
                break;
            }
            updateLeapYear(y1);
            d1 = d1 + 1;
            if (d1 > month[m1]) {
                m1 = m1 + 1;
                d1 = 1;
                if (m1 > 12) {
                    y1 = y1 + 1;
                    m1 = 1;
                }
            }
        }
        return result;
    }

    public static String balancedSums(List<Integer> arr) {
        long leftSum = 0;
        long rightSum = 0;
        // if (arr.size() < 3) {
        // return "NO";
        // }
        for (int i = 0; i < arr.size(); i++) {
            rightSum += arr.get(i);
        }
        rightSum -= arr.get(0);
        if (leftSum == rightSum) {
            return "YES";
        }

        for (int i = 1; i < arr.size(); i++) {
            leftSum += arr.get(i - 1);
            rightSum -= arr.get(i);
            if (leftSum == rightSum) {
                return "YES";
            }
        }
        return "NO";
    }

    public static int countBits(long n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    public static String counterGame(long n) {
        // Write your code here
        if (countBits(n - 1) % 2 == 1)
            return "Louise";
        else
            return "Richard";
    }

    // https://www.xarg.org/puzzle/hackerrank/sum-vs-xor/
    public static long sumXor(long n) {
        int nZeroBit = 0;
        while (n != 0) {
            if ((n & 1) != 1)
                nZeroBit++;
            n = n >> 1;
        }
        return 1L << nZeroBit;
    }

    public static class ItemFrequent {
        public int val;
        public int freq;

        ItemFrequent(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }

    public static String isValid(String s) {
        int maxChar = 26;

        int[] freq = new int[maxChar];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        List<ItemFrequent> frequent = new ArrayList<>();
        for (int i = 0; i < maxChar; i++) {
            if (freq[i] == 0)
                continue;
            boolean appear = false;
            for (int j = 0; j < frequent.size(); j++) {
                if (frequent.get(j).val == freq[i]) {
                    appear = true;
                    frequent.get(j).freq += 1;
                }
            }
            if (!appear) {
                frequent.add(new ItemFrequent(freq[i], 1));
            }
        }
        if (frequent.size() == 1) {
            return "YES";
        }
        if (frequent.size() > 2) {
            return "NO";
        }
        if (frequent.get(0).val - 1 == frequent.get(1).val && frequent.get(0).freq == 1) {
            return "YES";
        }
        if (frequent.get(1).val - 1 == frequent.get(0).val && frequent.get(1).freq == 1) {
            return "YES";
        }
        if ((frequent.get(0).freq == 1 && frequent.get(0).val == 1)
                || (frequent.get(1).freq == 1 && frequent.get(1).val == 1)) {
            return "YES";
        }
        return "NO";
    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        int curRank;
        List<Integer> res = new ArrayList<Integer>();
        List<Integer> rankedUnDup = new ArrayList<Integer>();
        for (int i = 0; i < ranked.size(); i++) {
            if ((rankedUnDup.size() == 0)
                    || (rankedUnDup.size() > 0 && rankedUnDup.get(rankedUnDup.size() - 1) != ranked.get(i))) {
                rankedUnDup.add(ranked.get(i));
            }
        }
        System.out.println(Arrays.toString(rankedUnDup.toArray()));
        for (int i = 0; i < player.size(); i++) {
            curRank = 1;
            for (int j = 0; j < rankedUnDup.size(); j++) {
                // if (j - 1 >= 0 && ranked.get(j) == ranked.get(j - 1)) {
                // continue;
                // }
                if (player.get(i) < rankedUnDup.get(j)) {
                    curRank++;
                } else {
                    break;
                }

            }
            res.add(curRank);
        }
        return res;
    }

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter)
            throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
        // Write your code here
        if (llist == null) {
            return null;
        }
        if (llist.next == null) {
            return llist;
        }
        SinglyLinkedListNode nextNode = reverse(llist.next);
        nextNode.next = llist;
        return llist;
    }

    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        // Write your code here
        int iterPos = 0;
        SinglyLinkedListNode iter = llist;
        if (position == 0) {
            SinglyLinkedListNode newData = new SinglyLinkedListNode(data);
            newData.next = llist;
            return newData;
        }
        while (iter != null) {
            if (iterPos == position - 1) {
                SinglyLinkedListNode newData = new SinglyLinkedListNode(data);
                newData.next = iter.next;
                iter.next = newData;
            }
            iter = iter.next;
            iterPos++;
        }
        return llist;
    }

    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
        List<Integer> res = new ArrayList<Integer>();
        boolean found = false;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size() && j != i; j++) {
                if (arr.get(i) + arr.get(j) == m) {
                    res.add(j + 1);
                    res.add(i + 1);
                    found = true;
                    break;
                }
            }
            if (found)
                break;
        }
        return res;
    }

    public static List<Integer> waiter(List<Integer> number, int q) {
        return null;
    }

    public static int getSum(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        int h1s = getSum(h1);
        int h2s = getSum(h2);
        int h3s = getSum(h3);
        while (true) {
            if (h1.size() == 0 || h2.size() == 0 || h3.size() == 0) {
                return 0;
            }
            if (h1s == h2s && h2s == h3s) {
                return h1s;
            }
            int[] sum = new int[3];
            sum[0] = h1s;
            sum[1] = h2s;
            sum[2] = h3s;
            int max = Integer.MIN_VALUE;
            int maxIdx = -1;
            for (int i = 0; i < 3; i++) {
                if (max < sum[i]) {
                    max = sum[i];
                    maxIdx = i;
                }
            }
            if (maxIdx == 0) {
                int rem = h1.get(0);
                h1.remove(0);
                h1s -= rem;
            } else if (maxIdx == 1) {
                int rem = h2.get(0);
                h2.remove(0);
                h2s -= rem;
            }
            if (maxIdx == 2) {
                int rem = h3.get(0);
                h3.remove(0);
                h3s -= rem;
            }
        }
    }

    //https://www.hackerrank.com/challenges/one-month-preparation-kit-maxsubarray/problem?h_l=interview&isFullScreen=true&playlist_slugs%5B%5D%5B%5D=preparation-kits&playlist_slugs%5B%5D%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D%5B%5D=one-month-week-four&h_r=next-challenge&h_v=zen
    public static List<Integer> maxSubarray(List<Integer> arr) {

        List<Integer> result = new ArrayList<Integer>();

        // skip negative part
        int posIdx = 0;
        while (arr.get(posIdx) < 0) {
            posIdx++;
        }


        for (int i = posIdx; i < arr.size(); i++) {
            // if ()


        }
        return result;

    }
}

public class MonthHackerrank {

    public static void main(String[] args) throws IOException {
        // BufferedReader bufferedReader = new BufferedReader(new
        // InputStreamReader(System.in));
        // BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.txt"));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.txt"));
        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                List<Integer> result = Result2.maxSubarray(arr);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}