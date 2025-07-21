class Solution {
    public int solution(int m, int n, int[][] puddles) {
        // m: 가로
        // n: 세로
        int[][] dp = new int[n+1][m+1];
        
        // dp[][] = 위, 왼쪽
        dp[1][0] = 1;
        
        for(int i=0; i<puddles.length; i++){
            dp[puddles[i][1]][puddles[i][0]] = -1;
        }
        
        
        
        // 세로
        for(int i=1; i<n+1; i++){
            // 가로
            for(int j=1; j<m+1; j++){
                
                if(dp[i][j] == -1 ){
                    //System.out.print(dp[i][j] + " ");
                    continue;
                } 
                
                dp[i][j] = (Math.max(dp[i-1][j], 0) + Math.max(dp[i][j-1], 0))%1000000007;
                //System.out.print(dp[i][j] + " ");
            }
            //System.out.println();
        }
        
        
        
        return dp[n][m];
    }
}