
import java.util.*;
import java.io.*;


public class Main {
	
	/*
	 * 
	 * 
	 * */	
	public static int[] moveX = {0,0,-1,1};
	public static int[] moveY = {-1,1,0,0};
	public static char[][] map;
	public static int N;
	
	public static boolean[][] visited;
	
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> cntList = new ArrayList<>();
		
		N = Integer.parseInt(st.nextToken());
		visited = new boolean[N][N];
		map = new char[N][N];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		}
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == '1' && !visited[i][j]) {
					cntList.add(bfs(new int[] {j,i}));
				}
			}
		}
		
		Collections.sort(cntList);
		System.out.println(cntList.size());
		for(int n : cntList) {
			System.out.println(n);
		}
		
	}
	
	public static int bfs(int[] start) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.add(start);
		visited[start[1]][start[0]] = true;
		int cnt=0;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			cnt++;
			
			for(int i=0; i<4; i++) {
				int nx = moveX[i] + now[0];
				int ny = moveY[i] + now[1];
				
				if(nx<0 || ny<0 || nx>=N || ny>=N
						|| visited[ny][nx] || map[ny][nx] == '0') continue;
				
				visited[ny][nx] = true;
				q.add(new int[] {nx, ny});
			}
		}
		
		return cnt;
	}
	
}
