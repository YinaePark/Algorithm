
import java.util.*;
import java.io.*;


public class Main {
	
	/*
	 * 인접하는 집은 다른색깔로 칠해야함!
	 * 집 칠하는 비용의 최솟값 
	 * dp[i][3] = 1~i까지 집 비용의 최솟값
	 * 
	 * dp[1][0] = 집 1을 r로 칠했을떄
	 * dp[1][1] = 집 1을 g로 칠했을떄
	 * dp[1][2] = 집 1을 b로 칠했을때
	 * 
	 * dp[i][c] = Min(dp[i-1][다른 c], dp[i-1][다른 c]) + cost[i][c]
	 * 
	 * */
	
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		// 집 : 1 ~ N
		int n = sc.nextInt();
		int[][] cost = new int[n+1][3];
		int[][] dp = new int[n+1][3];
		
		for(int i=1; i<=n; i++) {
			for(int j=0; j<3; j++) {
				cost[i][j] = sc.nextInt();
			}
		}
		
		dp[1][0] = cost[1][0];
		dp[1][1] = cost[1][1];
		dp[1][2] = cost[1][2];
		
		for(int i=2; i<=n; i++) {
			for(int j=0; j<3; j++) {
				dp[i][j] = Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]) + cost[i][j];
			}
		}
		
		int min = dp[n][0];
		min = min < dp[n][1] ? min : dp[n][1];
		min = min < dp[n][2] ? min : dp[n][2];
		
		System.out.println(min);
	}
}
