
import java.util.ArrayList;
import java.util.Arrays;

public class TestCorrectness {

	static final String DIJKSTRA1 = "dijkstra1.txt";
	static final String DIJKSTRA2 = "dijkstra2.txt";
	static final String STUDENT = "students.txt";

	private static ArrayList<ArrayList<Integer>> arraysToLists(int[][] arrays, int arrayLengths[], int n) {
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>(n);
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>(arrayLengths[i]);
			for (int j = 0; j < arrayLengths[i]; j++)
				list.add(arrays[i][j]);
			lists.add(list);
		}
		return lists;
	}

	private static void testTopKElements() throws Exception {

		System.out.println("*** Test Top-k ***\n");
		ArrayList<Student> students = IOHelper.readStudents(STUDENT);
		System.out.printf("Original Array:     %s%n", students);
		ArrayList<Student> top3 = PriorityQueueApplications.topK(students, 3);
		ArrayList<Student> top7 = PriorityQueueApplications.topK(students, 7);
		ArrayList<Student> all = PriorityQueueApplications.topK(students, students.size());
		System.out.print("Highest 3 students: " + top3);
		System.out.println();
		System.out.print("Highest 7 students: " + top7);
		System.out.println();
		System.out.printf("All students:       " + all);
	}

	private static void testKSortedMerge() {
		System.out.println("\n\n*** Test Merging k Sorted Arrays ***\n");
		int list0[] = { 1, 5, 9, 18 };
		int list1[] = { -10, 5, 18, 67, 100 };
		int list2[] = { -12, -9, -6, 0, 1, };
		int list3[] = { -65, -32, 10, };
		int list4[] = { 1, 19, 45, 67 };
		int lists[][] = { list0, list1, list2, list3, list4 };
		int k = lists.length;
		int eachListLength[] = new int[k];
		for (int i = 0; i < k; i++)
			eachListLength[i] = lists[i].length;
		ArrayList<Integer> mergedList = PriorityQueueApplications.kWayMerge(arraysToLists(lists, eachListLength, k));
		System.out.println("Original sorted arrays");
		for (int i = 0; i < k; i++)
			System.out.println(Arrays.toString(lists[i]));
		System.out.println("\nFinal merged array: " + mergedList + "\n");

		k = 4;
		eachListLength = new int[k];
		for (int i = 0; i < k; i++)
			eachListLength[i] = lists[i].length;
		mergedList = PriorityQueueApplications.kWayMerge(arraysToLists(lists, eachListLength, k));
		System.out.println("Original sorted arrays");
		for (int i = 0; i < k; i++)
			System.out.println(Arrays.toString(lists[i]));
		System.out.println("\nFinal merged array: " + mergedList + "\n");

		k = 2;
		eachListLength = new int[k];
		for (int i = 0; i < k; i++)
			eachListLength[i] = lists[i].length;
		mergedList = PriorityQueueApplications.kWayMerge(arraysToLists(lists, eachListLength, k));
		System.out.println("Original sorted arrays");
		for (int i = 0; i < k; i++)
			System.out.println(Arrays.toString(lists[i]));
		System.out.println("\nFinal merged array: " + mergedList + "\n");

		k = 1;
		eachListLength = new int[k];
		for (int i = 0; i < k; i++)
			eachListLength[i] = lists[i].length;
		mergedList = PriorityQueueApplications.kWayMerge(arraysToLists(lists, eachListLength, k));
		System.out.println("Original sorted arrays");
		for (int i = 0; i < k; i++)
			System.out.println(Arrays.toString(lists[i]));
		System.out.println("\nFinal merged array: " + mergedList);
	}

	private static void testDijkstra() throws Exception {
		String filePaths[] = { DIJKSTRA1, DIJKSTRA2 };
		for (int j = 0; j < filePaths.length; j++) {
			System.out.println("\n*** Test Dijkstra (" + filePaths[j] + ") ***");
			Dijkstra dijk = new Dijkstra(filePaths[j]);
			for (int i = 0; i < dijk.numVertices; i++) {
				dijk.execute(i);
				System.out.println("\nDistance array (from v" + i + "): "
						+ Arrays.toString(dijk.distance).replaceAll("" + Integer.MAX_VALUE, "infty"));
				System.out.println("Parent array (from v" + i + "):   "
						+ Arrays.toString(dijk.parent).replaceAll("" + Integer.MAX_VALUE, "infty"));
			}
		}
	}

	private static void testUnionFind() {
		System.out.println("\n****************** Union Find ******************\n");
		UnionFind uf = new UnionFind(16);
		System.out.println("Initial sets are 0-15\n");
		for (int i = 0; i < 15; i += 4) {
			System.out.printf("UNION(%d,%d)%n", i, i + 1);
			uf.doUnion(i, i + 1);
		}
		System.out.println();
		for (int i = 0; i < 16; i++) {
			System.out.printf("List containing %2d: %s%n", i, uf.find(i));
		}
		System.out.println("\nUNION(0,5)");
		System.out.println("UNION(10,12)");
		System.out.println("UNION(0,10)\n");
		uf.doUnion(0, 5);
		uf.doUnion(10, 12);
		uf.doUnion(0, 10);
		for (int i = 0; i < 16; i++) {
			System.out.printf("List containing %2d: %s%n", i, uf.find(i));
		}
		System.out.println("\nUNION(6,8)");
		System.out.println("UNION(8,5)\n");
		uf.doUnion(6, 8);
		uf.doUnion(8, 5);
		for (int i = 0; i < 16; i++) {
			System.out.printf("List containing %2d: %s%n", i, uf.find(i));
		}
	}

	public static void main(String[] args) throws Exception {
		testTopKElements();
		testKSortedMerge();
		testDijkstra();
		testUnionFind();
	}
}
