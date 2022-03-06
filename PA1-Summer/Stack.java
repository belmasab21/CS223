public class Stack {

    private int maxStackSize, topOfStack;
    private int[] stack;

    public Stack(int maxStackSize) {
        if (maxStackSize <= 0)
            System.out.println("Stack size should be a positive integer.");
        else {
            this.maxStackSize = maxStackSize;
            topOfStack = -1;
            stack = new int[maxStackSize];
        }
    }

    public void push(int val) {
        if (topOfStack >= (maxStackSize - 1)) {
            System.out.println("Overflow");   
           }
        else {
            stack[++topOfStack] = val;
            System.out.println(val + " pushed into stack");
           }
    }

    public int pop() { 
        if (topOfStack < 0) {
            System.out.println("Overflow");
            return 0;
           }
        else {
            int x = stack[topOfStack--];
            return x;
           }
    }

    public int size() { 
        return (topOfStack + 1);
    
    }
}