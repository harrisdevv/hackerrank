package com.example;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.spi.LocaleNameProvider;
import java.util.stream.Stream;

import javax.swing.plaf.IconUIResource;

class Result2 {

	/*
	 * Complete the 'matchingStrings' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * following parameters: 1. STRING_ARRAY strings 2. STRING_ARRAY queries
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

	public static List<Integer> generatePrime(int n) {
		List<Integer> res = new ArrayList<Integer>();
		int nPrime = (int) Math.floor(Math.sqrt(n));
		boolean[] primes = new boolean[nPrime + 2];
		primes[2] = true;
		for (int i = 0; i < nPrime; i++) {
			primes[i] = true;
		}
		for (int i = 2; i * i <= n; i += 1) {
			if (primes[i]) {
				for (int j = 2 * i; j * j <= n; j += i) {
					primes[j] = false;
				}
			}
		}
		for (int i = 2; i < primes.length; i++) {
			if (primes[i])
				res.add(i);
		}
		return res;
	}

	// https://www.hackerrank.com/challenges/one-month-preparation-kit-waiter/problem?h_l=interview&isFullScreen=true&playlist_slugs%5B%5D%5B%5D=preparation-kits&playlist_slugs%5B%5D%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D%5B%5D=one-month-week-three
	public static List<Integer> waiter(List<Integer> number, int q) {
		List<Integer> generatePrime = generatePrime(10000);
		List<Integer> res = new ArrayList<Integer>();
		List<Integer> A = new ArrayList<Integer>();
		for (int i = 0; i < number.size(); i++) {
			A.add(number.get(i));
		}
		int ithPrime = 0;
		boolean rev = true;
		while (q-- > 0) {
			if (rev) {
				for (int i = 0; i < A.size(); i++) {
					if (A.get(i) % generatePrime.get(ithPrime) == 0) {
						res.add(A.get(i));
						A.remove(i);
						i--;
					}
				}
			} else {
				for (int i = A.size() - 1; i >= 0; i--) {
					if (A.get(i) % generatePrime.get(ithPrime) == 0) {
						res.add(A.get(i));
						A.remove(i);
						i++;
					}
				}
			}
			ithPrime++;
			rev = !rev;
//			Collections.reverse(A);
		}
		if (rev) {
			for (int i = A.size() - 1; i >= 0; i--) {
				res.add(A.get(i));
			}
		} else {
			for (int i = 0; i < A.size(); i++) {
				res.add(A.get(i));
			}
		}
		return res;
	}

	private static void printList(List<Integer> generatePrime) {
		System.out.println("debug :" + Arrays.toString(generatePrime.toArray()));
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

	// https://www.hackerrank.com/challenges/one-month-preparation-kit-maxsubarray/problem?h_l=interview&isFullScreen=true&playlist_slugs%5B%5D%5B%5D=preparation-kits&playlist_slugs%5B%5D%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D%5B%5D=one-month-week-four&h_r=next-challenge&h_v=zen
	// learn more
	public static List<Integer> myMaxSubarray(List<Integer> arr) {
		List<Integer> result = new ArrayList<Integer>();
		int max_so_far = Integer.MIN_VALUE, max_end_here = 0, maxSum = 0;
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) > 0)
				maxSum += arr.get(i);
			max_end_here += arr.get(i);
			max_end_here = Math.max(max_end_here, arr.get(i));
			max_so_far = Math.max(max_so_far, max_end_here);
		}
		result.add(max_so_far);
		result.add(max_so_far < 0 ? max_so_far : maxSum);
		return result;
	}

	/*
	 * Complete the 'flippingMatrix' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * 2D_INTEGER_ARRAY matrix as parameter.
	 */
	public static int flippingMatrix(List<List<Integer>> matrix) {
		int maxSum = 0;
		int qsize = matrix.size() / 2;
		for (int row = 0; row < qsize; row++) {
			for (int col = 0; col < qsize; col++) {
				int s1 = matrix.get(row).get(2 * qsize - col - 1);
				int s2 = matrix.get(row).get(col);
				int s3 = matrix.get(2 * qsize - row - 1).get(col);
				int s4 = matrix.get(2 * qsize - row - 1).get(2 * qsize - col - 1);
				int highestValue = Math.max(s1, Math.max(s2, Math.max(s3, s4)));
				maxSum += highestValue;
			}
		}
		return maxSum;
	}

