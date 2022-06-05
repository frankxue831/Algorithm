public class SwapClient {

    // 方法一: 利用临时数tmp
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    // 方法二: 利用加减运算
    public static void swapCal(int[] arr, int i, int j) {
        if(i == j) return; // 若无法保证swapCal被调用时满足 i != j，则需有此句，否则i == j时此数将变为0
        arr[i] = arr[i] + arr[j]; // a = a + b
        arr[j] = arr[i] - arr[j]; // b = a - b
        arr[i] = arr[i] - arr[j]; // a = a - b
    }
    // 方法三: 利用异或运算
    public static void swapXOR(int[] arr, int i, int j) {
        if(i == j) return; // 若无法保证swapXOR被调用时满足 i != j，则需有此句，否则i == j时此数将变为0
        arr[i] = arr[i] ^ arr[j]; // a = a ^ b，也可写成 arr[i] ^= arr[j];
        arr[j] = arr[i] ^ arr[j]; // b = (a ^ b) ^ b = a ^ (b ^ b) = a ^ 0 = a， 也可写成 arr[j] ^= arr[i];
        arr[i] = arr[i] ^ arr[j]; // a = (a ^ b) ^ a = (a ^ a) ^ b = 0 ^ b = b， 也可写成 arr[i] ^= arr[j];
    }

}
