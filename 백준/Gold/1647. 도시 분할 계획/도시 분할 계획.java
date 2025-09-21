
import java.io.*;
import java.util.*;

public class Main {
	/* 
	 * 유니온파인드:
	 * 경로압축이란? Find호출할떄 루트 찾는 과정에서 지나간 노드들으 부모를 모두 rootㅡ로 바꿔버리기
	 * return parent[x] = Find(parent[x]);
	 * 추가로최적화가능한방법 : rank, size기반합집합
	 * 
	 * 아이디어:
	 * - mst만들고나서 제일 비싼거 삭제하기
	 *  
	 * MST 구하기:
	 * 크루스칼: 양방향가중그래프의 mst찾는다
	 * - 노드 N일떄 간선을 N-1개 추가하면 MST를 찾은것임
	 * - 사이클이 안생기게하도록 union find를 사용해서 추가할 간선이 이미 같은 집합인지 판단한다
	 * - 그리디기반으로 가중치낮은걸 추가해가면서 mst차기
	 * 
	 * */
	
	static int[] parent;
	
	static int Find(int x) {
		if(x==parent[x]) return x;
		return parent[x] = Find(parent[x]);
	}
	
	static void Union(int x, int y) {
		int px = Find(x);
		int py = Find(y);

		if(px==py) return;
		// 더 작은 수를 parent로 지정
		if(px<py) parent[py] = px;
		else parent[px] = py;
	}
	
	static boolean isUnion(int x, int y) {
		x = Find(x);
		y = Find(y);
		return (x==y);
	}
	
	static int N, M;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// N : 마을개ㅜㅅ
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		
		List<int[]> edges = new ArrayList<>();
		
		
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());	
			
			edges.add(new int[] {n1, n2, cost});
			
		}
		Collections.sort(edges, (a,b)->(a[2]-b[2]));
		
		int total = 0;
		int max = -1;
		
		// 가중치 작은 애부터 연결
		for(int[] e : edges) {
			int n1=e[0];
			int n2=e[1];
			int cost = e[2];
			if(!isUnion(n1,n2)) {
				Union(n1,n2);
				total += cost;
				max = cost > max ? cost : max;
			}
		}
		
		System.out.println(total-max);
		
		

		
	}

}
