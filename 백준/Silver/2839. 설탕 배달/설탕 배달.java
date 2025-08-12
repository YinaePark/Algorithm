
import java.util.*;
import java.io.*;


public class Main {
	
	/*
	 * dp[i] : 무게 i까지의 최소봉지개수
	 * 
	 * dp[i] = Min(dp[i-3]+1, dp[i-5]+1
	 * */
	
	public static void main(String args[]) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] dp = new int[5001];
		Arrays.fill(dp, -1);
		
		dp[3] = dp[5] = 1;
		
		for(int i=6; i<=N; i++) {
			if(dp[i-3] == -1 && dp[i-5] == -1) {
				continue;
			}
			if(dp[i-3] == -1) {
				dp[i] = dp[i-5]+1;
				continue;
			}
			if(dp[i-5] == -1) {
				dp[i] = dp[i-3]+1;
				continue;
			}
			dp[i] = Math.min(dp[i-3]+1, dp[i-5]+1);
			
		}
		
		
		
		System.out.println(dp[N]);
	}
}
