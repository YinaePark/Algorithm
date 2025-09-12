
import java.util.*;
import java.io.*;


public class Main {
	/*
	 * 특이사항
	 * 위상정렬 & dp 두개 다 풀 수 있둠
	 * 
	 * 위상정렬 :
	 * 1. 진입차수=0인 정점 모두 q에 삽입
	 * 2. q.poll 후 연결된 간선 제거
	 * 3. 간선 제거 후 진입차수 0된 정점을 q 삽입
	 * 
	 * result = 각각 작업 시간으로 초기화
	 * 		  = 바로전단계 선행작업들 여러개중 가장 오래걸리는 것 시간반영
	 * result[next] = max(result[next], result[now] + time[next])
	 * 
	 * ---
	 * List<Integer>[] 초기화 : 
	 * prevJobs = new List[N];
	 * Arrays.setAll(prevJobs, i -> new ArrayList<>());
	 * 
	 * */
	
	static int N;
	static int answer = 0;
	static int[] prevJobCnt;
	// 이전작업 저장 prevJobs[i] = List<>
	static List<Integer>[] nextJobs;
	static int[] time;
	static int[] finishTime;
	
	public static void main(String args[]) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		prevJobCnt = new int[N+1];
		nextJobs = new List[N+1];
		time = new int[N+1];
		finishTime = new int[N+1];
		for(int i=0; i<=N; i++) {
			nextJobs[i] = new ArrayList<>();
		}
		
		for(int i=1; i<=N; i++) {
			// 작업에 걸리는 시간
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			for(int k=0; k<cnt; k++) {
				int job = Integer.parseInt(st.nextToken());
				prevJobCnt[i]++;
				nextJobs[job].add(i);
			}
		}
		ArrayDeque<Integer> q = new ArrayDeque<>();

		for(int i=1; i<=N; i++) {
			if(prevJobCnt[i] == 0) {
				q.add(i);
			}
			finishTime[i] = time[i];
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int next : nextJobs[now]) {
				finishTime[next] = Math.max(finishTime[next], finishTime[now] + time[next]);
				prevJobCnt[next]--;
				if(prevJobCnt[next] == 0) {
					q.add(next);
				}
			}
			
		}
		
		for(int i=1; i<=N; i++) {
			if(finishTime[i] > answer) answer = finishTime[i];
		}
		System.out.println(answer);
		
		
	}
	
	
	
}

