import java.util.Arrays;

/**
 * Sort the array with data structure type heap
 * max heap: parent node is larger than children node
 * save tree as an array:
 * parent node k;
 * left child node: 2*k+1; right child node : 2*k+2
 */
public class HeapSort {
    public static void main(String[] args){
        int[] arr = {4, 61, 82, 55, 89};
        HeapSort.heapSort(arr);

    }

    /**
     * sort the arr with heap
     * @param arr the array need to be sorted
     */
    public static void heapSort(int[] arr){
        int temp = 0;
        System.out.println("Heap sort: ");

        for(int i = arr.length/2 -1; i >=0; i--){
            adjustHeap(arr, i, arr.length);
        }
        System.out.println("max heap is: " + Arrays.toString(arr));

        for(int j = arr.length-1; j>0; j--){
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
            System.out.println("****array is: " + Arrays.toString(arr));

        }

        System.out.println("array is: " + Arrays.toString(arr));
    }

    /**
     * adjust the tree to a max heap. for example:
     * int[] arr = {4, 61, 82, 55, 89}; let i = 1
     * adjust heap => {4, 89, 83, 55, 61}; again i = 0
     * adjust heap => {89, 61, 83, 55, 4}
     * @param arr the array need to be adjust to heap
     * @param i the array index of non-leaf node
     * @param length the number of adjusted element, which is decreasing
     */
    public static void adjustHeap(int[] arr, int i, int length){

        int temp = arr[i]; // save the current node

        for(int k = i*2+1; k < length; k = k*2+1){
            if(k+1 < length && arr[k] < arr[k+1]){ //check if left node is smaller than right
                k++; // set pointer to the right node
            }
            if(arr[k] > temp){ // check if child is larger than parent
                arr[i] = arr[k];
                i = k; // set i to k, continue the loop
            } else{
                break;
            }
        }
        // when the for loop is done, the subtree arr[i] become max heap
        arr[i] = temp;
    }
}
