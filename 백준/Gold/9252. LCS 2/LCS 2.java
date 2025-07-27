
import java.util.*;
import java.io.*;


public class Main {
	
	public static int[][] dp;
	
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		
		int len1 = str1.length();
		int len2 = str2.length();

		dp = new int[len1+1][len2+1];
		dp[0][0] = 0;
		dp[0][1] = 0;
		dp[1][0] = 0;
		
		// 먼저 LCS 길이 구하기
		for(int i=1; i<=len1; i++) {
			for(int j=1; j<=len2; j++) {
				// 같으면..
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
					//System.out.print(dp[i][j] + " ");
					continue;
				}
				
				// 같지 않으면..
				dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
				
				// System.out.print(dp[i][j] + " ");
				
			}
			// System.out.println();
		}
		
		// dp[len1][len2] = LCS의 길이
		// 역추적을 통해 글자 구하기
		int lcs = dp[len1][len2];
		System.out.println(lcs);
		// 글자 없으면 종료
		if(lcs == 0) {
			return;
		}
		
		int tmp1 = len1;
		int tmp2 = len2;
		StringBuilder sb = new StringBuilder();
		
		while(lcs > 0) {
			// 같으면 대각선위
			if(str1.charAt(tmp1-1) == str2.charAt(tmp2-1)) {
				sb.append(str1.charAt(tmp1-1));
				lcs--;
				tmp1--;
				tmp2--;
				continue;
			}
			
			// 다르면 큰쪽으로 이동
			if(dp[tmp1-1][tmp2] > dp[tmp1][tmp2-1]) {
				tmp1--;
				continue;
			}
			tmp2--;
		}
		
		System.out.println(sb.reverse());
				
				
	   
	}
	
	
	
	
}
