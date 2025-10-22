
import java.io.*;
import java.util.*;

public class Main {
	/* 
	 * 
	 * 마을 N개당 1명학생
	 * !!!!!!!단방향 도로 M개있음 왔다가야함
	 * 각 마을에서 X마을까지 최단거리가 제일 큰 학생?
	 * 못가는경우는없음
	 * 
	 * ====================
	 * 고려할점
	 * ====================
	 * 1.우선순위큐 다익스트라: O(M log N)
	 * 2. 단방향노드라서 X로부터 모든 점 뿐 아니라, 모든점으로부터 X도 구해야함
	 * -> 모든점을 시작으로 한번씩 다익스트라돌리면 시간초과남
	 * Sol) 그래프엣지를 뒤집기
	 * 
	 * +).. 같이보면좋을듯문제
	 * https://school.programmers.co.kr/learn/courses/30/lessons/118669
	 * -> 멀티소스다익스트라(어디서출발하든그냥 도착만하면돼서 시작점에 여러개놓고돌림)
	 * */

	static int N, M, X;
	static int[] minDist1;
	static int[] minDist2;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		// 각 도시를 시작점으로
		List<int[]>[] edge = new List[N+1];
		List<int[]>[] reversedEdge = new List[N+1];
		minDist1 = new int[N+1];
		minDist2 = new int[N+1];
		Arrays.fill(minDist1, Integer.MAX_VALUE);
		Arrays.fill(minDist2, Integer.MAX_VALUE);

		for(int i=0; i<=N; i++) {
			edge[i] = new ArrayList<>();
			reversedEdge[i] = new ArrayList<>();
			
		}
		
		// 도로 입력
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			edge[s].add(new int[] {e,t});
			reversedEdge[e].add(new int[] {s,t});
		}
		
		// 시간짧순정렬
		PriorityQueue<int[]> pq = new PriorityQueue<>(
				(a,b) -> (a[1] - b[1])
				);
		
		pq.add(new int[] {X, 0});
		minDist1[X] = 0;
		
		
		// 1. X에서 각 점으로 가는 경우의수 세기
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			
			
			// 이미최적화시
			if(now[1] > minDist1[now[0]]) {
				continue;
			}
			
			for(int[] next : edge[now[0]]) {
				
				// now를 거쳐서 next로가는게 빠르면 업데이트
				if((next[1] + minDist1[now[0]]) < minDist1[next[0]]) {
					minDist1[next[0]] = next[1] + minDist1[now[0]];
					pq.add(new int[] {next[0], minDist1[next[0]]});
				}

			}
		}
		
		pq.add(new int[] {X, 0});
		minDist2[X] = 0;
		
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			
			
			// 이미최적화시
			if(now[1] > minDist2[now[0]]) {
				continue;
			}
			
			for(int[] next : reversedEdge[now[0]]) {
				
				// now를 거쳐서 next로가는게 빠르면 업데이트
				if((next[1] + minDist2[now[0]]) < minDist2[next[0]]) {
					minDist2[next[0]] = next[1] + minDist2[now[0]];
					pq.add(new int[] {next[0], minDist2[next[0]]});
				}

			}
		}
		
		
		
		int max = 0;
		for(int i=1; i<=N; i++) {
			if(max < minDist1[i]+minDist2[i])
				max = minDist1[i]+minDist2[i];
		}
		
		System.out.println(max);
		
		
	}
	
	
	
	
	
	
	
	
	
}
