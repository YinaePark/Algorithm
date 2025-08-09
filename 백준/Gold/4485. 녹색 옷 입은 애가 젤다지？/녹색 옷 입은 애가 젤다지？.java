
import java.util.*;
import java.io.*;


public class Main {
	/*
	 * 다익스트라 알고리즘: 시작노드~각노드까지 거리를 INF로 초기화
	 * start로부터 현재 가장 적은 비용으로 갈수있는 노드 선택
	 * 현재 선택된 노드에 대해, 해당 노드를 거쳐서 각 노드까지 가는 최소 비용과 현재까지 구한 최소 비용을 비교하여, 갱신
	 * 
	 * start : 0,0
	 * end : n-1, n-1
	 * */
	
	public static int moveX[] = {0,-1,0,1};
	public static int moveY[] = {-1,0,1,0};
	
	
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int cnt = 1;
		
		while(N != 0) {
			int[][] map = new int[N][N];
			int[][] dist = new int[N][N];
			
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
					
				}
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			
			// 다익스트라
			// pq에 저장되는 정보 : int[3] = {x, y, dist}
			// dist 작은순 정렬하는 pq 
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
			pq.add(new int[] {0,0,0});
			dist[0][0] = map[0][0];
			
			while(!pq.isEmpty()) {
				int[] now = pq.poll();
				int x=now[0];
				int y=now[1];
				int nowDist = now[2];
				
				// 현재 기록한 노드거리가 큐에서 가져온 거리보다 크면
				// 이미 최적화되었으므로 쓸모없는경로임
				if(dist[y][x] < nowDist) {
					continue;
				}
				
				// 인접 노드들(상하좌우)에 대해,
				for(int i=0; i<4; i++) {
					int nx = x+moveX[i];
					int ny = y+moveY[i];
					
					if(nx<0 || ny<0 || nx>=N || ny>= N) continue;
					
					// now를 경유해서 next.dest로 가는게
					// 기존 기록한 next의 dist보다 더 짧으면 갱신 
					if(dist[ny][nx] > nowDist+map[ny][nx]) {
						dist[ny][nx] = nowDist+map[ny][nx];
						pq.add(new int[] {nx, ny, dist[ny][nx]});
					}
					

				}
		
			}
			System.out.println("Problem " + cnt + ": " + (dist[N-1][N-1]+map[0][0]));
			cnt++;
			N = sc.nextInt();
	
		}
	}
}
