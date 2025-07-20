import java.util.*;

class Solution {
    
    public int solution(int[][] triangle) {
        int height = triangle.length;
        int[][] dp = new int[height][height];
        
        dp[0][0] = triangle[0][0];
        
        // dp 채우기
        // i :높이
        for(int i=1; i<height; i++){
            // j=0일떄
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            // j=i일 떄
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
            
            // j :idx
            for(int j=1; j<i; j++){
                // dp[i][j] = max(dp[i-1][j], dp[i-1][j-1]) 
                dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j], dp[i-1][j-1]);
            }
        }
        
        int max = 0;
        for(int num : dp[height-1]){
            if(num > max) max = num;
        }
        
        
        return max;
    }
}