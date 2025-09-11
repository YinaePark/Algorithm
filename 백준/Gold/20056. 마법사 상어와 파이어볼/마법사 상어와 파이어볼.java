

import java.util.*;
import java.io.*;


public class Main {
	/*
	 * 특이사항 : 
	 * - List<int[]>[][] grid = new List[N][N];
	 * - int[] 를 저장하는 2차원 List..
	 * - gird[][].add(new int[] {})
	 * 
	 * - 범위 벗어났을 떄의 모듈러 처리
	 * 
	 * - 틀린 이유: q랑 grid 배열을 중복으로 갖고있었음(grid를 매 dpeht마다 초기화해야함)
	 * */
	
	// 0 ~ 7 
	static int[] moveX = {0,1,1,1, 0,-1,-1,-1};
	static int[] moveY = {-1,-1,0,1, 1,1,0,-1};
	
	static int N, M, K;
	
	static int[][] map;
	
	public static void main(String args[]) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];
	
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int[] ball = new int[5];
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			ball[0] = x-1;
			ball[1] = y-1;
			for(int j=2; j<5; j++) {
				ball[j] = Integer.parseInt(st.nextToken());
			}
			q.add(ball);
		}
		
		move(q);
		
	
		
		
	}
	
	// x, y, m, s, d
	static void move(ArrayDeque<int[]> q) {
		
		int depth = 0;
		// 각 칸의 fireball 저장
		
		
		while(depth < K) {
			List<int[]>[][] grid = new List[N][N];
		    for(int i = 0; i < N; i++) {
		        for(int j = 0; j < N; j++) {
		            grid[i][j] = new ArrayList<>();
		        }
		    }
			
			int qSize = q.size();
			for(int i=0; i<qSize; i++) {
				int[] ball = q.poll();
				int x = ball[0];
				int y = ball[1];
				int m = ball[2];
				int s = ball[3];
				int d = ball[4];

				// 범위 벗어낫을 떄의 복구
				int nx = ((x + s * moveX[d]) % N + N) % N;
	            int ny = ((y + s * moveY[d]) % N + N) % N;
				
				// 움직임 후의 구슬 저장
				grid[ny][nx].add(new int[] {nx, ny, m, s, d});
				
			}
			
			// 구슬 합치기
			// x, y, m, s, d
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(grid[i][j].isEmpty()) continue;
					if(grid[i][j].size() == 1) {
						q.add(grid[i][j].get(0));
						continue;
					}
						
					int mergedM = 0;
					int mergedS = 0;
					int oddCnt = 0;
					int evenCnt = 0;
					for(int[] ball : grid[i][j]) {
						mergedM += ball[2];
						mergedS += ball[3];
						
						if(ball[4] % 2 == 0) {
							evenCnt++;
						}else {
							oddCnt++;
						}
						
					}
					
					grid[i][j].clear();
					// 모두 홀수 or 모두 짝수
					if(oddCnt == 0 || evenCnt == 0) {
						for(int k=0; k<=6; k+=2) {
							if(mergedM/5 <= 0) continue;
							int[] newBall = new int[] {j, i, mergedM/5, mergedS/(oddCnt+evenCnt), k};
							grid[i][j].add(newBall);
							q.add(newBall);
						}
					}else {
						for(int k=1; k<=7; k+=2) {
							if(mergedM/5 <= 0) continue;
							int[] newBall = new int[] {j, i, mergedM/5, mergedS/(oddCnt+evenCnt), k};
							grid[i][j].add(newBall);
							q.add(newBall);
						}
					}
				}
			}
			
					
			depth++;
		}
		
		int answer = 0;
		
		
		
		for(int[] ball : q) {
			answer += ball[2];
		}
			
		
		
		System.out.println(answer);
	}
	
	
	
	
	
}

