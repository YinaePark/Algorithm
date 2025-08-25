
import java.util.*;
import java.io.*;


public class Main {
	/*
	 * 
	 * */
	
	
	public static int N, M, H;
	public static int[][] movable;
	
	public static void main(String args[]) throws Exception{		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		// 세로선 별 가로선 존재여부
		// -1 : 왼쪽 이동가능
		//  0 : 가로선x
		//  1 : 오른쪽이동가능
		movable = new int[N+1][H+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// b번쨰 세로선은 오른쪽이동가능, b+1 은 왼쪽 이동가능
			movable[b][a] = 1;
			movable[b+1][a] = -1;
		}
		
		// 모든 사다리가 다 조건에 맞으면 0
		if(move()) {
			System.out.println(0);
			return;
		} 
		
		
		for (int targetCount = 1; targetCount <= 3; targetCount++) {
            finish = false;
            backtracking(1, 1, targetCount, 0);
            if (finish) {
                System.out.println(targetCount);
                return;
            }
        }
		System.out.println(-1);
		

		
	}
	public static boolean finish =false;
	
	// x, y는 현재 인덱스
	public static void backtracking(int row, int col, int target, int count) {
		if(count > 3) {
			return;
		}
		
		if(finish) return;

		if(count == target) {
			if(move()) {
				finish = true;
				return;
			}
			return;
		}
		
		
		// 현재 위치부터 탐색
		for(int i = row; i <= H; i++) {
			for(int j = 1; j < N; j++) {
				if(movable[j][i] == 0 && movable[j+1][i] == 0) {
					movable[j][i] = 1;
					movable[j+1][i] = -1;
					
					backtracking(i, j, target, count + 1); 
					
					movable[j][i] = 0;
					movable[j+1][i] = 0;
				}
			}
		}
	}

		
	
	
	/*
	 * x~x+1,y에 놓을수있는지 판단
	 * 두 가로선이 연속하면안됨
	 * */
	public static boolean isPlacable(int x, int y) {
		if(movable[x][y] != 0) return false;
		if(x>1 && movable[x-1][y] != 0) return false;
		if(x+1 < N && movable[x+1][y] != 0) return false;
		return true;
	}
	
	// start라는 세로선에서 그대로 start로 도착하는지 판별
	public static boolean move() {
		for(int j=1; j<=N; j++) {
			int answer = j;
			for(int i=1; i<=H; i++) {
				// 왼쪽 이동 가능하면 왼쪽으로 이동
				if(movable[answer][i] == -1 && answer > 1) {
					answer--;
				} else if(movable[answer][i] == 1 && answer != N){
					answer++;
				}
			}
			if(answer != j) return false;
		}
		return true;
	}
	

	
	
}
