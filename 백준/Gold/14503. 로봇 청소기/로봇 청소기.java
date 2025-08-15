
import java.util.*;
import java.io.*;


public class Main {
							  // 0 1  2 3
	                          // 북 동 남 서
	public static int[] moveX = {0,1,0,-1};
	public static int[] moveY = {-1,0,1,0};
	public static int[][] map;
	
	public static int N,M, totCleaned;
	
	
	
	public static boolean[][] visited;
	
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// N=y, M=x
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		// r=y, c=x
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		// 입력 
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		move(c, r, d);
		System.out.println(totCleaned);
	}
	
	public static void move(int x, int y, int d) {
		////////////////////////////
//		System.out.println("현재위치:  " + x + " " + y + " " + d);
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<M; j++) {
//				System.out.print(map[i][j]+ " ");
//			}
//			System.out.println();
//		}
		//////////////////////////
		// 현재 칸이 청소 안 되었으면 청소처리
		if(map[y][x] == 0) {
			map[y][x] = 2;
			totCleaned++;
		}
		
		
		boolean isEmpty = false;
		
		for(int i=0; i<4; i++) {
			int nx = moveX[i] + x;
			int ny = moveY[i] + y;
			
			// 범위체크
			if(nx<0 || ny<0 || nx>= M || ny >= N) 
				continue;
			
			// 주변 4칸 중 빈칸이 있으면
			if(map[ny][nx] == 0) {
				isEmpty = true;
				break;
			}			
		}
		
		
		// 현재 칸 주변 4칸에 빈칸 없는경우
		if(!isEmpty) {
			// 바라보는 방향을 유지한채로 한칸 후진 가능하다면
			// 한칸 후진하고 1번으로 돌아감
			int nx, ny;
			int flag = d<2 ? 2 : -2;
			nx = moveX[d+flag] + x;
			ny = moveY[d+flag] + y;
			
			// 범위 넘어감 = 후진불가
			if(nx<0 || ny<0 || nx>= M || ny >= N) 
				return;
			
			// 뒤쪽 벽이 아니면 후진가능
			if(map[ny][nx] != 1) {
				move(nx, ny, d);
			}
			// 후진불가능하면 작동멈춘다
			return;
		} else { // 현재 칸 주변 4칸에 빈칸이 있는 경우
			// 반시계로 90도회전
			// 반시계 : d 숫자 감소방향
			int nd = (d+4-1)%4;

			int nx, ny;
			nx = moveX[nd] + x;
			ny = moveY[nd] + y;
			
			//범위체크
			if(nx<0 || ny<0 || nx>= M || ny >= N) {
				move(x, y, nd);
				return;
			}
				
			// 바라보는 방향을 기준으로 앞쪽 칸이 0일겨우
			// 한칸전진
			if(map[ny][nx] == 0) {
				move(nx, ny, nd);
				return;
			}
			move(x, y, nd);
			return;
			
			
			
			
			
		}
	}
	
	
}
