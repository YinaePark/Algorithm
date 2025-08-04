
import java.util.*;
import java.io.*;


public class Main {
	/*
	 * dp[i] = i일부터 N일까지 얻을 수 있는 최대 수익
	 * dp[i] = max(
	 *   p[i] + dp[i + t[i]],  // i일 상담을 하는 경우
	 *  dp[i + 1]             // i일 상담을 안 하는 경우
	 *	)
	 * */
	
	public static int[] dp;
	public static int[] T;
	public static int[] P;
	
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		T = new int[n+2];
		P = new int[n+2];
		dp = new int[n+2];
		
		for(int test_case = 1; test_case<=n; test_case++) {
			T[test_case] = sc.nextInt();
			P[test_case] = sc.nextInt();
		}
		
		for (int i = n; i >= 1; i--) {
			if (i + T[i] - 1 <= n) {
				dp[i] = Math.max(P[i] + dp[i + T[i]], dp[i + 1]);
			} else {
				dp[i] = dp[i + 1];
			}
		}

		
		System.out.println(dp[1]);
	   
	}
	
}
