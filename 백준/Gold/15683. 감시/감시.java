
import java.util.*;
import java.io.*;


public class Main {
	/*
	 * 
	 * */
	
	static int N, M, k;
	static int blindSpot=0;
	static int blindSpotCopy;
	static int[][] map;
	static int[][] mapCopy;
	static int[] cctvDirection = new int[8];
	
	// cctvCnt 는 방향 시뮬돌릴 cctv 개수
	static int[][] cctvList = new int[8][2];
	static int cctvCnt=0;
	
	static int answer=Integer.MAX_VALUE;
	
	public static void main(String args[]) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				// 저장
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				
				if(num == 0) {
					blindSpot++;
				}else if(num > 0 && num <= 5) {
					cctvList[cctvCnt][0] = j;
					cctvList[cctvCnt][1] = i;

					cctvCnt++;
				}
//				else if(num == 5) {
//					
//					simulation(5, 0, j, i, 7);
//					
//				}
				
			}
		}
		
		// 원래 map과 원래 blindSpot을 copy에 각각 저장(복구용)
		mapCopy = new int[N][M];
		for(int i = 0; i < N; i++) {
			mapCopy[i] = new int[M];
		    System.arraycopy(map[i], 0, mapCopy[i], 0, M);
		}
		blindSpotCopy = blindSpot;
		
		backtracking(0);
		
		System.out.println(answer);
		
	}
	
	// 백트래킹으로 cctv 방향에 대한 모든 조합을 찾기
	// 2번은 2개방향
	
	static void backtracking(int depth){
		// 모든 cctv 방향 다 정했으면 시뮬돌리고, max 업데이트하고, 복구
		if(depth == cctvCnt) {
			

			// i번쨰 cctv에 대한 시뮬
			for(int i=0; i<cctvCnt; i++) {
				int x = cctvList[i][0];
				int y = cctvList[i][1];
				simulation(map[y][x], cctvDirection[i], x, y, 7);
				
			}
			
//			System.out.println("===변경후===========");
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<M; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("===============");
			
			recover();
			return;
		}
		
		
		for(int i=0; i<4; i++) {
			cctvDirection[depth] = i;
			backtracking(depth+1);
		}
		
		
	}
	
	// recover하면서 7 카운트
	static void recover() {
		int cnt = blindSpotCopy;
		for(int i = 0; i < N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 7) {
					cnt--;
					
				}
				map[i][j] = mapCopy[i][j];
				
			}
		}
		
		if(answer > cnt) answer = cnt;
	}
	
	static void simulation(int cctvType, int direction, int x, int y, int mark) {

		
		switch(cctvType) {
		case 1:
			fillBlank(x, y, direction, mark);
			break;
		case 2:
			// 상하 or 좌우
			if(direction == 0 || direction == 2) {
				fillBlank(x, y, 0, mark);
				fillBlank(x, y, 2, mark);
			}
			else {
				fillBlank(x, y, 1, mark);
				fillBlank(x, y, 3, mark);
			}
			break;
		case 3:
			int d1 = direction;
			int d2 = (direction+1)%4;
			fillBlank(x, y, d1, mark);
			fillBlank(x, y, d2, mark);
			break;
		case 4:
			d1 = direction;
			d2 = (direction+1)%4;
			int d3 = (direction+2)%4;
			fillBlank(x, y, d1, mark);
			fillBlank(x, y, d2, mark);
			fillBlank(x, y, d3, mark);
			break;
		case 5: 
			// 사방으로 모두 채우기
			for(int i=0; i<4; i++) {
				fillBlank(x, y, i, mark);
			}
			break;
		}
		

	}

	/*
	 * 문제상황 : mark=0일 떄 다른 씨시티비의 감시범위까지 싹다 0으로 초기화해버림
	 * 해결법 : 씨씨티비방향 조합을 먼저찾고, 모든 조합 다찾았을떄 시뮬돌리고 초기배열로 복구
	 * */
	// 시계방향
	static void fillBlank(int x, int y, int direction, int mark) {

		// 위
		if(direction == 0) {
			int ny = y+1;
			while(true) {
				if(x<0 || ny<0 || x>=M || ny>=N || map[ny][x] == 6) break;
				if(map[ny][x] == 0) map[ny][x] = mark;
				ny++;
			}
		} // 오른쪽
		else if(direction == 1) {
			int nx = x+1;
			while(true) {
				if(nx<0 || y<0 || nx>=M || y>=N || map[y][nx] == 6) break;
				if(map[y][nx] == 0) map[y][nx] = mark;
				nx++;
			}
		
		} // 아래
		else if(direction == 2) {
			int ny = y-1;
			while(true) {
				if(x<0 || ny<0 || x>=M || ny>=N || map[ny][x] == 6) break;
				if(map[ny][x] == 0) map[ny][x] = mark;
				ny--;
			}
		} // 왼쪽
		else if(direction == 3) {
			int nx = x-1;
			while(true) {
				if(nx<0 || y<0 || nx>=M || y>=N || map[y][nx] == 6) break;
				if(map[y][nx] == 0) map[y][nx] = mark;
				nx--;
			}
		}
		

	}
	
}
