
import java.util.*;
import java.io.*;


public class Main {
	
	// 원점 14, 14 로부터 시작하면서 탐색
	public static boolean[][] visited = new boolean[29][29];
	public static int[] moveX = {0,0,-1,1};
	public static int[] moveY = {-1,1,0,0};
	public static double[] p = new double[4];
	
	public static double result = 0;
	
	public static void main(String args[]) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		
		
		int N = sc.nextInt();
		
		
		for(int i=0; i<4; i++) {
			int e = sc.nextInt();
			p[i] = (double)e/100;	
		}
		
		visited[14][14] = true;
		dfs(N, 0, 14,14, 1);
		
		 System.out.println(result);

	}
	
	public static void dfs(int target, int depth, int x, int y, double tmpP) {
		if(target == depth) {
			// System.out.println("지금 target도달했어 "+tmpP);
			result += tmpP;
			return;
		}
		
	
		
		for(int i=0; i<4; i++) {
			if(p[i] == 0) continue;
			// System.out.println("지금 depth : " + depth + " 지금 방향 " + i);
			int nx = x+moveX[i];
			int ny = y+moveY[i];
			// 이미 방문했으면 넘기기
			if(visited[ny][nx]) continue;
			
			visited[ny][nx] = true;
			// System.out.println("p[i[ : " + p[i] + " 그리고.. " + tmpP);
			dfs(target, depth+1, nx, ny, tmpP*p[i]);
			visited[ny][nx] = false;
		}
	}
	
	
}
