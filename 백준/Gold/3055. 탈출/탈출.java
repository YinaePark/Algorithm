

import java.util.*;
import java.io.*;

class Main
{
	
	public static class Point{
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static char[][] map;
	static ArrayDeque<Point> q;
	static ArrayDeque<Point> water;
	static boolean[][] visited;
	static int[][] dist;
	
	static int r;
	static int c;
	
	static int[] moveX = {0,0,-1,1};
	static int[] moveY = {-1,1,0,0};
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		r = sc.nextInt();
		c = sc.nextInt();
		
		q = new ArrayDeque<>();
		water = new ArrayDeque<>();
		Point start=null;
		Point end=null;
		
		map = new char[r][c];
		dist = new int[r][c];
		visited = new boolean[r][c];
		
		sc.nextLine();
		
		// 맵 초기화, water 배열 찾기
		for(int i=0; i<r; i++) {
			map[i] = sc.nextLine().toCharArray();
			for(int j=0; j<c; j++) {
				if(map[i][j] == 'S') {
					start = new Point(j,i);
				}
				else if(map[i][j] == 'D') {
					end = new Point(j,i);
				}
				else if(map[i][j] == '*') {
					water.add(new Point(j,i));
				}
				// 테스트출력
				// System.out.print(map[i][j]);
				
			}
			// System.out.println();
		}
		
		int result = bfs(start,end);
		
		if(result == -1) {
			System.out.println("KAKTUS");
			return;
		}
		System.out.println(result);
		
		
		sc.close();
		
	}
	
	public static int bfs(Point start, Point end) {
		visited[start.y][start.x] = true;
		dist[start.y][start.x] = 0;
		q.add(start);
		
		
		// 매 턴 비버 이동
		while(!q.isEmpty()) {
			
			// 인접 점 물 처리
			int nowWaterSize = water.size();	
			for(int idx=0; idx<nowWaterSize; idx++) {
				Point p = water.poll();
				for(int i=0; i<4; i++) {
					int newX = p.x + moveX[i];
					int newY = p.y + moveY[i];
					
					// 범위 벗어나거나, 돌이거나, 비버굴이거나, 이미 물 차있으면 패스
					if(newX<0 || newY<0 || newX>=c || newY>=r || map[newY][newX] == 'X' || map[newY][newX] == 'D' || map[newY][newX] == '*') {
						continue;
					}
					// 아니면 물채우기
					else if(map[newY][newX] == '.') {
						map[newY][newX] = '*';
						water.add(new Point(newX, newY));
					}
				}		
			}
			
			// !!!! bfs의 depth마다 물을 확장해야하기때문에 
			int nowDepthSize = q.size();
			for(int idx=0; idx<nowDepthSize; idx++) {
				// 비버이동
				Point now = q.poll();
				if(now.x == end.x && now.y == end.y) {
					return dist[now.y][now.x];
				}
					
				for(int i=0; i<4; i++) {
					int newX = now.x + moveX[i];
					int newY = now.y + moveY[i];
					
					// 범위 벗어나거나, 돌이거나, 비버굴이거나, 이미 물 차있으면 패스
					if(newX<0 || newY<0 || newX>=c || newY>=r || map[newY][newX] == 'X' || map[newY][newX] == '*' || visited[newY][newX]) {
						continue;
					}
					// 아니면 이동
					else {
						dist[newY][newX] = dist[now.y][now.x] + 1;
						visited[newY][newX] = true;
						q.add(new Point(newX, newY));
					}
				}			
			}
				
		}
			
			
		return -1;
	}
	

	
}
