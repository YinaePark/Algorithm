
import java.util.*;
import java.io.*;


public class Main {
	
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		int N;
		int[] arr;
		int[] dp;
		
		N = sc.nextInt();
		dp = new int[N+1];
		arr = new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// dp[i] =
		// dp[i+1] = dp[1~i] 중 가장큰값 + 1
		
		Arrays.fill(dp, 1);
		for(int i=2; i<=N; i++) {
			for(int j=1; j<i; j++) {
				// dp 최댓값 갱신
				if((arr[j] < arr[i]) && (dp[j]+1 > dp[i])) {
					dp[i] = dp[j]+1;
				}
			}
			
		}
		
		int result = 1;
		for(int i=1; i<=N; i++) {
			if(result < dp[i]) result = dp[i];
		}
		
		
		
        System.out.println(result);
		
	}
	
}
