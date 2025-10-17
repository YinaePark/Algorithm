
import java.io.*;
import java.util.*;

public class Main {
	/* 
	 * N<=8 : bt로 계란 깰 순서 찾기
	 * 
	 * 틀린이유: 
	 * 1. broken == N일떄의 조건을 맨앞에둬서 
	 * 2. 오른쪽 할때 for문돌리지말고 그냥 now+1 출력이나을듯
	 * 3. bt(now, broken)에서 현재 손에 든 계란으로 칠 수 있는 다른 계란이 하나도 없을 때 처리안함
	 * 
	 * 
	 * */

	static int N;
	static int maxbroken = 0;
	static boolean[] visited;
	static int[] W;
	static int[] S;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
				
		visited = new boolean[N];
		W = new int[N];
		S = new int[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			W[i] = Integer.parseInt(st.nextToken());
			
			
		}

		// 첫번째 계란은 가장 왼쪽계란임
		bt(0, 0);
		System.out.println(maxbroken);
	} 
	
	
	// now : 손에있는 계란 , 
	static void bt(int now, int broken) {
		if(broken == N || now == N) {
			if(maxbroken < broken) 
				maxbroken = broken;
			return;
		}
		
		if(visited[now]) {
			bt(now+1, broken);
			return;
		}
		// 지금 든게 깨지지 않았을 경우
		
		boolean hit = false;
		for(int i=0; i<N; i++) {
			if(visited[i] || i==now)
				continue;
			
			hit = true;
			S[i] -= W[now];
			S[now] -= W[i];
			
			int cnt = 0;
			if(S[i] <= 0) {
				visited[i] = true;
				cnt++;
			}
			if(S[now] <= 0) {
				visited[now] = true;
				cnt++;
			}
			
			

			bt(now+1, broken+cnt);
			
			// 복구
			S[i] += W[now];
			S[now] += W[i];
			visited[i] = false;
			visited[now] = false;
			
		}
		
		if(!hit)
			bt(now+1, broken);	
		
		
		
	}

	
	

}
