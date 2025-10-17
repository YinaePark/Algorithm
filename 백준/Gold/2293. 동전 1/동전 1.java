
import java.io.*;
import java.util.*;

public class Main {
	/* 
	 * dp[k] = k원이 되도록하는 경우의수 
	 * 
	 * */

	static int N, K;
	static int[] value;
	static long[] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		value = new int[N];
		dp = new long[K+1];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			value[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(value);
		
		dp[0] = 1;
		// value[i] = 동전의 종류
		for(int coin : value) {
			// 모든 동전 종류에 대해, i 만들 수 있는 경우의 수 찾기
			for(int j=coin; j<K+1; j++) {
				
				dp[j] += dp[j-coin];
				
			}
		}
		
		
		System.out.println(dp[K]);
	}
}
