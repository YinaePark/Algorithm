
import java.util.*;
import java.io.*;


public class Main {
	/*
	 * 인접한 7개선택하는 조합수, 이때, 이다솜파가 4명 이상있어햐마
	 *
	 * 
	 * */
	
	static int[] moveX = {0,0,1,-1};
	static int[] moveY = {-1,1,0,0};
	
	// 어떤파인지 저장
	static boolean[][] isDasom = new boolean[5][5];
	
	
	static boolean[] visited = new boolean[25];
	static int[] comb = new int[7];
	static int answer = 0;

	public static void main(String args[]) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		
		for(int i=0; i<5; i++) {
			String str = br.readLine();
			for(int j=0; j<5; j++) {
				if(str.charAt(j) == 'S') {
					isDasom[i][j] = true;
				}
				
			}
		}
		
		
		
		bt(0,0);
		
		System.out.println(answer);
		
	}
	
	// 25개중에 7개 선택
	
	static void bt(int depth, int now) {
		if(depth == 7) {
			// answer 업데이트
			if(isPossible()) answer++;
			return;
		}
		
		
		
		for(int i=now; i<25; i++) {
			int x = i%5;
			int y = i/5;
			if(visited[i]) continue;
			
			visited[i] = true;
			comb[depth] = i;
			
			bt(depth+1, i);
			visited[i] = false;
			
		}
		
		
	}
	
	// 인접되어있는지, 이다솜파 4명 이상인지 확인
	static boolean isPossible() {
		
		// 4명 이상인지 확인
		int dasomCnt=0;
		for(int i=0; i<7; i++) {
			int xx = comb[i]%5;
			int yy = comb[i]/5;
			if(isDasom[yy][xx]) dasomCnt++;
		}
		if(dasomCnt < 4) return false;
		
		
		// 인접인지 확인, cnt는 bfs로 연결된 점 개수
		boolean[][] bfsVisited = new boolean[5][5];
		int cnt = 1;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		int x = comb[0]%5;
		int y = comb[0]/5;
		q.add(new int[] {x, y});
		bfsVisited[y][x] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			x = now[0];
			y = now[1];
		
			
			for(int i=0; i<4; i++) {
				int nx = x + moveX[i];
				int ny = y + moveY[i];
				if(nx<0 || ny<0 || nx>=5 || ny>=5 || bfsVisited[ny][nx])
					continue;
				
				// 선택된점이 bfs로 연결되어있을경우 q에 추가하고 cnt++
				if(visited[ny*5 + nx]) {
					bfsVisited[ny][nx] = true;
					q.add(new int[] {nx, ny});
					cnt++;
				}
				
			}
		}
		
		
		if(cnt != 7) return false;
		return true;
		
	}
	
}

