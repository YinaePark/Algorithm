
import java.util.*;
import java.io.*;


public class Main {
	/*
	 * 완탐가능 
	 * */
	
	public static int N,M;
	public static char[][] map;

	
	public static void main(String args[]) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		// 입력받기 
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i] = st.nextToken().toCharArray();
		}
		
		int answer = Integer.MAX_VALUE;

		for(int row=0; row<=N-8; row++) {
			for(int col=0; col<=M-8; col++) {
				// 다음의 최솟값 찾아야함 
				int bwDiffCnt=0;
				int wbDiffCnt=0;
				
				// 0,0 ~ 7,7
				for(int i=0; i<8; i++) {
					for(int j=0; j<8; j++) {
						if((row+col+i+j)%2 == 0) {
							if(map[i+row][j+col] == 'B') {
								wbDiffCnt++;
							} else {
								bwDiffCnt++;
							}
						} else {
							if(map[i+row][j+col] == 'B') {
								bwDiffCnt++;
							} else {
								wbDiffCnt++;
							}
						}
						
					}
				}
//				System.out.println(bwDiffCnt + " " + wbDiffCnt);
				int tmp = Math.min(bwDiffCnt, wbDiffCnt);
				answer = answer < tmp ? answer : tmp;
				
			}
		}
		
		System.out.println(answer);
		
	}
}
