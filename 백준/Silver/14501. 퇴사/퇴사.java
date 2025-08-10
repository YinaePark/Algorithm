
import java.util.*;
import java.io.*;


public class Main {
	
	/*
	 * 
	 * dp[i] = 1~i일에 받을수있는 최대이익, dp[0]=0
	 * 
	 * i일자 상담을 할수도있고 안할수도있음
	 * dp[i] = Max(dp[i+1], dp[i+T[i]] + P[i])
	 * 			
	 * 
	 * */
	
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] dp = new int[N+10];
		int[] T = new int[N+1];
		int[] P = new int[N+1];
		
		for(int i=1; i<N+1; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		for(int i=N; i>=1; i--) {
			// 만약 상담하는데 걸리는 기간이 너무 길다면 상담 불가
			if(i + T[i] - 1 > N) {
				dp[i] = dp[i+1];
				continue;
			}
			
		
			dp[i] = Math.max(dp[i+1], dp[i+T[i]] + P[i]);
		}
		
		int max = 0;
		for(int i : dp) {
			if(max < i) max = i;
			//System.out.print(i + " ");
		}
		System.out.println(max);
	}
}
