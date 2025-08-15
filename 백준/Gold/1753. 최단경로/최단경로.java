
import java.util.*;
import java.io.*;


public class Main {
	/*
	 * 다익스트라:
	 * 한 점으로부터 각 노드까지의 최단거리 구하기
	 * 
	 * PQ 사용 시 : O((v+e)logv)
	 * */

	
	public static void main(String args[]) throws Exception{
		
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		
		// adjList[출발노드] = int[] {도착노드, cost}
		List<List<int[]>> adjList = new ArrayList<>();
		for(int i=0; i<=V; i++) {
			adjList.add(new ArrayList<int[]>());
		}
		
		// 모든 노드의 dist를 INF로 초기화
		int[] dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		// pq 는 cost 오름차순 정렬
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1[1], o2[1]));
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int src = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			// 간선 adjList에 추가
			adjList.get(src).add(new int[] {dest, cost});

		}
		
		dist[start] = 0;
		pq.add(new int[] {start, 0});
		
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			
			// 이미 dist가 최적화되어쓰면
			if(dist[now[0]] < now[1]) {
				continue;
			}
			
			// now와 인접한 dest들에 연결된 간선 탐색
			for(int[] next : adjList.get(now[0])) {
				// 현재 dist[next.dest] 보다 
				// now를 경유해서 next.dest로 가는게 더 짧으면 업데이트
				// == now.cost + next.cost 
				if(dist[next[0]] > now[1] + next[1]) {
					dist[next[0]] = now[1] + next[1];
					// pq에도 next{dest, cost} 넣기
					pq.add(new int[] {next[0], dist[next[0]]});
							
				}
			}
		}
		
		
		for(int i=1; i<=V; i++) {
			System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
		}
		
		
	}
	

	
}
