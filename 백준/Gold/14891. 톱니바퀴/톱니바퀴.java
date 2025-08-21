
import java.util.*;
import java.io.*;


public class Main {
	/*
	 * 
	 * 
	 * */
	
	public static boolean[][] wheel = new boolean[4][8];;
	public static boolean[] visited = new boolean[4];
	
	public static void main(String args[]) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// [바퀴번호][톱니번호]
		// N극 : 0, S극: 1
		// 시계방향 : +1, 반시계 : -1
		// 왼쪽과 맞닿은 부분 : 6
		// 오른쪽과 맞닿은 부분 : 2
		
		for(int i=0; i<4; i++) {
			String input = br.readLine();
			for(int j=0; j<input.length(); j++) {
				wheel[i][j] = (input.charAt(j) == '1');
				
			}

		}
		
		st = new StringTokenizer(br.readLine());
		int command = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<command; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());
			// 톱니번호 1부터시작해서 하나씩빼줌
			visited = new boolean[4];
			spin(start-1, direction);
		}
		
		int answer = 0;
		// 점수계산
		for(int i=0; i<4; i++) {
			if(wheel[i][0]) {
				answer += (1<<i);
			}
		}
		
		System.out.println(answer);
		
				
	}
	
	
	// direction 
	public static void spin(int startIdx, int direction) {
		
		visited[startIdx] = true;
		
		// 왼쪽 
		if(startIdx-1 >= 0 && !visited[startIdx-1] && (wheel[startIdx-1][2] != wheel[startIdx][6])) {
			spin(startIdx-1, (direction * -1));
		}
		
		// 오른쪽
		if(startIdx+1 < 4 && !visited[startIdx+1] && (wheel[startIdx+1][6] != wheel[startIdx][2])) {
			spin(startIdx+1, (direction * -1));
		}
		
		// 한바퀴 회전
		
		if(direction == 1) {
			boolean tmp = wheel[startIdx][7];
			for(int i=7; i>0; i--) {
				wheel[startIdx][i] = wheel[startIdx][i-1];
			}
			wheel[startIdx][0] = tmp;
		} else {
			boolean tmp = wheel[startIdx][0];
			for(int i=1; i<8; i++) {
				wheel[startIdx][i-1] = wheel[startIdx][i];
			}
			wheel[startIdx][7] = tmp;
		}
		
		return;
	}
 
		
	
}
