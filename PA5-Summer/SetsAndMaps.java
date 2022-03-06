import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;


public class SetsAndMaps {

	public static ArrayList<Character> sortedAlphabet(char[] arr, int len) { // complete this method
		TreeSet<Character> orderedAlph = new TreeSet<>();
		ArrayList<Character> returnAlph = new ArrayList<>();
		int i = 0;
		while (i < len) {
			orderedAlph.add(arr[i]);
			i++;
		}
			Iterator<Character> itr = orderedAlph.iterator();
			while (itr.hasNext()) {
				returnAlph.add(itr.next());
			}
			return returnAlph;
		}
		
	


	public static void bstSort(char[] arr, int len) { // complete this method
		TreeMap<Character, Integer> myMap = new TreeMap<>();
		for (int i = 0; i < len; i++) {
			if (!myMap.containsKey(arr[i])) {
				myMap.put(arr[i], 1);
			}
			else {
				Integer value = myMap.get(arr[i]);
				value = value + 1;
				myMap.put(arr[i], value);
			}
		}
			Iterator<Character> itr = myMap.keySet().iterator();
			int count = 0;
			while (itr.hasNext()) {
				Character key = itr.next();
				Integer value = myMap.get(key);				
				for (int j = 0; j < value; j++) {					
					arr[count] = key;
					count++;				
			}
		}
	}

	public static boolean zeroSumSubArray(int[] arr, int len) { // complete this method
		HashSet<Integer> mySet = new HashSet<>();
		int prefixSum = 0;
		for (int i = 0; i < len; i++) {
			prefixSum += arr[i];
			if (prefixSum == 0) {
				return true;
			}
			if (mySet.contains(prefixSum) == true) {
				return true;
			}
			else {
				mySet.add(prefixSum);
			}			
		}
		return false;
	}
}
