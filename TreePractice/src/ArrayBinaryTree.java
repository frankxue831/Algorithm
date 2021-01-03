/**
 * Store array information by binary tree
 */
public class ArrayBinaryTree {
    public int[] arr;

    public ArrayBinaryTree(int[] arr){
        this.arr = arr;
    }


    public void preOrder(){
        this.preOrder(0);
    }

    /**
     * this method to store the array with preOrder
     * @param index the array index
     */
    public void preOrder(int index){
        //if the array is null or array length is 0
        if(arr == null || arr.length == 0){
            System.out.println(" empty array, no tree exits");
        }

        System.out.println(arr[index]);

        if((index * 2 + 1) < arr.length){
            preOrder(2 * index + 1);

        }

        if((index * 2 + 2) < arr.length){
            preOrder(2 * index + 2);
        }

    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,0};
        int[] arr2 = {1,2,3,4,5,6,7};
        ArrayBinaryTree tree1 = new ArrayBinaryTree(arr2);
        tree1.preOrder(0);
        tree1.preOrder();
    }
}
