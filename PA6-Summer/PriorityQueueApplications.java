
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;

public class PriorityQueueApplications {
	//public static Comparator<Student> comparator;

	//PriorityQueueApplications(Comparator<Student> comparator) { // Constructor will set the comparator for the specific class
	//	this.comparator = comparator;
//	}

	public static ArrayList<Student> topK(ArrayList<Student> students, int k) { // complete this method
		if (k > students.size()) {
			k = students.size();
		}
		PriorityQueue<Student> pq = new PriorityQueue<>(new StudentComparator());
		for (int i = 0; i < k; i++) {
			 pq.add(students.get(i));
		}
		StudentComparator newComp = new StudentComparator();
		for (int i = k; i < students.size(); i++) {
			Student min = pq.peek();
			Student current = students.get(i);
			if (newComp.compare(min, current) < 0) { 
				pq.remove();
				pq.add(current);
			}
		}
		int pqSize = pq.size();
		ArrayList<Student> studentList = new ArrayList<>();
		for (int i = 0; i < pqSize; i++) {
			Student removeS = pq.remove();
			studentList.add(removeS);
			//studentList.add(students.get(i));
		}
		return studentList;
	}

	public static ArrayList<Integer> kWayMerge(ArrayList<ArrayList<Integer>> lists) { // complete this method
		PriorityQueue<PriorityQueuePair> pq = new PriorityQueue<>(new PriorityQueuePairComparator());
		ArrayList<Integer> da = new ArrayList<>();
		for (int i = 0; i < lists.size(); i++) {			
			int a = lists.get(i).get(0);
			PriorityQueuePair pqp = new PriorityQueuePair(i, a);
			pq.add(pqp);
		}
		int[] indexes = new int[lists.size()];
		for (int i = 0; i < indexes.length; i++) {
			indexes[i] = 1;
		}
		while (pq.isEmpty() == false) {
			PriorityQueuePair min = pq.peek();
			pq.remove();
			da.add(min.priority);
			int minItem = min.item;
			if (indexes[minItem] < lists.get(minItem).size()) {
				PriorityQueuePair pqpTwo = new PriorityQueuePair(minItem, lists.get(minItem).get(indexes[minItem]));
				pq.add(pqpTwo);
				indexes[minItem]++;
			}
		}
		return da;
	}
}
