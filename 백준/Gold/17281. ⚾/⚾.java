
import java.util.*;
import java.io.*;


public class Main {
	/*
	 * N = 50,
	 * 1번선수는 4번쨰로 고정, 
	 * 가장 많은 득점 타순 찾기 
	 * 순열 완탐시.. 8! = 40,320
	 * 
	 * 모든 이닝에서 고정순서, 이닝끝나도 순서 유지
	 * 
	 * */
	public static int[][] scores;
	public static boolean[] visited = new boolean[9];
	public static int inning;
	public static int max = 0;
	
	public static int[] order = new int[9];
	
	public static void main(String args[]) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		inning = Integer.parseInt(br.readLine());
		scores = new int[inning][9];
		
		
		// 입력 
		for(int in = 0; in<inning; in++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				scores[in][j] = Integer.parseInt(st.nextToken());
			}			
		}
		
		visited[0] = true;
		order[3] = 0;
		dfs(0);
		System.out.println(max);
				
	}
	
	public static void dfs(int depth) {	
		if(depth == 9) {
			
			updateScore(order);
			

			return;
		}
		
		if(depth == 3) {
			dfs(depth + 1);
			return;
		}
		
		for(int i=1; i<9; i++) {
			if(!visited[i]) {
			
				visited[i] = true;
				order[depth] = i;
				dfs(depth+1);
				visited[i] = false;
			}
		}
		
		
	}
	
	public static void updateScore(int[] o) {
		
		int loop = 0;
		int now = 0;
		int out = 0;
		int score = 0;
		// 홈 :0, 1, 2, 3루
		boolean[] field = new boolean[4];
		
		while(loop < inning) {
			// 삼진아웃시 다음 선수부터, 다음 이닝으로 이동
			if(out == 3) {
				loop++;
				out=0;
				Arrays.fill(field, false);
				continue;
			}
			
			// 현재 주자가 현재 이닝에서 뭘 쳤느지
			// o[now] : 현재 순서인 선수번호
			int tmp = scores[loop][o[now]];
			field[0] = true;

//			if(o[0] == 1 && o[1] == 2 && o[2] == 3)
//				System.out.println("현재 이닝, 선수 : " + (loop+1) +" "+ o[now]);
			
			/*  각 경우 score 계산 */
			// 아웃일 경우
			if(tmp==0) {
				out++;
				
			}
			// 안타 > 1루씩 이동
			else if(tmp==1) {
				if(field[3]) score++;
				// 한칸씩 밀기
				for(int i=2; i>=1; i--) {
					field[i+1] = field[i];
				}
				field[1] = true;
				
				
			}
			// 2루타
			else if(tmp==2) {
				// 2,3루는 홈 들어감
				if(field[3]) {
					score++;
					field[3] = false;
				} 
				if(field[2]) {
					score++;
					field[2] = false;
				}
				
				// 1>3루 자리 업데이트
				if(field[1]) {
					field[3] = true;
				}
				field[1] = false;
				// 타자 자리
				field[2] = true;
			}
			
			// 3루타
			else if(tmp==3) {	
				// 1,2,3루 모두 골인...
				for(int i=1; i<4; i++) {
					if(field[i]) {
						score++;
						field[i] = false;
					} 
				}
				// 타자 이동
				field[3] = true;
				
			}
			
			// 홈런
			else if(tmp==4) {
				for(int i=0; i<4; i++) {
					if(field[i]) {
						score++;
						field[i] = false;
					} 
					
				}
			}
			
			now = (now+1)%9;
			
			
		}
		
		if(score>max) {
//			for(int i : o) {
//				System.out.print(i + " ");
//			}
//			System.out.println("socre; : " + score);
			max=score;
		} 
		return;
	}
	

		
	
}
