import java.util.Scanner;
import java.util.Arrays;
public class ArraySort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()){
            int n = scan.nextInt();
            String [] arr = new String[n];
            for(int i=0;i<n;i++){
                String str = scan.next();
                arr[i] = str;
            }
            Arrays.sort(arr);
            for (String s : arr) {
                System.out.println(s);
            }
        }
        scan.close();
    }
}