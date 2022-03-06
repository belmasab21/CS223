import java.util.ArrayList;

public class StringHeap {

	private ArrayList<String> heapArray;

	public StringHeap() {
		heapArray = new ArrayList<>();
	}

	public String top() {
		return heapArray.get(0);
	}

	private void swap(int index1, int index2) { // complete this method
		String ind1 = heapArray.get(index1);
		String ind2 = heapArray.get(index2);
		heapArray.set(index2, ind1);
		heapArray.set(index1, ind2);
	}

	public void insert(String value) { // complete this method
	    int currIndex = heapArray.size();
	    int parentIndex = (currIndex-1)/2;
	    heapArray.add(value);
	    while (currIndex > 0 && heapArray.get(parentIndex).compareTo(heapArray.get(currIndex)) > 0) {
	    	swap(parentIndex, currIndex);
	    	currIndex = parentIndex;
	    	parentIndex = (currIndex-1)/2;	    	
	    }

	}

	public void extract() { // complete this method
		swap(0, size() - 1);
		heapArray.remove(size() - 1);
		int currIndex = 0;
		int leftIndex = 1;
		int rightIndex = 2;
		while (leftIndex < heapArray.size()) {
			int minIndex = leftIndex;
			String minKey = heapArray.get(minIndex);
			if (rightIndex < heapArray.size()) {
				String rightKey = heapArray.get(rightIndex);
				if (rightKey.compareTo(minKey) < 0) {
					minIndex = rightIndex;
					minKey = rightKey;
				}				
			}
			if (minKey.compareTo(heapArray.get(currIndex)) < 0) {
				swap(minIndex, currIndex);
				currIndex = minIndex;
			}
			else {
				break;
			}
			leftIndex = 2 * currIndex + 1;
			rightIndex = leftIndex + 1;
		}
	}

	public static void heapSort(String array[], int arrayLen) throws Exception { // complete this method
		StringHeap obj = new StringHeap();
		for (int i = 0; i < arrayLen; i++) {
			obj.insert(array[i]);
		}
		for (int i = 0; i < arrayLen; i++) {
			array[i] = obj.top();
			obj.extract();
		} 
	}

	public int size() {
		return heapArray.size();
	}

	public String toString() {
		return heapArray.toString();
	}
}
