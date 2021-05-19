import java.util.ArrayList;
import java.util.List;

public class RecoverIPAddress {
    static final int SEG_COUNT = 4;
    static List<String> ans = new ArrayList<String>();
    static int[] segments = new int[SEG_COUNT];

    public static void main(String[] args){
        String s = "25511135";
        List<String> list = new ArrayList<String>();
        list = recoverIPAddress(s);
        System.out.println(list);

    }

    public static List<String> recoverIPAddress(String s){
        segments = new int[SEG_COUNT];
        dfs(s,0,0);
        return ans;
    }

    private static void dfs(String s, int segId, int segStart) {
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuffer ipAddr = new StringBuffer();
                for (int i = 0; i < SEG_COUNT; ++i) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append('.');
                    }
                }
                ans.add(ipAddr.toString());
            }
            return;
        }
        if (segStart == s.length()) {
            return;
        }
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }
        // normally, get every possible result and repeat;
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 255) {
                segments[segId] = addr;
                dfs(s, segId + 1, segEnd+1);
            } else {
                break;
            }
        }
    }
}
