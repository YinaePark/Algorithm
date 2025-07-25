
import java.util.*;
import java.io.*;


public class Main {
	

	static String str1, str2;
	static int[][] dp;
	static int len1, len2;
	
	public static void main(String args[]) throws Exception{
		// Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str1 = br.readLine();
		str2 = br.readLine();
		
		len1 = str1.length();
		len2 = str2.length();
		
		dp = new int[len1+1][len2+1];
		// LCS(i, j)는...
		// LCS(0,0) = 0
		// x[i] == y[j] 면 LCS(i-1, j-1) + 1
		// x[i] != y[j] 면 MAX(LCS(i, j-1), LCS(i-1, j))
		
		dp[0][0] = 0;
		for(int i=1; i<=len1; i++) {
			for(int j=1; j<=len2; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
					continue;
				}
				dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
			}
		}
		
        System.out.println(dp[len1][len2]);
		

	}
	
	
}
