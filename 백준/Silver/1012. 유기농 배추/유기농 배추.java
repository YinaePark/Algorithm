
import java.util.*;
import java.io.*;


public class Main {
	
	public static Map<Integer, List<Integer>> map = new HashMap<>();
	public static boolean[] visited;
			
	public static void main(String args[]) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		// T : 테스트케이스 개수
		// 각 T에 대해
		// M : 가로 N : 세로 K : 배추위치개수
		// K줄동안 배추의 xy
		int T = sc.nextInt();
		
		for(int testcase=1; testcase<=T; testcase++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			int[][] map = new int[n][m];
			int x, y;
			List<int[]> list = new ArrayList<>();
			
			for(int coord=0; coord<k; coord++) {
				x = sc.nextInt();
				y = sc.nextInt();
				
				int[] point = {x, y};
				list.add(point);
				map[y][x] = 1;
				
				
			}
			
			int repeat = k;
			int result = 0;
			
			
			for(int i=0; i<repeat; i++) {
				int[] point = list.get(i);
				// 방문 안했다면...
				if(map[point[1]][point[0]] == 1) {
					bfs(map, k, point, m, n);
					result++;
				}
			}
			
				
				
			
			System.out.println(result);
			
			
		}
		

	}
	
	public static int[] moveX = {0,0,-1,1};
	public static int[] moveY = {1,-1,0,0};
	// point[2] -> {x, y}
	public static void bfs(int[][] map, int k, int[] point, int m, int n) {
		int x = point[0];
		int y = point[1];
		int cnt=1;
		map[y][x] = 0;
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.add(point);
		while(!q.isEmpty()) {
			int[] now = q.poll();
			x = now[0];
			y = now[1];
			for(int i = 0; i<4; i++) {
				int nx = x+moveX[i];
				int ny = y+moveY[i];
				
				// 범위 벗어나거나 배추아니면
				if(nx<0 || ny<0 || nx>=m || ny>=n || map[ny][nx] == 0) {
					continue;
				}
				// 배추이면 count
				cnt++;
				// 배추 없애버리기
				map[ny][nx] = 0;
				int[] next = {nx, ny};
				q.add(next);
				
			}
		}
		return;
	}
	

	
	
}
