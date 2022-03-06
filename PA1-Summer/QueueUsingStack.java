public class QueueUsingStack {

    Stack mainStack;
    int maxQueueSize;
    
    public QueueUsingStack(int maxQueueSize) {
        this.maxQueueSize = maxQueueSize;
        mainStack = new Stack(maxQueueSize);
    }

    public void enqueue(int val) { 
        if (mainStack.size() == maxQueueSize) {
            System.out.println("Queue is full");
           }
           else {
            Stack tempStack = new Stack(mainStack.size());
           }
    }

    public int dequeue() {
       if (mainStack.size() == 0) {
        System.out.println("Queue is empty");   
       }
       else {
           return mainStack.pop();
           }
           return -1;
       }
    

    public int size() {
      return mainStack.size();
    }

	public String toString() {
		if (size() == 0) {
			return "[]";
		} else {
			String output = "[";
			int n = size();
			for (int i = 0; i < n - 1; i++) {
				int x = dequeue();
				output += x + ", ";
				enqueue(x);
			}
			int x = dequeue();
			output += x + "]";
			enqueue(x);
			return output;
		}
	}
}