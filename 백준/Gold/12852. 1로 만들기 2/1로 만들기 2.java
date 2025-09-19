
import java.util.*;
import java.io.*;


public class Main {
	/*
	 * dp[i] : 1->i만드는데 필요한 최소연산횟수
	 * 반례 : 2and3으로 모두 나누어떨어질떄
	 * 
	 * 
	 * */
	
	static int N;
	static int[] dp;
	static int cnt=0;
	static int[] prevNum;
	
	
	public static void main(String args[]) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		dp = new int[N+1];
		prevNum = new int[N+1];

		
		recursion(N);
		int num = N;
		List<Integer> list = new ArrayList<>();
		while(N!=1) {
			list.add(N);
			N = prevNum[N];
			cnt++;
		}
		
		System.out.println(dp[num]);
		for(int i : list) {
			System.out.print(i + " ");
		}
		System.out.print(1 + " ");
	}
	
	static int recursion(int n) {
		if(n==1) return 0;
		if(dp[n] != 0) return dp[n];
		
		int next;
		
		if(n%6 == 0) {
			int n1 = recursion(n/3);
			int n2 = recursion(n/2);
			
			prevNum[n] = n1<n2 ? n/3 : n/2;
			dp[n] = (n1<n2 ? n1 : n2)+1;
			return dp[n];
		}
		else if(n%3 == 0) {
			int n1 = recursion(n/3);
			int n2 = recursion(n-1);
			
			prevNum[n] = n1<n2 ? n/3 : n-1;
			dp[n] = (n1<n2 ? n1 : n2)+1;
			return dp[n];
		}else if(n%2 == 0) {
			int n1 = recursion(n/2);
			int n2 = recursion(n-1);
			
			prevNum[n] = n1<n2 ? n/2 : n-1;
			dp[n] = (n1<n2 ? n1 : n2)+1;
			return dp[n];
		}
		int n1 = recursion(n-1);
		dp[n] = n1+1;
		prevNum[n] = n-1;
		return dp[n];
		
	}
	
	
	
}

