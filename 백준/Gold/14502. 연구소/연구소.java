
import java.util.*;
import java.io.*;


public class Main {
	
	/*
	 * 빈 칸 중 3개 골라서 벽을 세우기 : 최대 64C3 = 41664
	 * 경우마다 bfs 돌려서 최대 안전영역개수 세기 : O(64)
	 * -> 완탐
	 * 
	 * */
	
	public static int N, M;
	public static int saveCnt=0;
	public static int[] moveX = {0,0,-1,1};
	public static int[] moveY = {-1,1,0,0};
	public static int maxResult = 0;
	
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] map  = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) saveCnt++;
			}
		}
		
		// 바이러스가 있는 점들 = 시작점 모두 q에 넣기
		ArrayDeque<int[]> q = new ArrayDeque<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 2) 
					q.add(new int[] {j,i});
			}
		}
		
		setWall(0, q, map);
		System.out.println(maxResult-3);
		
		
	}
	
	// 3개 골라서 벽 세우기(백트래킹)
	public static void setWall(int depth, ArrayDeque<int[]> q, int[][] map) {
		if(depth == 3) {
			ArrayDeque<int[]> qCopy = new ArrayDeque<>(q);
		    int[][] mapCopy = new int[N][M];
		    for (int i = 0; i < N; i++) {
		        System.arraycopy(map[i], 0, mapCopy[i], 0, M);
		    }
		    int result = bfs(qCopy, mapCopy);
		    maxResult = Math.max(maxResult, result);
			return;
		} 
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] != 0) continue;
				map[i][j] = 1;
				setWall(depth+1, q, map);
				map[i][j] = 0;
			}
		}
	}
	
	public static int bfs(ArrayDeque<int[]> q, int[][] map) {
		int cnt=saveCnt;
		boolean[][] visited = new boolean[N][M];
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int i=0; i<4; i++) {
				int nx = now[0] + moveX[i];
				int ny = now[1] + moveY[i];
				if(nx<0 || ny <0 || nx>= M || ny>= N 
						|| visited[ny][nx] == true
						|| map[ny][nx] == 1) {
					continue;
				}
				if(map[ny][nx] == 0) {
					cnt--;
					
					
				}
				visited[ny][nx] = true;
				q.add(new int[] {nx, ny});
			}
		}

		
		return cnt;
	}
}
