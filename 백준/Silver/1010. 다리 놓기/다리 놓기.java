
import java.util.*;
import java.io.*;


public class Main {

	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		int N, M, T;
		T=sc.nextInt();
		for(int i=0; i<T; i++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			long result = combination(M,N);
			System.out.println(result);
		}
		
		
		
	}
	
	// 팩토리얼 구하기
	public static long combination(int m, int n) {
		// n이 더 작은거
		if(n>m-n) n = m-n;
		long result =1;
		for(int i=1; i<=n; i++) {
			result = result * (m-i+1) / i;
			
		}
//		System.out.println("===== i: " + n + " : result.. " + result);
		return result;
	}
	
}
