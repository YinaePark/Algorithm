
import java.util.*;
import java.io.*;


public class Main {
	
	// 0 이하거나 20 이상이면 어차피 연산필요x
	public static int[][][] dp = new int[21][21][21];
	
	public static void main(String args[]) throws Exception{
		
	   for (int i = 0; i < 21; i++) {
	        for (int j = 0; j < 21; j++) {
	            Arrays.fill(dp[i][j], Integer.MAX_VALUE);
	        }
	    }		
		dp[0][0][0] = 1;
		
		for(int i=0; i<=20; i++) {
			for(int j=0; j<=20; j++) {
				dp[0][i][j] = 1;
				dp[i][0][j] = 1;
				dp[i][j][0] = 1;
			}
		}
		
		Scanner sc = new Scanner(System.in);
		 while(true) {
	            int a = sc.nextInt();
	            int b = sc.nextInt();
	            int c = sc.nextInt();
	            
	            if(a == -1 && b == -1 && c == -1) {
	                break;
	            }
	            
	            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c));
	        }
	}
	
	public static int w(int a, int b, int c) {
		if(a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
		if(a > 20 || b > 20 || c > 20) {
			if(dp[20][20][20] == Integer.MAX_VALUE) {
				dp[20][20][20] = w(20, 20, 20);
			}
			return dp[20][20][20];
		}
		if(a < b && b < c) {
			if(dp[a][b][c-1] == Integer.MAX_VALUE) {
				w(a,b,c-1);
			}
			if(dp[a][b-1][c-1] == Integer.MAX_VALUE) {
				w(a,b-1,c-1);
			}
			if(dp[a][b-1][c] == Integer.MAX_VALUE) {
				w(a, b-1, c);
			}
			dp[a][b][c] = dp[a][b][c-1] + dp[a][b-1][c-1] - dp[a][b-1][c];
			return dp[a][b][c];
		}
		if(dp[a-1][b][c] == Integer.MAX_VALUE) {
			w(a-1, b, c);
		}
		if(dp[a-1][b-1][c] == Integer.MAX_VALUE) {
			 w(a-1, b-1, c);
		}
		if(dp[a-1][b][c-1] == Integer.MAX_VALUE) {
			w(a-1, b, c-1);
		}
		if(dp[a-1][b-1][c-1] == Integer.MAX_VALUE) {
			w(a-1, b-1, c-1);
		}
		dp[a][b][c] = dp[a-1][b][c] + dp[a-1][b-1][c] + dp[a-1][b][c-1] - dp[a-1][b-1][c-1];
		return dp[a][b][c];
	}
	
	
}
