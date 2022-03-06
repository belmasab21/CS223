
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class IOHelper {

	public static ArrayList<Student> readStudents(String filePath) throws FileNotFoundException { // complete this method
		ArrayList<Student> studentList = new ArrayList<>();
		Scanner sc = new Scanner(new FileInputStream(filePath));
		
		String name;
		int grade;
		while (sc.hasNextLine()) {
			name = sc.next();
			grade = sc.nextInt();	
			Student student = new Student(name, grade);
			studentList.add(student);
		}
		sc.close();
		return studentList;
	}

	public static Graph readWeightedGraph(String filePath) throws FileNotFoundException { // complete this method
		Scanner fileReader = new Scanner(new FileInputStream(filePath));
		Graph graph = new Graph();
		graph.numVertices = fileReader.nextInt();
		graph.adjList = new ArrayList<ArrayList<Edge>>(graph.numVertices);
		for (int i = 0; i < graph.numVertices; i++) {
			graph.adjList.add(new ArrayList<Edge>());
		}
		while (fileReader.hasNext()) {
			int src, dest, weight;
			src = fileReader.nextInt();
			dest = fileReader.nextInt();
			weight = fileReader.nextInt();
			Edge e = new Edge(src, dest, weight);
			ArrayList<Edge> newList;
			newList = graph.adjList.get(src);
			newList.add(e);
		}
		fileReader.close();
		return graph;
	}	
}
