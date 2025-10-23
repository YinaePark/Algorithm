
import java.io.*;
import java.util.*;

public class Main {
	/* 
	 * 플로이드와샬:모든점<>모든 점 
	 * 초기화시 자기자신=0, 오버플로주의
	 * n^3
     틀린부분:
     출력형식(마지막에 공백뺴고괄호)
	 * * */

	static int N, M;
	static int[][] minCost;

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		
		minCost = new int[N][N];
		for(int i=0; i<N; i++) {
			Arrays.fill(minCost[i], Integer.MAX_VALUE);
			minCost[i][i] = 0;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(minCost[s-1][e-1] > c) {
				minCost[s-1][e-1] = c;
			}
			
		}
		
		
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(minCost[i][k]==Integer.MAX_VALUE || minCost[k][j]==Integer.MAX_VALUE)
						continue;
					
					if(minCost[i][j] > minCost[i][k] + minCost[k][j]) {
						minCost[i][j] = minCost[i][k] + minCost[k][j];
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append((minCost[i][j]==Integer.MAX_VALUE?0 : minCost[i][j]) + " ");
				 
			}
			sb.append("\n");
			
		}
		System.out.print(sb.toString());
	}
	
	
	
}
