
import java.util.Arrays;

public class TestCorrectness {

	final static int insertionArray[] = { 11, 12, 15, 17, 12, 19, 4, 5, 11, 19, 20, 32, 77, 65, 66, 88, 99, 10, 8, 19,
			15, 66, 11, 19, 0, 3, 2, 55, 67, 78, 39 };
	final static int numInsert = insertionArray.length;

	final static int searchArray[] = { 29, 3, 19, 27, 12, 34, 4, 5, 19, 20, 32, 45, 37, 25, 99, 25, 8, 24, 12, 16 };
	final static int numSearch = searchArray.length;

	final static int deleteArray[] = { 11, 16, 12, 15, 5, 17, 19, 4, 5, 20, 32, 17, 19, 39, 99, 10, 8, 19, 15, 21, 0, 55 };
	final static int numDelete = deleteArray.length;

	final static int[] cleanUp = { 77, 65, 3, 66, 2, 88, 78, 39, 67 };
	final static int numCleanUp = cleanUp.length;

	final static int CHAINING_TABLE_SIZE = 7;
	final static int INITIAL_PROBING_TABLE_SIZE = 4;

	public static HashingWithChaining testChaining() throws Exception {

		System.out.println("****************** Test Hashing With Chaining ******************\n");
		HashingWithChaining hChain = new HashingWithChaining(CHAINING_TABLE_SIZE);

		System.out.println("Inserting the following numbers: " + Arrays.toString(insertionArray));

		for (int i = 0; i < numInsert; i++) {
			hChain.insert(insertionArray[i]);
		}

		System.out.println("\n*** Hash Table Structure (after insertion) ***");
		int size = 0;
		for (int i = 0; i < CHAINING_TABLE_SIZE; i++) {
			System.out.print("Slot " + i + ": ");
			hChain.hashTable[i].printList();
			size += hChain.hashTable[i].getSize();
		}
		System.out.println("\nSize of hash table: " + size);

		System.out.println("\n*** Searching Hash Table ***");
		LinkedList foundList = new LinkedList();
		LinkedList notFoundList = new LinkedList();

		for (int i = 0; i < numSearch; i++) {
			int val = searchArray[i];
			if (hChain.search(val))
				foundList.insertAtEnd(val);
			else
				notFoundList.insertAtEnd(val);
		}
		System.out.print("Found: ");
		foundList.printList();
		System.out.print("Did not find: ");
		notFoundList.printList();

		System.out.print("\n*** Deleting Hash Table ***");

		LinkedList deleteList = new LinkedList();
		notFoundList = new LinkedList();
		System.out.println();
		for (int i = 0; i < numDelete; i++) {
			int val = deleteArray[i];
			if (hChain.remove(val))
				deleteList.insertAtEnd(val);
			else
				notFoundList.insertAtEnd(val);
		}
		System.out.print("Deleted: ");
		deleteList.printList();
		System.out.print("Did not find: ");
		notFoundList.printList();

		System.out.println("\n*** Hash Table Structure (after deletion) ***");
		size = 0;
		for (int i = 0; i < CHAINING_TABLE_SIZE; i++) {
			System.out.print("Slot " + i + ": ");
			hChain.hashTable[i].printList();
			size += hChain.hashTable[i].getSize();
		}
		System.out.println("\nSize of hash table: " + size);
		return hChain;
	}

	public static HashingWithProbing testProbing() throws Exception {

		System.out.println("\n****************** Test Hashing With Probing ******************\n");
		HashingWithProbing hProbing = new HashingWithProbing(INITIAL_PROBING_TABLE_SIZE);

		System.out.println("Inserting the following numbers: " + Arrays.toString(insertionArray));

		for (int i = 0; i < numInsert; i++) {
			hProbing.insert(insertionArray[i]);
		}

		System.out.println("\n*** Hash Table Structure (after insertion) ***");
		System.out.println(Arrays.toString(hProbing.hashTable));
		System.out.println("\nSize of hash table: " + hProbing.size);

		System.out.println("\n*** Searching Hash Table ***");
		LinkedList foundList = new LinkedList();
		LinkedList notFoundList = new LinkedList();

		for (int i = 0; i < numSearch; i++) {
			int val = searchArray[i];
			if (hProbing.search(val) >= 0)
				foundList.insertAtEnd(val);
			else
				notFoundList.insertAtEnd(val);
		}
		System.out.print("Found: ");
		foundList.printList();
		System.out.print("Did not find: ");
		notFoundList.printList();

		System.out.print("\n*** Deleting Hash Table ***");

		LinkedList deleteList = new LinkedList();
		notFoundList = new LinkedList();
		System.out.println();
		for (int i = 0; i < numDelete; i++) {
			int val = deleteArray[i];
			if (hProbing.remove(val) >= 0)
				deleteList.insertAtEnd(val);
			else
				notFoundList.insertAtEnd(val);
		}
		System.out.print("Deleted: ");
		deleteList.printList();
		System.out.print("Did not find: ");
		notFoundList.printList();

		System.out.println("\n*** Hash Table Structure (after deletion) ***");
		System.out.println(Arrays.toString(hProbing.hashTable));
		System.out.println("\nSize of hash table: " + hProbing.size);
		return hProbing;
	}

