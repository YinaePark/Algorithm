
import java.util.*;
import java.io.*;


public class Main {
	/*
	 * 0,0 -> n-1,m-1
	 * 시작,끝칸세야함
	 * */
	
	static int[] moveX = {0,0,1,-1};
	static int[] moveY = {1,-1,0,0};

	static int M, N, K;
	static int[][] map;
	static boolean[][][] visited;

	public static void main(String args[]) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// (M, N)
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N][M][K+1];
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				if(str.charAt(j)=='0') {
					map[i][j] = 0;
				}else {
					map[i][j] = 1;
				}
			}
		}
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {0,0,0});
		visited[0][0][0] = true;
		
		int depth = 0;
		
		
		while(!q.isEmpty()) {
			int qSize = q.size();
			depth++;
			for(int round=0; round<qSize; round++) {
				int[] now = q.poll();
				int x = now[0];
				int y = now[1];
				int state = now[2];
				
				
				if(x == M-1 && y == N-1) {
					System.out.println(depth);
					return;
				}
				
				for(int i=0; i<4; i++) {
					int nx = x + moveX[i];
					int ny = y + moveY[i];
					int nstate = state;
					
					if(nx<0 || ny<0 || nx>=M || ny>=N) {
						continue;
					}
					
					// 벽일 경우 부술 수 있는지 확인
					if(map[ny][nx] == 1) {
						if(nstate<K) {
							nstate++;
						} else {
							continue;
						}
					}
					
					if(!visited[ny][nx][nstate]) {
						q.add(new int[] {nx, ny, nstate});
						visited[ny][nx][nstate] = true;
					}

				}
				
			}
			
			
		}
		
		System.out.println(-1);
		
	}
	
	
	
}

