
import java.io.*;
import java.util.*;

public class Main {
	/* 무방향이고, 두 정점 v1, v2은 무조건 통과해야함
	 * 1, v1, v2에서 다른모든점의 거리 찾고,
	 * 1->v1->v2->끝
	 * or
	 * 1->v2->v1->끝
	 * 중 작은값 찾기
	 * 
	 * */

	static int N, E;
	static int v1, v2;
	static List<int[]>[] edge;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		edge = new List[N+1];
		for(int i=1; i<=N; i++) {
			edge[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			edge[s].add(new int[] {e, t});
			edge[e].add(new int[] {s, t});
			
			
		}
		
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
	
		int[] sToOther = dijkstra(1);
		int[] v1ToOther = dijkstra(v1);
		int[] v2ToOther = dijkstra(v2);
		
		int answer=0;
		boolean numFlag = true;
		boolean num2Flag = true;
		int num = sToOther[v1] + v1ToOther[v2] + v2ToOther[N];
		int num2 = sToOther[v2] + v2ToOther[v1] + v1ToOther[N];
		
		if(sToOther[v1]==Integer.MAX_VALUE || v1ToOther[v2]==Integer.MAX_VALUE || v2ToOther[N]==Integer.MAX_VALUE) {
			numFlag = false;
		}
		if(sToOther[v2]==Integer.MAX_VALUE || v2ToOther[v1]==Integer.MAX_VALUE || v1ToOther[N]==Integer.MAX_VALUE) {
			num2Flag = false;
		}
		
		if(numFlag && num2Flag) {
			answer = Math.min(num,num2);
		}
		else if(numFlag) {
			answer = num2;
		}else if(num2Flag) {
			answer = num;
		}else {
			answer = -1;
		}
			
		
			
		System.out.println(answer);
		
	}
	
	static int[] dijkstra(int start) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[1]-b[1]));
		int[] minDist = new int[N+1];
		Arrays.fill(minDist, Integer.MAX_VALUE);
		
		pq.add(new int[] {start,0});
		minDist[start] = 0;
		
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			
			if(now[1] > minDist[now[0]]) {
				continue;
			}
			
			for(int[] next : edge[now[0]]) {
				if(minDist[next[0]] > next[1] + minDist[now[0]]) {
					minDist[next[0]] = next[1] + minDist[now[0]];
					pq.add(new int[] {next[0], minDist[next[0]]});
				}
				
			}
			
		}
		
		return minDist;
		
		
	}
	
	
	
	
	
	
	
}
