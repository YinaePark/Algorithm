
import java.util.*;
import java.io.*;


public class Main {
	
	/*
	 * N              tScore   P
	 *다음 줄 점수들 개수         랭킹 몇위까지있는지
	 * */
	
	public static void main(String args[]) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int tScore = sc.nextInt();
		int P = sc.nextInt();
		
		long[] score=new long[N];
		int flag=0;
		if(N==0) {
			System.out.println(1);
			return;
		}
		
		for(int i=0; i<N; i++) {
			score[i] = sc.nextInt();	
			
		}
		for(int i=0; i<N; i++) {
			if(score[i]<tScore) {
				System.out.println(i+1);
				return;
			}
			if(score[i]==tScore ) {
				if(P==N) {
					flag=i;
					break;
				}else {
					System.out.println(i+1);
					return;
				}
				
				
			}
			
		}

		if(score[N-1] > tScore) {
			if(N<P) {
				System.out.println(N+1);
				return;
			}
			System.out.println(-1);
			return;
			
		}
		
		if(score[N-1] == score[flag]) {
			System.out.println(-1);
			return;
		}else {
			System.out.println(flag+1);
		}
		
		
	}
}
