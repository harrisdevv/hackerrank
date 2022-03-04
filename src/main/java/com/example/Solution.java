package com.example;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import com.example.Result.HuffmanLeaf;
import com.example.Result.HuffmanNode;
import com.example.Result.Node;
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

    public static String gridChallenge(List<String> grid) {
               List<String> rowSortedGrid = new ArrayList<>();
        for (int i = 0; i < grid.size(); i++) {
            char charArray[] = grid.get(i).toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            rowSortedGrid.add(sortedStr);
        }
        for (int i = 0; i < rowSortedGrid.size(); i++) {
            String row = rowSortedGrid.get(i);
            for (int j = 0; j < row.length() - 1; j++) {
                if (row.charAt(j) > row.charAt(j + 1)) {
                    return "NO";
                }
            }
            if (i < rowSortedGrid.size() - 1) {
                for (int j = 0; j < row.length(); j++) {
                    if (rowSortedGrid.get(i).charAt(j) > rowSortedGrid.get(i + 1).charAt(j)) {
                        return "NO";
                    }
                }
            }
        }
        return "YES";
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
            } else {
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
        Deque<Integer> deque = new LinkedList<Integer>();

        int nTestcase = scanner.nextInt();
        for (int i = 0; i < nTestcase; i++) {
            int option = scanner.nextInt();
            if (option == 1) {
                int val = scanner.nextInt();
                deque.add(val);
            } else if (option == 2) {
                deque.removeFirst();
            } else if (option == 3) {
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
            } else if (c == ')') {
                if (charStack.isEmpty())
                    return "NO";
                else {
                    char popc = charStack.pop();
                    if (popc != '(') {
                        return "NO";
                    }
                }
            } else if (c == '}') {
                if (charStack.isEmpty())
                    return "NO";
                else {
                    char popc = charStack.pop();
                    if (popc != '{') {
                        return "NO";
                    }
                }
            } else if (c == ']') {
                if (charStack.isEmpty())
                    return "NO";
                else {
                    char popc = charStack.pop();
                    if (popc != '[') {
                        return "NO";
                    }
                }
            }
        }
        return charStack.isEmpty() ? "YES" : "NO";
    }

    // https://www.hackerrank.com/challenges/one-week-preparation-kit-simple-text-editor/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-six
    public static void simpleTextEditor() {
        Scanner scanner = new Scanner(System.in);
        Stack<String> prevOperator = new Stack<String>();
        int nTest = scanner.nextInt();
        // StringBuilder str = new StringBuilder();
        String str = "";
        for (int i = 0; i < nTest; i++) {
            int option = scanner.nextInt();
            if (option == 1) {
                String val = scanner.next();
                // prevOperator.add(new Operator(option,val ));
                prevOperator.push(str);
                // str.append(val);
                str += val;
            } else if (option == 2) {
                int k = scanner.nextInt();
                // prevOperator.add(new Operator(option, str.substring(str.length() - k,
                // str.length())));
                prevOperator.push(str);
                str = str.substring(0, str.length() - k);
            } else if (option == 3) {
                int k = scanner.nextInt();
                System.out.println(str.charAt(k - 1));
            } else if (option == 4) {
                str = prevOperator.pop();
            } else {
                // unknown, but problem say it can't occur
            }
        }
        scanner.close();
    }

    public static int findBiggerElem(int val, List<Integer> arr) {
        int left = 0, right = arr.size() - 1;
        if (arr.get(arr.size() - 1) <= val) {
            return arr.size() - 1;
        }
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr.get(mid) > val) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public static int findBiggerElem(int val, List<Integer> arr, int from, int end) {
        int left = from, right = end;
        if (arr.get(end) <= val) {
            return end;
        }
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr.get(mid) > val) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public static int cookies(int k, List<Integer> A) {
        Collections.sort(A);
        int numIteration = 0;
        int greaterThanSweetnessIdx = A.size() - 1;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) >= k) {
                greaterThanSweetnessIdx = i - 1;
                break;
            }
        }
        if (greaterThanSweetnessIdx == -1) {
            return 0;
        }
        while (greaterThanSweetnessIdx >= 0) {
            int sweetness = A.get(0) + A.get(1) * 2;
            if (sweetness < k) {
                A.remove(0);
                A.remove(0);
                greaterThanSweetnessIdx -= 2;
                int addIndex = findBiggerElem(sweetness, A, 0, greaterThanSweetnessIdx);
                A.add(addIndex + 1, sweetness);
                // boolean added = false;
                // for (int j = 0; j <= greaterThanSweetnessIdx; j++) {
                // if (A.get(j) >= sweetness) {
                // A.add(j + 1, sweetness);
                // added = true;
                // break;
                // }
                // }
                // if (!added) {
                // A.add(greaterThanSweetnessIdx + 1, sweetness);
                // }
                greaterThanSweetnessIdx += 1;
                numIteration++;
            } else {
                numIteration += (int) Math.ceil((double) (greaterThanSweetnessIdx + 1) / 2);
                break;
            }
        }
        return numIteration;
    }

    public static int legoBlocks(int n, int m) {
        // Write your code here
        // https://stackoverflow.com/questions/15424945/lego-blocks-dynamic-programming
        // hard :D
        return -1;
    }

    abstract class Node implements Comparable<Node> {

        public int frequency; // the frequency of this tree
        public char data;
        public Node left, right;

        public Node(int freq) {
            frequency = freq;
        }

        // compares on the frequency
        public int compareTo(Node tree) {
            return frequency - tree.frequency;
        }
    }

    class HuffmanLeaf extends Node {

        public HuffmanLeaf(int freq, char val) {
            super(freq);
            data = val;
        }
    }

    class HuffmanNode extends Node {

        public HuffmanNode(Node l, Node r) {
            super(l.frequency + r.frequency);
            left = l;
            right = r;
        }
    }

    // class Node {
    // int data;
    // Node left;
    // Node right;
    // }

    public static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void decode(String s, Node root) {
        int ind = 0;
        while (ind < s.length()) {
            Node node = root;
            while (node.left != null || node.right != null) {
                if (s.charAt(ind) == '0') {
                    if (node.left != null)
                        node = node.left;
                } else {
                    if (node.right != null)
                        node = node.right;
                }
                ind++;
            }
            System.out.print(node.data);
        }
    }
