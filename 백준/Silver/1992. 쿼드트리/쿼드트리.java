
import java.util.*;
import java.io.*;


public class Main {
	/*
	 * 분할정복 
	 * 1 2
	 * 3 4
	 * 
	 * */
	
	static int N;
	static boolean[][] arr;
	StringBuilder sb = new StringBuilder();


	public static void main(String args[]) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		arr = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				if(str.charAt(j) == '1') {
					arr[i][j] = true;
				}
			}
		}
		
		
		
		System.out.println(dnc(N, 0, 0));
		
//		testPrint(arr);
		
				
		
	}
	
	static String dnc(int n, int x, int y){
		boolean start = arr[y][x];
		if(n == 1) {
			return start ? "1" : "0";
		}
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				// 다를 경우 4가지로 분할
				if(arr[y+i][x+j] != start) {
					StringBuilder sb = new StringBuilder();
					int next = n/2;
					String[] strs = new String[4];
					strs[0] = dnc(next, x, y);
					strs[1] = dnc(next, x+next, y);
					strs[2] = dnc(next, x, y+next);
					strs[3] = dnc(next, x+next, y+next);
					
					sb.append("(");
					for(int k=0; k<4; k++) {
						sb.append(strs[k]);
//						if(strs[k].length() > 1) {
//							sb.append("(");
//							sb.append(strs[k]);
//							sb.append(")");
//						}else {
//							sb.append(strs[k]);
//						}
					}
					sb.append(")");
					
					
					return sb.toString();
					
				}
			}
		}
		// 다 같을경우
		return start ? "1" : "0";
		
	}

	
	static void testPrint(boolean[][] A) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print((A[i][j] ? 1 : 0) + " ");
			}
			System.out.println();
		}
	}
}

