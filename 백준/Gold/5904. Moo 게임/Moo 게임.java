
import java.util.*;
import java.io.*;


public class Main {
	/*
	 * 
	 * */
	
	static int N;
	static int[] len;


	public static void main(String args[]) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		len = new int[30];  
        len[0] = 3; 
		
        int k = 0;
        while (len[k] < N) {
            k++;
            len[k] = len[k-1] * 2 + (k + 3);  
        }
		
		
		System.out.println(dnc(N, k));
		
		
				
		
	}
	
	 static char dnc(int n, int k) {
	        if (k == 0) {
	            return n == 1 ? 'm' : 'o';
	        }
	        
	        int prevLen = len[k-1];
	        int midLen = k + 3; 
	        
	        if (n <= prevLen) {
	            // 첫 번째 S(k-1) 구간
	            return dnc(n, k-1);
	        } else if (n <= prevLen + midLen) {
	            // 중간 "moo...o" 구간
	            return n - prevLen == 1 ? 'm' : 'o';
	        } else {
	            // 두 번째 S(k-1) 구간
	            return dnc(n - prevLen - midLen, k-1);
	        }
	    }

	
}

