

import java.util.*;
import java.io.*;


public class Main {
	/*
	 * 0,0 > w-1,h-1
	 * 총 K번만 말의움직임 가능,
	 * 그 외에는 인접칸으로만 움직임 가능(사방)
	 * */
	static int K, W, H;
	
	//0~3까지는 인접칸 4~11까지는 말의 움직임
	static int[] moveX = {0,0,-1,1, -2,-1,1,2,2,1,-1,-2};
	static int[] moveY = {-1,1,0,0, -1,-2,-2,-1,1,2,2,1};
	
	static boolean[][][] visited;
	
	static int[][] map;
	
	public static void main(String args[]) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		visited = new boolean[H][W][K+1];
		
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++) {
				map[i][j] =  Integer.parseInt(st.nextToken());
			}
		}
		
		int depth=0;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		visited[0][0][0] = true;
		q.add(new int[] {0,0,0});
		
		while(!q.isEmpty()) {
			
			int qSize = q.size();
			for(int i=0; i<qSize; i++) {
				
				
				int[] now = q.poll();
				int x = now[0];
				int y = now[1];
				int state = now[2];
				
				
				if(x == W-1 && y == H-1) {
					System.out.println(depth);
					return;
				}
				
				for(int j=0; j<12; j++) {
					int nx = x + moveX[j];
					int ny = y + moveY[j];
					int ns = state;
					
					// 말의 움직임 가능한지 확인, 가능하면 
					if(j>=4) {
						if(ns >= K) break;
						ns++;
					}
					
					if(nx<0 || ny<0 || nx>=W || ny>=H 
							|| visited[ny][nx][ns] 
							|| map[ny][nx] == 1) continue;
					
					
					visited[ny][nx][ns] = true;
					q.add(new int[] {nx, ny, ns});
					
					
				}
			}
			depth++;

			
		}
		
		System.out.println(-1);
		
	
		
		
	}
	
	
	
	
	
}
