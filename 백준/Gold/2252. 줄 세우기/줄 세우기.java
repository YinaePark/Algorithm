
import java.util.*;
import java.io.*;


public class Main {
	/*
	 * 위상정렬
	 * 1. 진입계수0인거 q에 넣기
	 * 2. 하나씩 빼면서 다음라인 삭제
	 * 3. q에서 poll한 순서가 그순서
	 * 
	 * */
	
	static int N, M;
	static int[] prevStudentCnt;

	static List<Integer>[] nextStudent;
	static List<Integer> answer;
	
	
	public static void main(String args[]) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		prevStudentCnt = new int[N+1];
		nextStudent = new List[N+1];
		answer = new ArrayList<>();
		
		for(int i=0; i<N+1; i++) {
			nextStudent[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s1 = Integer.parseInt(st.nextToken());
			int s2 = Integer.parseInt(st.nextToken());
			
			prevStudentCnt[s2]++;
			nextStudent[s1].add(s2);
		}
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		
		for(int i=1; i<=N; i++) {
			if(prevStudentCnt[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			answer.add(now);
			
			for(int next : nextStudent[now]) {
				prevStudentCnt[next]--;
				if(prevStudentCnt[next] == 0) {
					q.add(next);
				}
			}
			
		}
		
		for(int i : answer) {
			System.out.print(i + " ");

		}
		
		
	}
	
	
	
}

