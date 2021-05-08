import java.util.HashSet;
import java.util.Set;

public class NotRepeatedSubstring {
    public static void main(String[] args){
        String a = "ababcderf";
        String b = "ababcabababa";
        System.out.println(lengthOfLongestSubstring(b));
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> record = new HashSet<Character>();
        int n = s.length();
        int rk = -1, ans = 0;
        for(int i = 0; i < n; ++i){
            if(i != 0){
                record.remove(s.charAt(i-1));
            }
            while(rk + 1 < n && !record.contains(s.charAt(rk +1))) {
                record.add(s.charAt(rk+1));
                ++rk;
            }

            ans = Math.max(ans, rk-i+1);
        }
        return ans;
    }
}
