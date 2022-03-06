
public class HashingWithChaining {

    LinkedList hashTable[];
    int TABLE_SIZE;
    int TOMBSTONE = -2;

    public HashingWithChaining(int tableSize) {
        TABLE_SIZE = tableSize;
        hashTable = new LinkedList[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
            hashTable[i] = new LinkedList();
    }

    protected int getHashValue(int val) {
        return (37 * val + 61) % TABLE_SIZE;
    }

    public boolean search(int key) { // complete this method
        int hashValue = getHashValue(key);
        LinkedList tmp = hashTable[hashValue];
        ListNode iNode = tmp.head;
        while (iNode != null) {
            if (iNode.value == key) {
                return true;
            }
            iNode = iNode.next;
        }
        return false;
    }

    public boolean insert(int val) { // complete this method
        if (search(val)) {
            return false;
        }
        int hashValue = getHashValue(val);
        LinkedList tmp = hashTable[hashValue];
        tmp.insertAtEnd(val);
        return true;	    
    }

    public boolean remove(int val) { // complete this method
        int hashValue = getHashValue(val);
        LinkedList tmp = hashTable[hashValue];
        ListNode iNode = tmp.head;
        if (tmp.getSize() == 0) {
            return false;
        }
            else if (tmp.head.value == val) {
                tmp.deleteHead();
                return true;
            }
        while (iNode.next != null) {
            if (iNode.next.value == val) {
                tmp.deleteAfter(iNode);
                return true;
            }
            else {
                iNode = iNode.next;
            }
        }
        return false;
    }

    public void printStatistics() {
        int maxSize = hashTable[0].size;
        int minSize = maxSize, total = maxSize;
        for (int i = 1; i < TABLE_SIZE; i++) {
            int size = hashTable[i].size;
            if (size > maxSize)
                maxSize = size;
            else if (size < minSize)
                minSize = size;
            total += size;
        }
        System.out.printf(
            "Max length of a chain = %d%n" + "Min length of a chain = %d%n" + "Avg length of chains = %d%n",
            maxSize, minSize, total / TABLE_SIZE);
    }
}
