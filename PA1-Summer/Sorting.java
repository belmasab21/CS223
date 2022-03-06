public class Sorting {
  
    
    public static void selectionSort(int[] array, int arrayLen) {   
       for (int i = 0; i < arrayLen - 1; i++) {
         int min_index = i;
         for (int j = i+1; j < arrayLen; j++) {
             if (array[j] < array[min_index]) {
             min_index = j;    
                }
            }
            int temp = array[min_index];
            array[min_index] = array[i];
            array[i] = temp;
        }
    }

    public static void insertionSort(int[] array, int arrayLen) { 
        for (int i = 1; i < arrayLen; i++) {
         int key = array[i];
         int j = i - 1;
           while (j >= 0 && array[j] > key) {
           array[j+1] = array[j];
           j = j-1;         
           array[j+1] = key;
         }
      }
    }
}
