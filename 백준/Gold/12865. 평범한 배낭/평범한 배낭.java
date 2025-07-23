
import java.util.*;
import java.io.*;


public class Main {
	
	static int n, k;
	static int[] dp;
	static int[] w;
	static int[] v;
	
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		w = new int[n];
		v = new int[n];
		dp = new int[k+1];
		
		for(int n_number = 0; n_number<n; n_number++) {
			w[n_number] = sc.nextInt();
			v[n_number] = sc.nextInt();
			
		}
		
		// bottom up
		// i: 물건번호
		// j : 현재 배낭의 남은용량
		// dp[w] : 무게 w 이하로 담을 수 있는 물건들의 최대 가치
		for(int i=0; i<n; i++) {
			// 
			for(int j=k; j >= w[i]; j--) {
				dp[j] = Math.max(dp[j] , dp[j-w[i]] + v[i]);
			}
		}
		
		System.out.println(dp[k]);
		

	}
	
	
}
