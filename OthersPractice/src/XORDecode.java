/**
 * Leetcode 1720
 * encoded[i-1] = arr[i-1] ^ arr[i];
 * => encoded[i-1] ^ arr[i-1] = arr[i-1] ^ arr[i] ^ arr[i-1]
 * => encoded[i-1] ^ arr[i-1] = arr[i-1] ^ arr[i-1] ^ arr[i]
 * => encoded[i-1] ^ arr[i-1] = arr[i]
 */
public class XORDecode {
    public static void main(String[] args){

    }

    public static int[] decode(int[] encoded, int first){
         int n = encoded.length + 1;
         int[] arr = new int[n];
         arr[0] = first;
         for(int i = 1; i < n; i++){
             arr[i] = arr[i -1] ^ encoded[i-1];
         }
         return arr;
    }
}
