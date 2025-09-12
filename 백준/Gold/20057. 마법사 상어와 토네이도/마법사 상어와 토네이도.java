

import java.util.*;
import java.io.*;


public class Main {
	/*
	 * 특이사항
	 * 
	 * 1. moveDist 마지막에 범위 -1,0까지감
	 * 
	 * 2. 소수점 계산할때 *,/ 앞에서부터 순서대로됨 주의
	 * */
	
	// 좌 하 우 상
	static int[] moveX = {-1, 0, 1, 0};
	static int[] moveY = {0, 1, 0, -1};
	
	// 격자 박으로 나간 모래 양
	static int answer = 0;
	

	static int N, M, K;
	static int[][] map;
	
	// 각 방향으로 moveX, moveY 반복, moveDist는 2번씩 반복(2/2, 3/2, 4/2, 5/2, ..)
	static int direction=0;
	static int moveDist=2;
	
	public static void main(String args[]) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		// N은 홀수, 가운데부터 시작
		int nowX = N/2;
		int nowY = N/2;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			for(int i=0; i<moveDist/2; i++) {
				
				nowX += moveX[direction];
				nowY += moveY[direction];
				
				if(nowX == -1) break;

				// -1,0
				updateSurrSand(nowX, nowY, direction);
				
			}
			 
			moveDist++;
			direction = (direction+1)%4;
			if(nowX <= 0 && nowY <= 0) break;
		}
		
		// 테스트
		
		
		System.out.println(answer);
		
		
	}
	
	// x, y 는 y좌표!!!!
	static void updateSurrSand(int x, int y, int direction) {
		int original = map[y][x];
		map[y][x] = 0;
		int remain = original;
		// 좌 하 우 상
		switch(direction) {
		case 0:
			
			// 7%
			remain -= updateSand(x, y-1, original, 7);
			remain -= updateSand(x, y+1, original, 7);
			// 2%
			remain -= updateSand(x, y-2, original, 2);
			remain -= updateSand(x, y+2, original, 2);
			// 10%
			remain -= updateSand(x-1, y-1, original, 10);
			remain -= updateSand(x-1, y+1, original, 10);
			// 5%
			remain -= updateSand(x-2, y, original, 5);
			// 1%
			remain -= updateSand(x+1, y+1, original, 1);
			remain -= updateSand(x+1, y-1, original, 1);
			// alpha
			updateAlpha(x-1, y, remain);
			
			break;
			
		case 1:
			// 7%
			remain -= updateSand(x-1, y, original, 7);
			remain -= updateSand(x+1, y, original, 7);
			// 2%
			remain -= updateSand(x-2, y, original, 2);
			remain -= updateSand(x+2, y, original, 2);
			// 10%
			remain -= updateSand(x-1, y+1, original, 10);
			remain -= updateSand(x+1, y+1, original, 10);
			// 5%
			remain -= updateSand(x, y+2, original, 5);
			// 1%
			remain -= updateSand(x+1, y-1, original, 1);
			remain -= updateSand(x-1, y-1, original, 1);
			// alpha
			updateAlpha(x, y+1, remain);
			break;
			
		case 2:
			// 7%
			remain -= updateSand(x, y-1, original, 7);
			remain -= updateSand(x, y+1, original, 7);
			// 2%
			remain -= updateSand(x, y-2, original, 2);
			remain -= updateSand(x, y+2, original, 2);
			// 10%
			remain -= updateSand(x+1, y-1, original, 10);
			remain -= updateSand(x+1, y+1, original, 10);
			// 5%
			remain -= updateSand(x+2, y, original, 5);
			// 1%
			remain -= updateSand(x-1, y+1, original, 1);
			remain -= updateSand(x-1, y-1, original, 1);
			// alpha
			updateAlpha(x+1, y, remain);
			
			break;
		case 3:
			// 7%
			remain -= updateSand(x-1, y, original, 7);
			remain -= updateSand(x+1, y, original, 7);
			// 2%
			remain -= updateSand(x-2, y, original, 2);
			remain -= updateSand(x+2, y, original, 2);
			// 10%
			remain -= updateSand(x-1, y-1, original, 10);
			remain -= updateSand(x+1, y-1, original, 10);
			// 5%
			remain -= updateSand(x, y-2, original, 5);
			// 1%
			remain -= updateSand(x+1, y+1, original, 1);
			remain -= updateSand(x-1, y+1, original, 1);
			// alpha
			updateAlpha(x, y-1, remain);
			break;
		}
	}
	
	static void updateAlpha(int x, int y, int amount) {
		if(y<0 || x < 0 || y>=N || x>=N) {
			answer += amount;
		}else {
			map[y][x] += amount;
		}
	}
	
	static int updateSand(int x, int y, int original, int percentage) {
		int amount = original * percentage / 100;
		if(x<0 || y<0 || x>=N || y>=N) {
			answer += amount;
			return amount;
		}else {
			map[y][x] += amount;
			return amount;
		}
	}
	
	
	
	
}

