
import java.util.*;
import java.io.*;


public class Main {
	/*
	 * 
	 * 
	 * */
	
	public static int[][] map;
	public static boolean[][] visited;
	public static int N, M;
	
	public static int unripeTmt = 0;
	
	public static int[] moveX = {0,0,-1,1};
	public static int[] moveY = {-1,1,0,0};
	
	public static void main(String args[]) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		ArrayDeque<int[]> q = new ArrayDeque<>();
		

		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][j] = tmp;
				if(tmp == 1) {
					q.add(new int[] {j,i});
					visited[i][j] = true;
				}
				if(tmp == 0) unripeTmt++;
				
			}
		}
				
		int result = bfs(q);
		result = unripeTmt == 0 ? result : -1;
		System.out.println(result);
		
	}
	
	public static int bfs(ArrayDeque<int[]> q) {
		int days=-1;
		
		while(!q.isEmpty()) {
			int qSize = q.size();
			
			
			for(int k=0; k<qSize; k++) {
				int[] now = q.poll();
				
				for(int i=0; i<4; i++) {
					int nx = now[0] + moveX[i];
					int ny = now[1] + moveY[i];
					
					if(nx<0 || ny<0 || nx>= M || ny>= N 
							|| visited[ny][nx]
							|| map[ny][nx] != 0)
						continue;
					
					
					map[ny][nx] = 1;
					unripeTmt--;
					visited[ny][nx] = true;
					q.add(new int[] {nx, ny});
					
				}
			}
			days++;
			
		}
		
		return days;
		
		
		
		
	}
	

	
}
