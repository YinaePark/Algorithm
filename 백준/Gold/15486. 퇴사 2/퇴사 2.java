
import java.util.*;
import java.io.*;


public class Main {
	/*
	 * dp[i] : i일부터 N일까지의 상담으로 얻을수잇는 max이익
	 * 모든 작업에 대해 반복하면서, 그작업하는거 vs 안하는거 비교
	 * dp[k] = MAX(P[k] + dp[K+T[k]] , dp[K+1])
	 * 
	 * */
	
	static int N;
	static int[] T;
	static int[] P;
	static int[] dp;
	
	
	public static void main(String args[]) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		dp = new int[N+2];
		T = new int[N+2];
		P = new int[N+2];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=N; i>0; i--) {
			// i번작업이 불가능하면그냥 i+1이랑 똑같음
			if((T[i]-1+i) > N) {
				dp[i] = dp[i+1];
				continue;
			} 
			
			// 작업 가능하면, 작업 한 것 vs 안한  것 비교
			dp[i] = Math.max(P[i]+dp[i+T[i]], dp[i+1]);
			
		}
		
		System.out.println(dp[1]);
		
	}
	
	
	
}

