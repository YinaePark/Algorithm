
import java.util.*;
import java.io.*;


public class Main {
	
	//	dp[i] = i원을 만들수있는 동전의 최소개수
	//	dp[n] = Min(dp[1] + dp[n-1], .... )
	
	static int n, k;
	static int[] dp;
	static int[] price;
	
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		dp = new int[k+1];
		price = new int[n];
		
		for(int n_number = 0; n_number<n; n_number++) {
			price[n_number] = sc.nextInt();
			
		}
		
		Arrays.fill(dp, 100001);
		dp[0] = 0;
		
		// dp[j] : j라는 가격을 만들기위해 필요한 최소동전의 수
		
		// 모둔 동전종류 i에 대해 반복 
		for(int i=0; i<n; i++) {
			// j는 동전 i의 가격으로부터 만들어야하는 가격
			for(int j=price[i]; j<=k; j++) {
				// 만약에 i라는 동전을 추가했을 때 동전 개수가 더 줄어든다면 dp[j] 를 업데이트
				dp[j] = Math.min(dp[j], dp[j-price[i]] + 1);
			}
			
		}

        System.out.println(dp[k] == 100001 ? -1 : dp[k]);
		

	}
	
	
}
