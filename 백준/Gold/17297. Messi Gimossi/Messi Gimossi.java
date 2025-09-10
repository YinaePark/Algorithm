
import java.util.*;
import java.io.*;


public class Main {
	/*
	 * 
	 * */
	
	static long N, M;
	// 범위
	static long[] length = new long[100];
	
	public static void main(String args[]) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Long.parseLong(st.nextToken());
		
		length[1] = 5;
		length[2] = 13;
		int i=3;
		
	
		// Messi(i) 의 길이들을 length에 저장한다
		while(true) {
			length[i] = length[i-1] + length[i-2] +1;
			if(length[i] > M) break;
			i++;
		}
		
		recursion(i, M);
		
	}
	
	static boolean isEmpty = false;
	
	static void recursion(int N, long idx) {
		// base case
		if(N == 1) {
			System.out.println("Messi".charAt((int)idx - 1));
			return;
		}
		if(N == 2) {
			if(idx==6){
                System.out.println("Messi Messi Gimossi");
            }else {
            	System.out.println("Messi Gimossi".charAt((int)idx - 1));
    			
            }
			return;
			
		}
		
		// messi(i-1), messi(i-2)으로 쪼개고 쪼갠곳에서의 idx를 업데이트해서 새로 재귀호출
		long leftLen = length[N-1];
		
		// messi(i-1)에 있으면
		if(idx <= leftLen) {
			recursion(N-1, idx);
		} // 딱 가운데있으면 공백
		else if(idx == leftLen+1) {
			System.out.println("Messi Messi Gimossi");
		}else {
			recursion(N-2, idx - leftLen - 1);
		}
	}
	
	
}

