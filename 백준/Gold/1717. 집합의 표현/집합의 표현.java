
import java.util.*;
import java.io.*;


public class Main {
	/*
	 * 
	 * 특이사항: 
	 * - dfs/bfs로풀면 시간초과날각
	 * 
	 * 유니온파인드:
	 * - 여러노드가 존재할떄 같은집합에있는지 확인
	 * - unf를 원소번호로 초기화(다다른집합)
	 * - 같은정점이면 더 숫자적은원소로 unf 업데이트
	 * - Find: 원소집합명=자기번호면 그냥 그번호리턴, 아니면 재귀로 unf[v] = Find(unf[v])
	 * - Union: 두원소를 각각 find()연산하고, 만약 다르면, unf를 하나로 맞춰줌
	 * - union에서 바로 unf가 동기화되지 않아서, 나중에 확인할라면 find를 호출해야댐
	 * - 왜냐면 트리구조라서 연결만돼있고 아직 unf는 업데이터X
	 * */
	
	static int[] unf;
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int find(int v) {
		if(unf[v] == v) return v;
		return unf[v] = find(unf[v]);
	}

	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa!=pb) unf[pa] = pb;
	}
	
	public static void main(String args[]) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// 0 ~ n
		unf = new int[n+1];
		for(int i=0; i<=n; i++) {
			unf[i] = i;
		}

		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 합집합이면
			if(command == 0) {
				union(a,b);
				continue;
			}
			
			if(find(a) != find(b)) {
				sb.append("NO\n");
			} 
			else {
				sb.append("YES\n");
			}
			
		}
		
		System.out.println(sb.toString());
		
	}
	
	
	
}

