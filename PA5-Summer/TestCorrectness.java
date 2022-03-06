
import java.util.Arrays;

public class TestCorrectness {

	private static void testCommonElements() {
		System.out.println("*** Test Common Elements in Sorted Arrays ***\n");
		int A[] = { 1, 1, 3, 7, 9, 14, 14, 14, 14, 14, 14, 18, 23, 39, 39, 39 };
		int B[] = { 1, 1, 5, 7, 9, 14, 23, 27, 39, 39 };
		System.out.println("Array 1: " + Arrays.toString(A));
		System.out.println("Array 2: " + Arrays.toString(B));
		System.out.println("Common elements are " + MergeSortAndFriends.commonElements(A, B, A.length, B.length));

		int C[] = { 1, 1, 3, 7, 9, 14, 14, 14, 14, 14, 14, 18, 23, 39, 39, 39 };
		int D[] = { 8, 17, 17, 26, 38, 43, 43 };
		System.out.println("\nArray 1: " + Arrays.toString(C));
		System.out.println("Array 2: " + Arrays.toString(D));
		System.out.println("Common elements are " + MergeSortAndFriends.commonElements(C, D, C.length, D.length));

		int E[] = { 1, 3, 7, 9, 14, 18, 23, 39 };
		int F[] = { 1, 5, 7, 9, 14, 39 };
		System.out.println("\nArray 1: " + Arrays.toString(E));
		System.out.println("Array 2: " + Arrays.toString(F));
		System.out.println("Common elements are " + MergeSortAndFriends.commonElements(E, F, E.length, F.length));
	}

	private static void testMergesort() {
		System.out.println("*** Test Mergesort ***\n");
		String A[] = { "abc", "def", "abcd", "bce", "abx", "acfe", "bfr", "xyz", "de", "tyu", "ab", "abcd", "xy", "zxy",
				"abx", "def" };
		System.out.println("Original Array: " + Arrays.toString(A));
		MergeSortAndFriends.mergeSort(A, 0, A.length - 1);
		System.out.println("Sorted Array:   " + Arrays.toString(A));
	}

	public static void testOrdered() {
		System.out.println("*** Using Ordered Set & Map ***\n");
		char[] str = { 'a', 'b', 'r', 'a', 'c', 'a', 'd', 'a', 'b', 'r', 'a', '$' };
		System.out
				.println("Alphabet of " + Arrays.toString(str) + " is " + SetsAndMaps.sortedAlphabet(str, str.length));

		System.out.print("Sorted order of " + Arrays.toString(str) + " is ");
		SetsAndMaps.bstSort(str, str.length);
		System.out.println(Arrays.toString(str));
	}

	private static void testZeroSumHelper(int[] arr, int len) {
		boolean isZero = SetsAndMaps.zeroSumSubArray(arr, len);
		System.out.printf("\n%s", Arrays.toString(arr));
		if (!isZero)
			System.out.printf(" has no subarray whose sum is zero.");
		else
			System.out.printf(" has a subarray whose sum is zero.");
	}

	private static void testZeroSum() {
		System.out.println("*** Using Unordered Set ***");
		int[] arr1 = { 12, -26, 1, 8, 9, -6, 4, -12, -3, 12 };
		testZeroSumHelper(arr1, arr1.length);
		int[] arr2 = { 1, 7, 19, -14, 1, -14, 12 };
		testZeroSumHelper(arr2, arr2.length);
		int[] arr3 = { 1, 7, 19, -14, 1, -14, 8, 9, -6, 4, -12, -3, 12 };
		testZeroSumHelper(arr3, arr3.length);
		int[] arr4 = { -6, 4, -12, -3, 12 };
		testZeroSumHelper(arr4, arr4.length);
		int[] arr5 = { -6, 4, -12, 0, -3, 12 };
		testZeroSumHelper(arr5, arr5.length);
		int[] arr6 = { 0, -6, 4, -12, -3, 12 };
		testZeroSumHelper(arr6, arr6.length);
		int[] arr7 = { 1, 8, 9, -6, 4, -12, -3 };
		testZeroSumHelper(arr7, arr7.length);
		int[] arr8 = { 1, 8, 9, 0 };
		testZeroSumHelper(arr8, arr8.length);
	}

	private static void testTrie() {
		System.out.println("*** Test Trie (Spell Checker) ***\n");
		Trie trie = new Trie();
		String dictionary[] = { "abc$", "abcd$", "bce$", "abx$", "acfe$", "bfr$", "de$" };
		for (int i = 0; i < 7; i++)
			trie.insert(dictionary[i]);

		String document[] = { "abc", "def", "abcd", "bce", "abx", "acfe", "bfr", "xyz", "de", "tyu", "ab" };
		int numWordsInDoc = 11;
		boolean spellCheck[] = new boolean[numWordsInDoc];

		for (int i = 0; i < numWordsInDoc; i++) {
			spellCheck[i] = trie.search(document[i] + "$");
		}

		System.out.println("Dictionary: " + Arrays.toString(dictionary));
		System.out.println("Document:   " + Arrays.toString(document));
		System.out.print("\nIncorrect spellings: ");
		for (int i = 0; i < numWordsInDoc; i++) {
			if (!spellCheck[i])
				System.out.print(document[i] + " ");
		}
	}

	private static void testLCS() {
		System.out.println("\n*** Test Trie (Longest Common Substring) ***\n");
		String str1 = "abbcabdb";
		String str2 = "cbccabd";
		System.out.printf("Longest Common Substring of %s and %s is %s%n", str1, str2,
				Trie.longestCommonSubstring(str1, str2));

		str1 = "abbcabdb";
		str2 = "abbcabdb";
		System.out.printf("Longest Common Substring of %s and %s is %s%n", str1, str2,
				Trie.longestCommonSubstring(str1, str2));

		str1 = "abbcabdb";
		str2 = "xyyzex";
		System.out.printf("Longest Common Substring of %s and %s is %s%n", str1, str2,
				Trie.longestCommonSubstring(str1, str2));

		str1 = "zxabcdezy";
		str2 = "yzabcdezx";
		System.out.printf("Longest Common Substring of %s and %s is %s%n", str1, str2,
				Trie.longestCommonSubstring(str1, str2));

		str1 = "Hello World!";
		str2 = "Hi World!";
		System.out.printf("Longest Common Substring of %s and %s is %s%n", str1, str2,
				Trie.longestCommonSubstring(str1, str2));
	}

	public static void testHeapSort() throws Exception {
		System.out.println("*** Test Heap Sort ***\n");
		String[] array = { "abc", "def", "abcd", "bce", "abx", "acfe", "bfr", "xyz", "de", "tyu", "ab", "abcd", "xy",
				"zxy", "abx", "def" };
		System.out.println("Before Sorting: " + Arrays.toString(array));
		StringHeap.heapSort(array, array.length);
		System.out.println("After Sorting:  " + Arrays.toString(array));
	}

	public static void main(String[] args) throws Exception {
		testCommonElements();
		System.out.println();
		testMergesort();
		System.out.println();
		testOrdered();
		System.out.println();
		testZeroSum();
		System.out.println("\n");
		testTrie();
		System.out.println();
		testLCS();
		System.out.println();
		testHeapSort();
	}
}