	private static BST testBST() {
		System.out.println("\n****************** Test BST ******************\n");

		BST bst = new BST();

		System.out.println("Inserting the following numbers: " + Arrays.toString(insertionArray));

		for (int i = 0; i < numInsert; i++) {
			bst.insert(insertionArray[i]);
		}

		System.out.println("\n*** BST Structure (after insertion) ***");
		bst.print();
		System.out.println("\n\nSize of BST: " + bst.getSize());

		System.out.println("\n*** Searching BST ***");
		LinkedList foundList = new LinkedList();
		LinkedList notFoundList = new LinkedList();

		for (int i = 0; i < numSearch; i++) {
			int val = searchArray[i];
			if (bst.search(val) != null)
				foundList.insertAtEnd(val);
			else
				notFoundList.insertAtEnd(val);
		}
		System.out.print("Found: ");
		foundList.printList();
		System.out.print("Did not find: ");
		notFoundList.printList();

		System.out.print("\n*** Deleting BST ***");

		LinkedList deleteList = new LinkedList();
		notFoundList = new LinkedList();
		System.out.println();
		for (int i = 0; i < numDelete; i++) {
			int val = deleteArray[i];
			if (bst.remove(val))
				deleteList.insertAtEnd(val);
			else
				notFoundList.insertAtEnd(val);
		}
		System.out.print("Deleted: ");
		deleteList.printList();
		System.out.print("Did not find: ");
		notFoundList.printList();

		System.out.println("\n*** BST Structure (after deletion) ***");
		bst.print();
		System.out.println("\n\nSize of BST: " + bst.getSize());
		return bst;
	}

	private static void testBSTApplications() throws Exception {
		System.out.println("****************** Test BST Applications ******************\n");
		int testArray[] = { 25, 17, 10, 23, 36, 34, 48, 40, 54 };
		System.out.println("Numbers in BST: " + Arrays.toString(testArray));
		System.out.println();
		BST bst = new BST(testArray);
		int KEY[] = { 10, 54, 34, 9, 57, 44, 47, 43 };
		for (int key : KEY) {
			int successor = bst.getSuccessor(key);
			int predecessor = bst.getPredecessor(key);
			System.out.print("key = " + key + ": ");
			if (predecessor == Integer.MIN_VALUE)
				System.out.print("predecessor = -infty; ");
			else
				System.out.print("predecessor = " + predecessor + "; ");
			if (successor == Integer.MAX_VALUE)
				System.out.print("successor = infty; ");
			else
				System.out.print("successor = " + successor + "; ");
			System.out.println("nearest neighbour = " + bst.nearestNeighbour(key));
		}
	}

	private static void cleanTest(HashingWithChaining chaining, HashingWithProbing probing, BST bst) {
		System.out.println("\n****************** Clean up ******************");
		for (int i : cleanUp) {
			chaining.remove(i);
			probing.remove(i);
			bst.remove(i);
		}
		int size = 0;
		for (int i = 0; i < CHAINING_TABLE_SIZE; i++)
			size += chaining.hashTable[i].getSize();

		System.out.println("\nSize of chaining: " + size);
		System.out.println("Size of probing: " + probing.size);
		System.out.println("Size of BST: " + bst.getSize());
	}

	public static void main(String[] args) throws Exception {
		HashingWithChaining chaining = testChaining();
		HashingWithProbing probing = testProbing();
		BST bst = testBST();
		cleanTest(chaining, probing, bst);
		System.out.println();
		testBSTApplications();
	}
}
