
import java.util.*;
import java.io.*;


public class Main {
	/*
	 * 다익스트라 : Pq사용
	 * - 시작~각노드까지 거리 INf로 초기화
	 * - start로부터 현재 가장 적은 비용으로 갈 수 있는 노드 선택
	 * - 현재 선택된 노드에 대해, 해당 노드를 거쳐서 각 노드까지 가는 최소 비용과,
	 *   현재까지 구한 최소 비용을 비교하여 갱신
	 * 
	 * 특이점 : 최단경로 역추적이 필요함
	 * - 해결: 최단거리 업데이트할때마다 직전 노드를 기록한다
	 * 
	 * 틀린거 : 
	 * - pq에 초기화넣을때 start,가아니라 0을넣음
	 * - !!!!!!!!!숫자가 String.reverse해서 10 -> 01로 출력됨;;;
     * - 다익스트라 조건에 >=로하면 메모리초과
	 * */
	

	static int N, M, start, end;
	// adjList[start] = List<{start, end, cost}>
	static List<int[]>[] adjList;
	static int[] minCost;
	
	static int[] prevNode;

	public static void main(String args[]) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		adjList = new List[N];
		
		for(int i=0; i<N; i++) {
			adjList[i] = new ArrayList<int[]>();
		}
		// n개 도시들의 start에서 출발하는 비용
		minCost = new int[N];
		prevNode = new int[N];
		
		Arrays.fill(minCost, Integer.MAX_VALUE);
		
		
		StringTokenizer st;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());

			adjList[s].add(new int[] {s,e,cost});
			
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken()) -1;
		end = Integer.parseInt(st.nextToken()) - 1;
		
		
		// cost 순 정렬
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> (o1[2] - o2[2]));
		pq.add(new int[] {start,start,0});
		minCost[start] = 0;
		
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			int s = now[0];
			int e = now[1];
			int cost = now[2];
			
			// 이미 최적화되었으면 continue
			if(cost > minCost[e]) continue;
			
			// 아니면, 연결된 다음 node들에 대해, now를 경유해서 그 다음으로 가는게
			// minCost보다 짧으면 갱신
			// s -> e -> next의 e 경로가 현재 
			
			for(int[] next : adjList[e]) {
				int nexte = next[1];
				int nextCost = next[2];
				
				if(minCost[nexte] > cost + nextCost) {
					minCost[nexte] = cost + nextCost;
					prevNode[nexte] = e;
					pq.add(new int[] {e, nexte, minCost[nexte]});
				}
			}
		}
		
		// 최소비용
		System.out.println(minCost[end]);
		int cnt=1;
		
		ArrayList<Integer> answer = new ArrayList<>();
		
		while(end != start) {
			answer.add(end+1);
			cnt++;
			end = prevNode[end];
		}
		answer.add((start+1));
		Collections.reverse(answer);
		
		System.out.println(cnt);
		for(int i : answer) {
			System.out.print(i + " ");
		}
		
	}
	
	
	
}

