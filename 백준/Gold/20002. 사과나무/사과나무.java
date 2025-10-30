
import java.io.*;
import java.util.*;

public class Main {
	/* 
	 * 2차원 누적합!!! 
	 * ps[i][j] = 0,0~j,i까지의 누적합
	 * */
	
	static int N;
	static int[][] map;
	static int[][] ps;
	
	static int max = Integer.MIN_VALUE;
	
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        
        map = new int[N+1][N+1];
        ps = new int[N+1][N+1];
        
        for(int i=1; i<=N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=1; j<=N; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		// 위쪽부분 + 왼쪽부분 + 현재mpa값 - 위&왼쪽 겹치는부분
        		ps[i][j] = ps[i][j-1] + ps[i-1][j] - ps[i-1][j-1] + map[i][j];
        	}
        }
        
        for(int k=1; k<=N; k++) {
        	for(int i=k; i<=N; i++) {
        		for(int j=k; j<=N; j++) {
        			int sum = ps[i][j] - ps[i-k][j] - ps[i][j-k] + ps[i-k][j-k];
        			if(sum > max) max = sum;
        		}
        	}
        }
        
       
        System.out.println(max);
    }
    

    

}

