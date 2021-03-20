public class LongestPalindrome {
    public static void main(String[] args){
        String a = "frankfrankababababab";
        System.out.println(longestPalindrome(a));

    }

    // using dynamic programming solve longest palindrome
    public static String longestPalindrome(String s){
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for(int len = 0; len < n; len++){
            for(int i = 0; i + len < n; i++){
                int j = i+len;
                // when there is only one char
                if(len == 0){
                    dp[i][j] = true;
                    // when there are two char
                } else if(len == 1){
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                    // check if the substring can extend
                } else {
                    dp[i][j] = ((s.charAt(i) == s.charAt(j)) && dp[i+1][j-1]);
                }

                if(dp[i][j] && (len + 1 > ans.length())){
                    ans = s.substring(i, i+len+1);
                }
            }
        }
        return ans;

    }

    // try expanding the substring from a selected center
    public static String longestPalindrome2(String s){
        if(s == null || s.length() < 1){
            return "";
        }
        int start = 0;
        int end = 0;
        for(int i = 0; i < s.length(); i++){

        }
    }

    public int expandAroundCenter(String s, int left, int right){
        while(left >= 0 && right <= s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left -1;
    }

}
