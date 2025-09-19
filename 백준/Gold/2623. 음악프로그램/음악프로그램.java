
import java.util.*;
import java.io.*;


public class Main {
	/*
	 * 위상정렬
	 * - 노두 개수 N만큼 방문하기 전에 큐가 비면 사이클 발생한것임
	 * - 진입차수 0인거 큐에 넣고 하나ㅣㅆㄱ 방문하면서 연결된점도 0되면 넣기
	 * - 순서: 큐에서 꺼낸 순서
	 * 
	 * 
	 * */
	

	static int N, M;
	static int[] prevDeg;
	static List<Integer>[] nextSinger;
	static int[] answer;

	public static void main(String args[]) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		prevDeg = new int[N];
		nextSinger = new List[N];
		answer = new int[N];
		
		for(int i=0; i<N; i++) {
			nextSinger[i] = new ArrayList<>();
		}
		
		// 초기화
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			int prevNum = Integer.parseInt(st.nextToken()) - 1;
			for(int j=1; j<cnt; j++) {
				int nextNum = Integer.parseInt(st.nextToken()) - 1;
				nextSinger[prevNum].add(nextNum);
				prevDeg[nextNum]++;
				prevNum = nextNum;
			}
		}
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		
		for(int i=0; i<N; i++) {
			if(prevDeg[i] == 0) q.add(i);
			
			
		}
		
		// N번반복전에 q가비면 사이클있따...
		int cnt=0;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			answer[cnt] = now;
			cnt++;
			for(int next : nextSinger[now]) {
				prevDeg[next]--;
				if(prevDeg[next] == 0) {
					q.add(next);
				}
			}
		}
		
		if(cnt<N) {
			System.out.println(0);
			return;
		}
		
		
		for(int i : answer) {
			System.out.println(i+1);
		}
		
		
		
	}
	
	
	
}

