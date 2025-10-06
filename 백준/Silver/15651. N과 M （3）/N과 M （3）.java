
import java.io.*;
import java.util.*;

public class Main {
	/* 
	 * N=20 > 백트래킹..
	 * */
	
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] answer = new int[M];

		backtracking(0, M, answer);
		System.out.println(sb.toString());
		
	} 
	
	// 순열x 조합구하기
	static void backtracking(int depth, int goal, int[] answer) {
		if(depth == goal) {
			for(int i : answer) {
				sb.append(i);
				sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(depth == N) break;
			answer[depth] = i; 
			backtracking(depth+1, goal, answer);

		}
	}
	
	
}