public static void noPrefix(List<String> words) {
    // Write your code here
        // Write your code here
        boolean isPrefix = true;
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.size() && i != j; j++) {
                // check j is prefix of i
                if (words.get(j).length() >= words.get(i).length()) {
                    continue;
                }
                int indi = 0;
                int indj = 0;
                isPrefix = true;
                while (indi < words.get(i).length() && indj < words.get(j).length()) {
                    if (words.get(i).charAt(indi) != words.get(j).charAt(indj)) {
                        isPrefix = false;
                        break;
                    }
                    indi++;
                    indj++;
                }
                if (isPrefix) {
                    System.out.println("BAD SET\n" + words.get(i));
                    return;
                }
            }
        }
        System.out.println("GOOD SET");
    }

}

public class Solution {

    // public static Node buildTree(int[] charFreqs) {

    //     PriorityQueue<Node> trees = new PriorityQueue<Node>();
    //     // initially, we have a forest of leaves
    //     // one for each non-empty character
    //     for (int i = 0; i < charFreqs.length; i++)
    //         if (charFreqs[i] > 0)
    //             trees.offer(new HuffmanLeaf(charFreqs[i], (char) i));

    //     assert trees.size() > 0;
    //     // loop until there is only one tree left
    //     while (trees.size() > 1) {
    //         // two trees with least frequency
    //         Node a = trees.poll();
    //         Node b = trees.poll();

    //         // put into new node and re-insert into queue
    //         trees.offer(new HuffmanNode(a, b));
    //     }
    //     return trees.poll();
    // }

    public static Map<Character, String> mapA = new HashMap<Character, String>();

    public static void printCodes(Node tree, StringBuffer prefix) {
        assert tree != null;

        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf) tree;

            // print out character, frequency, and code for this leaf (which is just the
            // prefix)
            // System.out.println(leaf.data + "\t" + leaf.frequency + "\t" + prefix);
            mapA.put(leaf.data, prefix.toString());

        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode) tree;

            // traverse left
            prefix.append('0');
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length() - 1);

            // traverse right
            prefix.append('1');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        // legoReadInput();
        // cookiesInput();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> words = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String wordsItem = bufferedReader.readLine();
            words.add(wordsItem);
        }

        Result.noPrefix(words);

        bufferedReader.close();


        // Test Decode D7()####################
        // Scanner input = new Scanner(System.in);

        // String test = input.next();

        // // we will assume that all our characters will have
        // // code less than 256, for simplicity
        // int[] charFreqs = new int[256];

        // // read each character and record the frequencies
        // for (char c : test.toCharArray())
        //     charFreqs[c]++;

        // // build tree
        // Node tree = buildTree(charFreqs);

        // // print out results
        // printCodes(tree, new StringBuffer());
        // StringBuffer s = new StringBuffer();

        // for (int i = 0; i < test.length(); i++) {

        //     char c = test.charAt(i);
        //     s.append(mapA.get(c));

        // }

        // // System.out.println(s);
        // Result res = new Result();
        // res.decode(s.toString(), tree);
    }

    private static Node buildTree(int[] charFreqs) {
        return null;
    }

    private static void cookiesInput() throws IOException {
        int res = Result.findBiggerElem(3, Arrays.asList(1, 2, 4, 5));
        System.out.println("res " + res);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.txt"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] ATemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> A = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int AItem = Integer.parseInt(ATemp[i]);
            A.add(AItem);
        }

        int result = Result.cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    private static void legoReadInput() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.txt"));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);

            int m = Integer.parseInt(firstMultipleInput[1]);

            int result = Result.legoBlocks(n, m);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }

}
