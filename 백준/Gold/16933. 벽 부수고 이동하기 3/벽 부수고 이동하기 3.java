
import java.io.*;
import java.util.*;

public class Main {
	/* 
	 * 0이동가능 1 벽
	 * 1,1 > n,m으로 최단경로이동(시작끝포함)
	 * 
	 * 벽 k개까지 부술수있음
	 * 벽은 낮에만 부술수있음, 안움직이고 같은 칸에 머물러도되는데 이때도 한칸 늘어난걸로 생각함
	 * 처음이동이 낮
	 * * */

	static int N,M,K;
	static char[][] map;
	static int[] moveX = {-1,1,0,0};
	static int[] moveY = {0,0,-1,1};
	static boolean[][][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M][K+1];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
			
			
		}
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		visited[0][0][0] = true;
		// x, y, 벽부순횟수, dist
		q.add(new int[] {0,0,0,1});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
//			System.out.println("현재점: " + now[0] + " " + now[1]);
			if(now[0] == M-1 && now[1] == N-1) {
				System.out.println(now[3]);
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nx = now[0] + moveX[i];
				int ny = now[1] + moveY[i];
				int nk = now[2];
				int nd = now[3];
				
				if(nx<0 || ny<0 ||nx>=M||ny>=N)
					continue;
				
				// 다음칸이 벽이고
				// 1. 밤이면 낮될때까지 기다려야함
				// 2. 이미 k번 벽 부숴서 벽 부술 수 없으면 넘어가고, 있으면 부수기
				if(map[ny][nx] == '1') {
					
					if(nk>=K) {
						continue;

					}
					//밤이면 그자리에서 낮되게 기다리기
					if(nd%2==0) {
						q.add(new int[] {now[0], now[1], now[2], nd+1});
						continue;
					}
					// 낮이면 벽부수고이동
					else {
						nk++;
					}
				}
				
				if(visited[ny][nx][nk])
					continue;
				
				q.add(new int[] {nx, ny, nk, nd+1});
				visited[ny][nx][nk]= true;
				
				
			}
		}
		
		System.out.println(-1);

		
		
	}
	
	
	
}
