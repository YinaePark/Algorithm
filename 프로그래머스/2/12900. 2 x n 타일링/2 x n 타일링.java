import java.util.*;

class Solution {
    public int solution(int n) {
        
        // n을 1과 2의 합으로 나타내는 경우의 수
        int answer = 0;
        int[] dp = new int[n+1];
        
        if(n==1) return 1;
        if(n==2) return 2;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1_000_000_007;
            //dp[i] = dp[i-1] + dp[i-2]*2 - 1;
            //dp[i] = Math.max(dp[i-1] + 1, dp[i-2] + 2);
        }
        
        
        
        return dp[n];
    }
}