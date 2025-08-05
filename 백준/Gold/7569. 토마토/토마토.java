
import java.util.*;
import java.io.*;


public class Main {
	
	
	public static boolean[][][] visited;
	public static int[][][] box;
	public static int M, N, H;
	
	public static int[] moveX = {1, -1, 0, 0, 0, 0};
	public static int[] moveY = {0, 0, 1, -1, 0, 0};
	public static int[] moveZ = {0, 0, 0, 0, 1, -1};

	
	
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		H = sc.nextInt();
		// 익지 않은 토마토 개수, 토마토가 모두 익지는 못하는 상황인지 판별하기 위해 사용 
		int unripTmtNum = 0;
		box = new int [M][N][H];
		visited = new boolean [M][N][H];
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		int[] firstTmt = {-1, -1, -1};
		
		// 입력받기
		for(int h=0; h<H; h++) {
			for(int n =0; n<N; n++) {
				for(int m=0; m<M; m++) {
					box[m][n][h] = sc.nextInt();
					// 토마토가 익엇으면
					if(box[m][n][h] == 1) {
						visited[m][n][h] = true;
						// 익은 토마토 큐에담기
						q.add(new int[] {m,n,h});
					}
					if(box[m][n][h] == 0) {
						
						unripTmtNum++;
						
					}
					
				}
			}
		}
		
		if(unripTmtNum == 0) {
			System.out.println(0);
			return;
		}
		
		// bfs
		
		int days = -1;
		
		
		while(!q.isEmpty()) {
			
			
			
			int size = q.size(); 
			// 큐사이즈만큼 반복
			for(int turn = 0; turn<size; turn++) {
				int[] now = q.poll();
				// 반복
				for(int i=0; i<6; i++) {
					int nx = now[0] + moveX[i];
					int ny = now[1] + moveY[i];
					int nz = now[2] + moveZ[i];
					
					// 만약 이미 방문했거나, 
					// 범위를 벗어났거나,
					// 빈곳이면 continue
					if(nx<0 || ny<0 || nz<0 || 
							nx>=M || ny>=N || nz>=H ||
							visited[nx][ny][nz] ||
							box[nx][ny][nz] == -1) {
						continue;
					}
					
					// 익지 않았으면 익게하기
					if(box[nx][ny][nz] == 0) {
						box[nx][ny][nz] = 1;
						visited[nx][ny][nz] = true;
						unripTmtNum--;
						q.add(new int[] {nx,ny,nz});
						continue;
					}
					
				}
				
			}
			days++;

		}
		
		if(unripTmtNum != 0) {
			days = -1;
		}
		System.out.println(days);
		
		
		
	}
	
}
