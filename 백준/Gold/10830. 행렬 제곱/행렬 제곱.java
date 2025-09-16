
import java.util.*;
import java.io.*;


public class Main {
	/*
	 * 분할정복 
	 * - %1,000
	 * 
	 * 실수한부분:
	 * - arr * arr2해야되는데 arr1*arr1
	 * - 원소 <= 1000이라서 1000 인경우 나눠줘야함
	 * - 원래 재귀식으로 mult를 호출햇 ㅓ여러번계산 + 홀수일 때 depth=1만 곱해준게아니라 홀*짝으로 호추함
	 * */
	
	static int N;
	static long B;
	static int[][] arr;


	public static void main(String args[]) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());
		
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int[][] answer = dnc(B);
		
		testPrint(answer);
		
				
		
	}
	
	static int[][] dnc(long depth) {
		if(depth == 1) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] %= 1000;
					
				}
			}
			return arr;
		}
		
		int[][] divided = dnc(depth/2);
		int[][] result = mult(divided, divided);
		if(depth%2 == 0) return result;
		return mult(result, arr);
		
		
		
		
	}
	static int[][] mult(int[][] arr1, int[][] arr2) {
		int[][] result = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int a=0; a<N; a++) {
					result[i][j] += arr1[i][a] * arr2[a][j];
				}
				result[i][j] %= 1000;
				
			}
		}
		
		return result;
		
	}

	
	static void testPrint(int[][] A) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
	}
}

