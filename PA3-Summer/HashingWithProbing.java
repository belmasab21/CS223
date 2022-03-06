
public class HashingWithProbing {

    public int hashTable[];
    public int TABLE_SIZE;
    public int size;
    public int garbage;

    public static final int EMPTY = -1;
    public static final int TOMBSTONE = -9;

    private int getHashValue(int val) {
        return (37 * val + 61) % TABLE_SIZE;
    }

    public HashingWithProbing(int tableSize) {
        TABLE_SIZE = tableSize;
        size = 0;
        garbage = 0;
        hashTable = new int[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
            hashTable[i] = EMPTY;
    }

    private void resize(int newTableSize) { // complete this method
        int[] keys = new int[size];
        int count = 0;
        for (int i = 0; i < TABLE_SIZE; i++) {
            if (hashTable[i] >= 0) {
                keys[count] = hashTable[i];
                count += 1;
            }
        }
        TABLE_SIZE = newTableSize;
        hashTable = new int[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            hashTable[i] = EMPTY;
        }
        size = 0;
        garbage = 0;
        for (int i = 0; i < count; i++) {
            insert(keys[i]);
        }
    }

    public int search(int key) { // complete this method
        int hashValue = getHashValue(key);
        for (int i = 0; i < TABLE_SIZE; i++) {
            if (hashTable[hashValue] == key) {
                return hashValue;
            }
            if (hashTable[hashValue] == EMPTY) {
                return -1;
            }
            hashValue++;
            if (hashValue == TABLE_SIZE) {
                hashValue = 0;  
            }
        }
        return -1;
    }

    public int insert(int val) { // complete this method
        if (size + garbage ==  TABLE_SIZE) {
            resize(2 * size);
        }
        int hashValue = getHashValue(val);
        for (int i = 0; i < TABLE_SIZE; i++) {
            if (hashTable[hashValue] == val) {
                return -1;
            }
            if (hashTable[hashValue] == EMPTY) {
                break;
            }
            hashValue++;
            if (hashValue == TABLE_SIZE) {
                hashValue = 0;
            }
        }
        hashTable[hashValue] = val;
        size++;
        return hashValue;
    }

    public int remove(int val) { // complete this method
        int index = search(val);
        if (index < 0) {
            return -1;
        }
        hashTable[index] = TOMBSTONE;
        garbage++;
        size--;
        return index;
    }
}
