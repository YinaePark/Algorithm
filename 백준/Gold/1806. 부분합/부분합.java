
import java.util.*;
import java.io.*;


public class Main {
	/*
	 * 투포인터 
	 * */
	
	static int N, S;
	static int[] num;
	
	
	public static void main(String args[]) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int l = 0;
		int r = 1;
		int sum = num[0];
		int minLen = Integer.MAX_VALUE;
		
		// S<=sum인지를 먼저 검사해야하는이유 : 
		// 조건만족해도 더 줄일수있는지 확인해야됨
		while(true) {
			
			if(sum>=S) {
				if((r-l) < minLen) minLen = (r-l);
				sum -= num[l];
				l++;
				continue;
				
			}
			if(r>=N) break;
			
			sum += num[r];
			r++;
			
			
		}
		System.out.println(minLen == Integer.MAX_VALUE ? 0 : minLen);
		
		
	}
	
	
	
}

