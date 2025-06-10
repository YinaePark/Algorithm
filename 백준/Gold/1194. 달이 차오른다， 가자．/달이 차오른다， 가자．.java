

import java.util.*;
import java.io.*;

class Main
{
	static int N, M;
	static char[][] map;
	static boolean[][][] visited;
	static Point start;
	static Point end;
	static int[] moveX = {0,0,-1,1};
	static int[] moveY = {-1,1,0,0};
	
	// state는 열쇠 보유 현황
	// 각 자리수 비트로 a,b,c,d,e,f의 보유 여부 판단
	public static class Point{
		int x, y, state;
		public Point(int x, int y, int state) {
			this.x = x;
			this.y = y;
			this.state = state;
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		visited = new boolean[N][M][1<<6];
		
		sc.nextLine();
		
		for(int i=0; i<N; i++) {
			map[i] = sc.nextLine().toCharArray();
			for(int j=0; j<M; j++) {
				if(map[i][j] == '0') {
					start = new Point(j,i,0);
				}
			}
		}
		
		System.out.println(bfs());
		
		
	}
	public static int bfs() {
		ArrayDeque<Point> q = new ArrayDeque<>();
		q.add(start);
		visited[start.y][start.x][start.state] = true;
		int result = 0;
		
		
		while(!q.isEmpty()) {
			int qSize = q.size();
			result++;
			//System.out.println(result + " 큐사이즈??" + q.size() + " dpeth는?? " + result);
			for(int repeat=0; repeat<qSize; repeat++) {
				Point now = q.poll();
				//System.out.println("지금... " + now.x + " " + now.y);
				// 종료조건
				if(map[now.y][now.x] == '1') {
					return result-1;
				}
				
				// 4방향 탐색
				for(int i=0; i<4; i++) {
					//System.out.println("지금 이 방향으로 탐색중임" + i);
					int nx = now.x + moveX[i];
					int ny = now.y + moveY[i];
					int ns = now.state;
					
					// 범위 벗어나거나 벽일 경우 탐색 불가
					if(nx<0 || ny<0 || nx>=M || ny>=N || map[ny][nx] == '#') {
						continue;
					}
					
					// 열쇠 만났을 경우 state 변경, 이동
					if(map[ny][nx] == 'a') {
						ns = ns | (1<<0);
					}
					else if(map[ny][nx] == 'b') {
						ns = ns | (1<<1);
					}
					else if(map[ny][nx] == 'c') {
						ns = ns | (1<<2);
					}
					else if(map[ny][nx] == 'd') {
						ns = ns | (1<<3);
					}
					else if(map[ny][nx] == 'e') {
						ns = ns | (1<<4);
					}
					else if(map[ny][nx] == 'f') {
						ns = ns | (1<<5);
					}
					
					if(visited[ny][nx][ns] == true) {
						
						//System.out.println("방문??" + nx + "  " + ny + "  " + ns);
						continue;
					}
									
					
					// 문일경우 열쇠 보유 여부를 확인한다
					if(map[ny][nx] == 'A') {
						// 보유하고있다면 이동
						if((ns & (1<<0)) != 0) {
							q.add(new Point(nx, ny, ns));
							visited[ny][nx][ns] = true;
						} // 보유 안했다면 
						else {
							continue;
						}
					}
					if(map[ny][nx] == 'B') {
						// 보유하고있다면 이동
						if((ns & (1<<1)) != 0) {
							q.add(new Point(nx, ny, ns));
							visited[ny][nx][ns] = true;
						} // 보유 안했다면 
						else {
							continue;
						}
					}
					if(map[ny][nx] == 'C') {
						// 보유하고있다면 이동
						if((ns & (1<<2)) != 0) {
							q.add(new Point(nx, ny, ns));
							visited[ny][nx][ns] = true;
						} // 보유 안했다면 
						else {
							continue;
						}
					}
					if(map[ny][nx] == 'D') {
						// 보유하고있다면 이동
						if((ns & (1<<3)) != 0) {
							q.add(new Point(nx, ny, ns));
							visited[ny][nx][ns] = true;
						} // 보유 안했다면 
						else {
							continue;
						}
					}
					if(map[ny][nx] == 'E') {
						// 보유하고있다면 이동
						if((ns & (1<<4)) != 0) {
							q.add(new Point(nx, ny, ns));
							visited[ny][nx][ns] = true;
						} // 보유 안했다면 
						else {
							continue;
						}
					}
					if(map[ny][nx] == 'F') {
						// 보유하고있다면 이동
						if((ns & (1<<5)) != 0) {
							q.add(new Point(nx, ny, ns));
							visited[ny][nx][ns] = true;
						} // 보유 안했다면 
						else {
							continue;
						}
					}
					
					// 0, 빈곳, 열쇠일 경우이동
					//System.out.println("큐에집어넣기  " + nx + "  " + ny);
					q.add(new Point(nx, ny, ns));
					visited[ny][nx][ns] = true;	
				}
	
			}

		}
		return -1;
	}
	
	
	
}
