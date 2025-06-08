

import java.util.*;
import java.io.*;

class Main
{
	static int N, M;
	static char[][] map;
	// [][][0] : 벽 아직 안 부숨 [][][1] : 벽 부순상태
	static int[][][] dist;
	static boolean[][][] visited;
	static int[] moveX = {0,0,-1,1};
	static int[] moveY = {-1,1,0,0};
	
	static public class Point {
		int x, y;
		boolean breaked;
		public Point(int x, int y, boolean breaked) {
			this.x = x;
			this.y = y;
			this.breaked = breaked;
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		sc.nextLine();
		
		map = new char[N][M];
		dist = new int[N][M][2];
		visited = new boolean[N][M][2];
		
		for(int i=0; i<N; i++) {
			map[i] = sc.nextLine().toCharArray();
		}
				
		
		// 불가능할 경우
		System.out.println(bfs());
		
	}
	
	// 0이 길, 1이 벽
	// (1,1) 에서 (N,M)까지 최단경로로 이동해야하는데
	// 이동중 1개의 벽까지는 부술 수 있음
	public static int bfs() {
		ArrayDeque<Point> q = new ArrayDeque<>();
		q.add(new Point(0,0, false));
		visited[0][0][0] = true;
		dist[0][0][0] = 1;
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			// 목적지에 도달했으면 종료
			if(now.x == M-1 && now.y == N-1) {
				int breaked = now.breaked == false ? 0 : 1;
				return dist[now.y][now.x][breaked];
			}
			
			for(int i=0; i<4; i++) {
				int nextX = now.x+moveX[i];
				int nextY = now.y+moveY[i];
				
				// 범위 밖이면 탐색불가
				if(nextX<0 || nextY<0 || nextX>=M || nextY>=N){
					continue;
				}
				
				
				boolean nextBreaked = now.breaked;
				// 벽일때,
				if(map[nextY][nextX] == '1') {
					// 이미 벽 부쉈으면 더이상 부술 수 없음
					if(now.breaked == true) {
						continue;	
					}
					// 아직 벽 안 부쉈으면 부수고 갈 수 있음(breaked = true여야함)	
					nextBreaked = true;	
				} // 벽아니고그냥 칸일떄
				
				// !!!!!!!!!!!!!!!!nextBreaked 의 상태에 따라 visited 검사
				int b = nextBreaked? 1 : 0;
				if(visited[nextY][nextX][b]) continue;
				
				// 거리갱신, 큐에삽입 등등
				visited[nextY][nextX][b] = true;
				dist[nextY][nextX][b] = dist[now.y][now.x][now.breaked?1:0] + 1;
				q.add(new Point(nextX, nextY, nextBreaked));
			}
		}
		return -1;
	}
	
	
				

	
}
