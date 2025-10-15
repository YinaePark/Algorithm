
import java.io.*;
import java.util.*;

public class Main {
	/* 
	 * n<=10,000
	 * 백트래킹쓰면 시간초과남
	 * dp(동전유형)
	 * */

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		
		int[] nums = new int[T];
		int max = -1;
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			nums[i] = Integer.parseInt(st.nextToken());	
			if(max < nums[i]) max = nums[i];
		}
		int[] dp = new int[max+1];
		dp[0] = 1;
		
		// 코인 3가지에 대해, 각각을 사용하는 방법으로 dp 찾기
		for(int coin=1; coin<=3; coin++) {
			for(int i=coin; i<=max; i++) {
				dp[i] += dp[i-coin];
			}
		}
		
		
		for(int num : nums) {
			sb.append(dp[num] + "\n");
		}
		
		
		
		System.out.println(sb.toString());
		
	} 
	
	
	

}
