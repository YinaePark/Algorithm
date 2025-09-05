

import java.util.*;
import java.io.*;


public class Main {
	/*
	 * bfs 시 visited 필요
	 * */
	static int T;
	static int[] arr;
	static boolean[] visited = new boolean[10000];
	static int[] prevNum = new int[10000];
	static char[] prevCmd = new char[10000];
	
	public static void main(String args[]) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		for(int test_case=0; test_case<T; test_case++) {
			visited = new boolean[10000];
			
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			ArrayDeque<Integer> q = new ArrayDeque<>();
			q.add(A);
			
			while(!q.isEmpty()) {
				
				int now = q.poll();
				// 종료
				if(now == B) {
					StringBuilder sb = new StringBuilder();
					while(B != A) {
						sb.append(prevCmd[B]);
						B = prevNum[B];
					}
					sb.reverse();
					System.out.println(sb.toString());
					break;
				}
				
				// 반복
				for(int i=0; i<4; i++) {
					int next = DSLR(now, i);
					if(visited[next]) continue;
					
					visited[next] = true;
					prevNum[next] = now;
					
					switch(i) {
					case 0:
						prevCmd[next] = 'D';
						break;
					case 1:
						prevCmd[next] = 'S';
						break;
					case 2:
						prevCmd[next] = 'L';
						break;
					case 3:
						prevCmd[next] = 'R';
						break;
					}
					q.add(next);
					
				}
			}
		}
		
	}
	
	
	/*
	 *DSLR
	 * */
	static int DSLR(int n, int command) {
		
		switch(command) {
		case 0: 
			return (2*n)%10000;
		case 1:
			return (n+9999)%10000;
		case 2:
			return (n%1000)*10 + n/1000;
		case 3:
			return (n%10)*1000 + (n/10);
		}
		
		
		return -1;
	}
	
	
}