	public static int findDifPalind(String s) {
		int len = s.length();
		for (int i = 0; i < len / 2; i++) {
			if (s.charAt(i) != s.charAt(len - i - 1)) {
				return i;
			}
		}
		return -1;
	}

	public static int removeOneIndexToPalindrome(String s) {
		int idxDiff = findDifPalind(s);
		if (idxDiff == -1) {
			return -1;
		}
		StringBuilder sb = new StringBuilder(s);
		sb.deleteCharAt(idxDiff);
		if (findDifPalind(sb.toString()) == -1) {
			return idxDiff;
		}

		sb = new StringBuilder(s);
		sb.deleteCharAt(s.length() - idxDiff - 1);
		if (findDifPalind(sb.toString()) == -1) {
			return s.length() - idxDiff - 1;
		}
		return -1;
	}

	/**
	 * Complete the 'truckTour' function below.** The function is expected to return
	 * an INTEGER.* The function accepts 2D_INTEGER_ARRAY petrolpumps as parameter.
	 */
	public static int truckTour(List<List<Integer>> petrolpumps) {
		int nPetrol = petrolpumps.size();
		int j, k, sum;
		boolean foundSol;
		for (int i = 0; i < nPetrol; i++) {
			foundSol = true;
			j = i;
			k = 0;
			sum = 0;
			while (k < nPetrol) {
				int idxPetrol = j % nPetrol;
				sum += petrolpumps.get(idxPetrol).get(0) - petrolpumps.get(idxPetrol).get(1);
				if (sum < 0) {
					foundSol = false;
					break;
				}
				j++;
				k++;
			}
			if (foundSol)
				return i;
		}
		return -1;
	}

	public static int anagram(String s) {
		int lenS = s.length();
		if (lenS % 2 == 1) {
			return -1;
		}
		int[] freq = new int[26];
		for (int i = 0; i < lenS / 2; i++) {
			freq[s.charAt(i) - 'a']++;
		}
		for (int i = lenS / 2; i < lenS; i++) {
			freq[s.charAt(i) - 'a']--;
		}
		int count = 0;
		for (int i = 0; i < 26; i++) {
			if (freq[i] != 0) {
				count += Math.abs(freq[i]);
			}
		}
		return count / 2;
	}

	public static int findGCD(int a, int b) {
		while (b > 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	public static int findLCM(int a, int b) {
		return (a / findGCD(a, b)) * b;
	}

	public static int getTotalX(List<Integer> a, List<Integer> b) {
		int lenA = a.size();
		int lenB = b.size();
		int gcdOfB = b.get(0);
		for (int i = 1; i < lenB; i++) {
			gcdOfB = findGCD(gcdOfB, b.get(i));
		}
		int lmOfA = a.get(0);
		for (int i = 1; i < lenA; i++) {
			lmOfA = findLCM(lmOfA, a.get(i));
		}
		int count = 0;
		for (int i = lmOfA, div = 2; i <= gcdOfB; i = lmOfA * div, div++) {
			if (gcdOfB % i == 0) {
				count++;
			}
		}
		return count;
	}

	public static int pairs(int k, List<Integer> arr) {
		Collections.sort(arr);
		int count = 0;
		for (int i = 0; i < arr.size(); i++) {
			int x1 = arr.get(i) - k;
			int i1 = Collections.binarySearch(arr, x1);
			if (i1 >= 0 && i1 != i) {
				count++;
			}
		}
		return count;
	}

	public static List<String> bigSorting(List<String> arr) {
		Collections.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() < o2.length()) {
					return -1;
				}
				if (o1.length() > o2.length()) {
					return 1;
				}
				return o1.compareTo(o2);
			}
		});
		return arr;
	}

	public static int hackerlandRadioTransmitters(List<Integer> x, int k) {
		Collections.sort(x);
		int countTransmitter = 0;
		int i = 0;
		int sz = x.size();
		while (i < sz) {
			countTransmitter++;
			int cover = x.get(i) + k;
			while (i < sz && x.get(i) <= cover) {
				i++;
			}
			cover = x.get(i - 1) + k;
			while (i < sz && x.get(i) <= cover) {
				i++;
			}
		}
		return countTransmitter;
	}

	public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
		final int WEIGH = 6;
		List<Integer> res = new ArrayList<Integer>();

		boolean visited[] = new boolean[1002];
		for (int i = 1; i <= n; i++) {
			visited[i] = false;
		}

