
import java.io.*;
import java.util.*;

public class Main {
	/* 
	 * N=20 > 백트래킹..
	 * */
	
	static int N, S;
	static int[] elems;
	static boolean[] visited;
	static int answer=0;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		elems = new int[N];
		visited = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			elems[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=N; i++) {
			backtracking(0,i,0, 0);
		}
		
		System.out.println(answer);
	} 
	
	// 순열x 조합구하기
	static void backtracking(int depth, int goal, int sum, int now) {
		if(depth == goal) {
			
			if(sum == S) answer++;
			return;
		}
		
		for(int i=now; i<N; i++) {
//			if(depth == N) break;
			if(visited[i]) continue;

			
			visited[i] = true;
			backtracking(depth+1, goal, sum+elems[i], i);
			visited[i] = false;

		}
	}
	
	
}
