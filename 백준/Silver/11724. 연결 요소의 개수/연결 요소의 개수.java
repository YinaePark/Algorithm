
import java.util.*;
import java.io.*;


public class Main {
	
	public static Map<Integer, List<Integer>> map = new HashMap<>();
	public static boolean[] visited;
			
	public static void main(String args[]) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		// n: 점 개수
		// m : 선 개수
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		visited = new boolean[n+1];
		
		for(int i=0; i<m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			map.computeIfAbsent(u, k->new ArrayList()).add(v);
			map.computeIfAbsent(v, k->new ArrayList()).add(u);

		}
		
		int result = 0;
		for(int i=1; i<n+1; i++) {
			// 방문 안 했으면
			if(!visited[i]) {
				dfs(i);
				result++;
			}
		}
		
		System.out.println(result);
		
	}
	
	public static void dfs(int now) {
		visited[now] = true;
		List<Integer> dests = map.get(now);
		if(dests == null || dests.isEmpty()) return;
		for(int dest : dests) {
			if(!visited[dest]) {
				dfs(dest);
			}
			
		}
		return;
	}
	
	
}
