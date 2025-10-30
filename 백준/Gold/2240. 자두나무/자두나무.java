
import java.io.*;
import java.util.*;

public class Main {
	/* 
	 * w번만 움직여서 받아내기
	 * 
	 * dp[i][w] = 순간 i에 w번 움직였을때 (2 - w%2)에 있을 떄 받을수있는 최대자두개수
	 * dp[i][w] = mAX(dp[i-1][w] , dp[i-1][w+1] ) + hit
	 * 
	 * */
	

	static int T, W;
	static int[] arr;
	static int[][] dp;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        arr = new int[T+1];
        dp = new int[T+1][W+1];
        
        for(int i=1; i<=T; i++) {
        	st = new StringTokenizer(br.readLine());
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=1; i<=W; i++) {
        	dp[0][i] = -1;
        }
        
        dp[0][0] = 0;
        
        for(int i=1; i<=T; i++) {
        	for(int w=0; w<=Math.min(W, i); w++) {
        		
        		int n1 = dp[i-1][w];
        		int n2 = w>0 ? dp[i-1][w-1] : -1;
        		
        		dp[i][w] = Math.max(n1, n2) + (arr[i] == 1+w%2 ? 1 : 0);
        	}
        }
        
        
        int max = 0;
        for(int i=0; i<=W; i++) {
        	if(dp[T][i] > max)
        		max = dp[T][i];
        }
        System.out.println(max);
    }
    

    

}

