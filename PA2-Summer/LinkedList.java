public class LinkedList {

    public ListNode head, tail;
    public int size;

    public LinkedList() {
        head = tail = null;
        size = 0;
    }

    public void insertAfter(ListNode argNode, int value) { // complete this method
        ListNode newNode = new ListNode(value);
        newNode.next = argNode.next;
        argNode.next = newNode;
        if (argNode == tail) {
            tail = newNode;
        }
        size++;
    }

    public void deleteAfter(ListNode argNode) { // complete this method
        if (argNode == tail) {
            return;
        }
        else if (argNode.next == tail) {
            tail = null;
            tail = argNode;
            size--;
        }
        else {
            ListNode temp = argNode.next;
            argNode.next = temp.next;
            temp = null;
            size--;
        }
    }

    public void selectionSort() { // complete this method
        ListNode iNode;
        for (iNode = head; iNode != null; iNode = iNode.next) {
            ListNode jNode;
            ListNode minNode = iNode;
            for (jNode = iNode.next; jNode != null; jNode = jNode.next) {               
                if (jNode.value < minNode.value) {
                    minNode = jNode;
                }
            }
            int temp = minNode.value;
            minNode.value = iNode.value;
            iNode.value = temp;
        }
    }

    public boolean removeDuplicatesSorted() { // complete this method
        ListNode curr = head;
        for (curr = head; curr != tail; curr = curr.next) {
            if (curr.next.value < curr.value) {
                return false;
            }
        }
        curr = head;
        while (curr != tail) {
            if (curr.value == curr.next.value) {
                deleteAfter(curr);
            }
            else {
                curr = curr.next;
            }
        }
        return true;
    }

    public void pushOddIndexesToTheBack() { // complete this method
        ListNode temp = head;
        for (int i = 0; i < size - 1; i+=2) {
            insertAtEnd(temp.next.value);
            deleteAfter(temp);
            temp = temp.next;
        }
    }

    public void swapFirstAndLast() {
        ListNode curr = head;
        ListNode temp = null;
        ListNode index = null;
        if (head == null) {
            return;
        } else {
            while (curr.next != null) {
                index = curr;
                curr = curr.next;
            }
            if (head == curr) {
                return;
            }
            else if (head.next == curr) {
                temp = head;
                head = curr;
                head.next = temp;
                temp.next = null;
            }
            else {
                temp = head;
                head = curr;
                head.next = temp.next;
                index.next = temp;
                temp.next = null;
            }
        }
    }

    public void reverse() { // complete this method           
        if (size <= 1) {
            return;
        }
        ListNode prev = head;
        ListNode curr = head.next;            
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode temp = tail;
        tail = head;
        head = temp;
        tail.next = null;
    }

    ListNode insertAtFront(int value) {
        ListNode newNode = new ListNode(value);
        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
        return newNode;
    }

    ListNode insertAtEnd(int value) {
        ListNode newNode = new ListNode(value);
        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return newNode;
    }

    void deleteHead() {
        if (0 == size) {
            System.out.println("Cannot delete from an empty list");
        } else if (1 == size) {
            head = tail = null;
            size--;
        } else {
            size--;
            ListNode tmp = head;
            head = head.next;
            tmp.next = null;
            tmp = null;
        }
    }

    public ListNode getNodeAt(int pos) {
        if (pos < 0 || pos >= size || 0 == size) {
            System.out.println("No such position exists");
            return null;
        } else {
            ListNode tmp = head;
            for (int i = 0; i < pos; i++)
                tmp = tmp.next;
            return tmp;
        }
    }

    void printList() {
        if (size == 0)
            System.out.println("[]");
        else {
            ListNode tmp = head;
            String output = "[";
            for (int i = 0; i < size - 1; i++) {
                output += tmp.value + " -> ";
                tmp = tmp.next;
            }
            output += tail.value + "]";
            System.out.println(output);
        }
    }

    public int getSize() {
        return size;
    }
}
