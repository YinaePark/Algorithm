
import java.io.*;
import java.util.*;

public class Main {
	/* 
	 * 틀린부분
	 * 1.메모리초과
	 * 
	 * 
	 * */

	static int X, Y;
	static char[][] map;
	static int[] start;
	static boolean[][] visited;
	static int[] moveX = {0,0,-1,1};
	static int[] moveY = {-1,1,0,0};
	static ArrayDeque<int[]> fireQ = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		map = new char[Y][X];
		visited = new boolean[Y][X];
		
		for(int i=0; i<Y; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			map[i] = str.toCharArray();
			for(int j=0; j<X; j++) {
				if(map[i][j] == 'J') {
					start = new int[] {j,i,0};
				}
				if(map[i][j] == 'F') {
					fireQ.add(new int[] {j,i});
				}
			}
			
		}
		
		bfs();
		
	}
	
	
	static void bfs() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.add(start);
		visited[start[1]][start[0]] = true;
		
		
		while(!q.isEmpty()) {
			
			int fireSize = fireQ.size();
			for(int f=0; f<fireSize; f++) {
				int[] now = fireQ.poll();
				for(int i=0; i<4; i++) {
					int nx = moveX[i] + now[0];
					int ny = moveY[i] + now[1];
					
					if(nx<0 || ny<0 || nx>=X || ny>=Y || visited[ny][nx] || map[ny][nx] == '#') {
						continue;
					}
					visited[ny][nx] = true;
					fireQ.add(new int[] {nx, ny});

					
				}
			}
			
//			System.out.println("불 전파후:");
//			for(int ii=0; ii<Y; ii++) {
//				for(int jj=0; jj<X; jj++) {
//					System.out.print(map[ii][jj]);
//					
//				}
//				System.out.println();
//				
//			}
			int jihoonSize = q.size();
			for(int j=0; j<jihoonSize; j++) {
				int[] now = q.poll();
				for(int i=0; i<4; i++) {
					int nx = moveX[i] + now[0];
					int ny = moveY[i] + now[1];
					int time = now[2] + 1;
					
					
					if(nx<0 || ny<0 || nx>=X || ny>=Y) {
						System.out.println(time);
						return;
					}
					if(visited[ny][nx] || map[ny][nx] == 'F' || map[ny][nx] == '#') {
						continue;
					}
					
					
					visited[ny][nx] = true;
					q.add(new int[] {nx, ny, time});

					
				}
			}
			


			
		}
		
		System.out.println("IMPOSSIBLE");
		
	}
}