//        Queue<Integer> queue = new Queue<>();
//        queue.add()

		return res;
	}

	static final long MOD = 1000000007;

	public static int lego(int width, int height) {
		int[] s = new int[1001];
		int[] pows = new int[width + 1];
		for (int i = 0; i <= width; i++) {
			pows[i] = powmod(s[i], height);
		}
		int[] constr = new int[width + 1];
		constr[1] = 1;
		for (int i = 2; i <= width; i++) {
			constr[i] = pows[i];
			for (int j = 1; j < i; j++) {
				constr[i] = subMod(constr[i], mulMod(constr[j], pows[i - j]));
			}
		}
		return constr[width];
	}

	public static int mulMod(int a, int b) {
		return (int) (((long) a * b) % MOD);
	}

	public static int subMod(int a, int b) {
		return (int) (((long) a + MOD - b) % MOD);
	}

	public static int powmod(int a, int b) {
		long res = 1;
		long base = a % MOD;
		while (b != 0) {
			if (b % 2 == 1) {
				res = (res * base) % MOD;
			}
			base = (base * base) % MOD;
			b >>= 1;
		}
		return (int) (res % MOD);
	}

	static String maximumValuePalindUsingKChanges(String str, int k) {
		char palind[] = str.toCharArray();
		int left = 0;
		int right = str.length() - 1;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				palind[left] = palind[right] = (char) Math.max(str.charAt(left), str.charAt(right));
				k--;
			}
			left++;
			right--;
		}
		if (k < 0) {
			return "Not possible";
		}
		left = 0;
		right = str.length() - 1;
		while (left <= right) {
			if (left == right) {
				if (k > 0) {
					palind[left] = '9';
				}
			}
			if (palind[left] < '9') {
				if (k >= 2 && palind[left] == str.charAt(left) && palind[right] == str.charAt(right)) {
					k -= 2;
					palind[left] = palind[right] = '9';
				} else if (k >= 1 && (palind[left] != str.charAt(left) || palind[right] != str.charAt(right))) {
					k--;
					palind[left] = palind[right] = '9';
				}
			}
			left++;
			right--;
		}
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < palind.length; i++)
			res.append(palind[i]);
		return res.toString();
	}
	
 // ? https://www.hackerrank.com/challenges/one-month-preparation-kit-queries-with-fixed-length/problem?h_l=interview&isFullScreen=true&playlist_slugs%5B%5D%5B%5D=preparation-kits&playlist_slugs%5B%5D%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D%5B%5D=one-month-week-four
	public static int minMax(List<Integer>ar , int d) {
		Deque<Integer> deque = new ArrayDeque<>(d);
		for (int i = 0; i < d; i++) {
			addElement(deque, ar.get(i));
		}
		int min = deque.peekFirst();
		for (int i = d; i < ar.size(); i++) {
			if (ar.get(i - d) == deque.peekFirst())
				deque.removeFirst();
			addElement(deque, ar.get(i));
			int max = deque.peekFirst();
			if (max < min)
				min = max;
		}

		return min;
	}

	private static void addElement(Deque<Integer> deque, int newEl) {
		while (!deque.isEmpty() && deque.peekLast() < newEl) {
			deque.removeLast();
		}
		deque.offerLast(newEl);
	}

	public static List<Integer> solve(List<Integer> arr, List<Integer> queries) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < queries.size(); i++) {
			res.add(minMax(arr, queries.get(i)));
		}
		return res;
	}

	// fail with test 4 3 4 2 5 1
	public static int lilysHomework(List<Integer> arr) {
		List<Integer> sortedArr = new ArrayList<Integer>(arr);
		Collections.sort(sortedArr);
		int count = 0;
		for (int i = 0; i < sortedArr.size(); i++) {
			if (arr.get(i) != sortedArr.get(i)) {
				count++;
				int idx = -1; 
				for (int j = i + 1; j< arr.size(); j++) {
					if (arr.get(j) == sortedArr.get(i)) {
						idx = j;
						break;
					}
				}
//				System.out.println(idx + " " +sortedArr.get(i) + " in " + Arrays.toString(arr.toArray()));
				int temp = arr.get(i);
				arr.set(i, arr.get(idx));
				arr.set(idx, temp);
			}
		}
		return count;
    }
}

public class MonthHackerrank {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.txt"));

		
		int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result2.lilysHomework(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
        
	}
}