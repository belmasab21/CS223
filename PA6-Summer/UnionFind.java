
import java.util.ArrayList;

public class UnionFind {

	private ArrayList<ArrayList<Integer>> representatives;

	public UnionFind(int initialNumSets) { // complete this constructor 
		representatives = new  ArrayList<ArrayList<Integer>>(initialNumSets);
		for (int i = 0; i < initialNumSets; i++) {
			representatives.add(new ArrayList<Integer>());
			makeSet(i);
		}
	}

	public void makeSet(int x) { // complete this method
		ArrayList<Integer> da = new ArrayList<>();
		da.add(x);
		representatives.set(x, da);
	}

	public ArrayList<Integer> find(int x) { // complete this method
		return representatives.get(x);
	}

	private void append(ArrayList<Integer> arg1, ArrayList<Integer> arg2) { // complete this method
		while (arg2.size() != 0) {
			int x = arg2.get(arg2.size()-1);
			arg2.remove(arg2.size()-1);
			representatives.set(x, arg1);
			arg1.add(x);
		}
	}

	public void doUnion(int x, int y) { // complete this method
		ArrayList<Integer> daX = new ArrayList<>();
		ArrayList<Integer> daY = new ArrayList<>();
		daX = find(x);
		daY = find(y);
		if (daX != daY) {
			if (daX.size() >= daY.size()) {
				append(daX, daY);
			}
			else {
				append(daY, daX);
			}
		}
	}
}
