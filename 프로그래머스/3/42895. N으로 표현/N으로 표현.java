import java.util.*;

class Solution {
    public int solution(int N, int number) {
        Set<Integer>[] dp = new Set[9];
        for (int i = 1; i <= 8; i++) {
            dp[i] = new HashSet<>();
        }
        
        // 연속된 N으로 만든 수 (5, 55, 555, ...)
        int continuous = N;
        for (int i = 1; i <= 8; i++) {
            dp[i].add(continuous);
            if (continuous == number) return i;
            continuous = continuous * 10 + N;
        }
        
// DP 계산
        for (int i = 2; i <= 8; i++) {
            for (int j = 1; j < i; j++) {
                for (int a : dp[j]) {
                    for (int b : dp[i-j]) {
                        dp[i].add(a + b);
                        dp[i].add(a - b);
                        dp[i].add(b - a);
                        dp[i].add(a * b);
                        if (b != 0) dp[i].add(a / b);
                        if (a != 0) dp[i].add(b / a);
                    }
                }
            }
            if (dp[i].contains(number)) return i;
        }
        return -1;
        }
        
    
}