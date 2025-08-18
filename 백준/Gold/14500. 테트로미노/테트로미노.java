
import java.util.*;
import java.io.*;


public class Main {
	/*
	 * ㅗ 모양 제외하면 나머지는 depth=3의 dfs로 가능
	 * 
	 * */
	
	public static int[][] map;
	public static boolean[][] visited;
	public static int N, M;
	public static int maxSum = Integer.MIN_VALUE;
	public static int[] moveX = {0,0,-1,1};
	public static int[] moveY = {-1,1,0,0};
	
	public static void main(String args[]) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				visited[i][j] = true;
				dfs(j, i, 0, map[i][j]);
				visited[i][j] = false;
				
				etcBlock(j,i);
			}
		}
		
		
		
		
		System.out.println(maxSum);
		
	}
	
	public static void dfs(int x, int y, int depth, int sum) {
		if(depth==3) {
			if(sum > maxSum) maxSum = sum;
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nx = x+moveX[i];
			int ny = y+moveY[i];
			
			if(nx<0 || ny<0 || nx>=M || ny>=N || visited[ny][nx]) {
				continue;
			}
			
			visited[ny][nx] = true;
			dfs(nx, ny, depth+1, sum+map[ny][nx]);
			visited[ny][nx] = false;
		}	
		
	}
	
	// x, y를 가운데로 하는 ㅗ모양 블록 
	public static void etcBlock(int x, int y) {

		int cnt=1;
		int sum=map[y][x];
		int min=1001;
		
		for(int i=0; i<4; i++) {
			int nx = x+moveX[i];
			int ny = y+moveY[i];
			
			if(nx<0 || ny<0 || nx>=M || ny>=N) {
				continue;
			}
			
			cnt++;
			sum += map[ny][nx];
			if(min>map[ny][nx]) {
				min=map[ny][nx];
			}
		}
		
		

		// 놓을 수 없으면 리턴
		if(cnt<4) {
			//System.out.println("못놓음");
			return;
		}
			
		
		// 딱 한가지 모양만 만들 수 있으면
		if(cnt==4) {
			
			if(sum > maxSum) maxSum = sum;
			//System.out.println(x + " " + y + " " + "..." + sum);
			return;
		}
		
		// + 모양이 되면 min값을 뺴기
		sum -= min;
		if(sum > maxSum) maxSum = sum;
		//System.out.println(x + " " + y + " " + "..." + sum);

		return;
		
	}
	
}
