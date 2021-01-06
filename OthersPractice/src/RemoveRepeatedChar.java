import java.util.Arrays;
import java.util.Scanner;
import java.util.HashSet;
public class RemoveRepeatedChar {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        HashSet<Character> res = new HashSet<>();
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (!res.contains(aChar)) {
                System.out.print(aChar);
                res.add(aChar);
            }

        }

    }
}
