
import java.util.*;
import java.io.*;


public class Main {
	

	static int n;
	static int[] dp;
	
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		dp = new int[n+1];
		dp[0] = 0;
		
		if(n<2) {
			System.out.println(n);
			return;
		}
		dp[1] = 1;
		dp[2] = 2;
		
		
		for(int i=3; i<=n; i++) {
			dp[i] = ((dp[i-1] % 10007) + (dp[i-2] % 10007)) % 10007;
		}
        System.out.println(dp[n]% 10007);
		

	}
	
	
}
