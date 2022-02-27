package com.example;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import com.example.Result.SinglyLinkedList;
import com.example.Result.SinglyLinkedListNode;

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

    public static int superDigit(String n, int k) {
        StringBuilder curNum = new StringBuilder(n);
        boolean first = true;
        long sum;
        while (curNum.length() > 1) {
            sum = 0;
            for (int i = 0; i < curNum.length(); i++) {
                sum += curNum.charAt(i) - '0';
            }
            if (first) {
                sum *= k;
                first = false;
            }
            curNum = new StringBuilder(String.valueOf(sum));
        }
        return Integer.parseInt(curNum.toString());
    }

    public static void minimumBribes(List<Integer> q) {
        int bribes = 0;
        for (int i = q.size() - 1; i >= 0; i--) {
            int expected_val = i + 1;
            if (q.get(i) == expected_val) {
                // right position
            } else if (i >= 1 && q.get(i - 1) == expected_val) {
                bribes++;
                int temp = q.get(i);
                q.set(i, q.get(i - 1));
                q.set(i - 1, temp);
            } else if (i >= 2 && q.get(i - 2) == expected_val) {
                bribes += 2;
                // may be i do swap 2 times for easy to think :D
                q.set(i - 2, q.get(i - 1));
                q.set(i - 1, q.get(i));
                q.set(i, i);
            } else {
                System.out.println("Too chaotic");
                return;
            }
        }
        System.out.println(bribes);
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

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedList root = new SinglyLinkedList();
        SinglyLinkedListNode nodeHead1 = head1;
        SinglyLinkedListNode nodeHead2 = head2;
        while (nodeHead1 != null && nodeHead2 != null) {
            if (nodeHead1.data < nodeHead2.data) {
                root.insertNode(nodeHead1.data);
                nodeHead1 = nodeHead1.next;
            }
            else {
                root.insertNode(nodeHead2.data);
                nodeHead2 = nodeHead2.next;
            }
        }
        while (nodeHead1 != null) {
            root.insertNode(nodeHead1.data);
            nodeHead1 = nodeHead1.next;
        }
        while (nodeHead2 != null) {
            root.insertNode(nodeHead2.data);
            nodeHead2 = nodeHead2.next;
        }
        return root.head;
    }

    public static void dequeDS() {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> deque
            = new LinkedList<Integer>();
  
        int nTestcase = scanner.nextInt();
        for (int i = 0; i < nTestcase; i++) {
            int option = scanner.nextInt();
            if (option == 1) {
                int val = scanner.nextInt();
                deque.add(val);
            }
            else if(option == 2) {
                deque.removeFirst();
            }
            else if(option == 3) {
                System.out.println(deque.getFirst());
            }
        }
    }

    public static String isBalanced(String s) {
        Stack<Character> charStack = new Stack<>(); 
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                charStack.add(c);
            }
            else if (c == ')') {
                if (charStack.isEmpty()) return "NO";
                else {
                    char popc = charStack.pop();
                    if (popc != '(') {
                        return "NO";
                    } 
                }
            }
            else if (c == '}') {
                if (charStack.isEmpty()) return "NO";
                else {
                    char popc = charStack.pop();
                    if (popc != '{') {
                        return "NO";
                    } 
                }
            }
            else if (c == ']') {
                if (charStack.isEmpty()) return "NO";
                else {
                    char popc = charStack.pop();
                    if (popc != '[') {
                        return "NO";
                    } 
                }
            }
        }
        return charStack.isEmpty() ? "YES": "NO";
    }

//https://www.hackerrank.com/challenges/one-week-preparation-kit-simple-text-editor/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-six
    public static void simpleTextEditor() {
        Scanner scanner = new Scanner(System.in);
        Stack<String> prevState = new Stack<String>();
        int nTest = scanner.nextInt();
        StringBuilder str = new StringBuilder();
        prevState.add("");
        for (int i = 0; i < nTest; i++) {
            int option = scanner.nextInt();
            if (option == 1) {
                prevState.add(str.toString());
                str.append(scanner.next());
            }
            else if(option == 2) {
                int k = scanner.nextInt();
                prevState.add(str.toString());
                str.setLength(str.length() - k);
            }
            else if (option == 3) {
                int k = scanner.nextInt();
                System.out.println(str.charAt(k - 1));
            }
            else if(option == 4) {
                str = new StringBuilder(prevState.pop());
            }
            else {
                // unknown, but problem say it can't occur
            }
            System.out.println("debug: " + str.toString());
        }
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {
        Result.simpleTextEditor();
    }

}
