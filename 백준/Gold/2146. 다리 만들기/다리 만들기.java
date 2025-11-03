
import java.io.*;
import java.util.*;

public class Main {
	/* 
	 * 지도넓이 100*100
	 * 
	 * 0은 바다, 1은 육지
	 * 
	 * */
	
	static int N;
	static int[][] map;
	static int[] moveX = {0,0,-1,1};
	static int[] moveY = {-1,1,0,0};
	static boolean[][] visited;
	static int min = 111111;
	
	
	
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       
       N = Integer.parseInt(st.nextToken());
       map = new int[N][N];
       visited = new boolean[N][N];
       for(int i=0; i<N; i++) {
    	   st = new StringTokenizer(br.readLine());
    	   for(int j=0; j<N; j++) {
        	   map[i][j] = Integer.parseInt(st.nextToken());
           }
       }
       
       int cnt = 2;
       // 다른 육지 표시
       for(int i=0; i<N; i++) {
    	   for(int j=0; j<N; j++) {
    		   if(map[i][j] == 1 && !visited[i][j]) {
    			   bfs(j,i,cnt);
    			   cnt++;
    		   }
    		   
    		  
           }
       }
       
       

       for(int c = 2; c<cnt; c++) {
    	   getBridge(c);
       }
       
       System.out.println(min);
      
       
       
    }
    
    static void getBridge(int color) {
    	ArrayDeque<int[]> q = new ArrayDeque<>();
    	boolean[][] check = new boolean[N][N];

    	
    	for(int i=0; i<N; i++) {
     	   for(int j=0; j<N; j++) {
     		   if(map[i][j] == color) {
     			  q.add(new int[] {j,i,0});
     			  check[i][j] = true;

     		   }
     		   
     		  
            }
        }
    	
    	while(!q.isEmpty()) {
    		int[] now = q.poll();
    		
    		for(int i=0; i<4; i++) {
    			int nx = moveX[i] + now[0];
    			int ny = moveY[i] + now[1];
    			int nd = now[2];
    			
    			// 범위벗어나거나, 같은 섬이면
    			if(nx<0 || ny<0|| nx>=N || ny>=N || check[ny][nx]
    					|| map[ny][nx] == color)
    				continue;
    			
    			// 만약 다른 섬에 도착했다면, dist를 min과 비교후 반환
    			if(map[ny][nx] > 1 && map[ny][nx] != color) {
    				if(min > nd) { 
    					min = nd;
    				}
    				
    			}
    			
    			// 바다라면 dist++ 후 방문처리
    			if(map[ny][nx] == 0) {
    				
    				nd++;
    				check[ny][nx] = true;
        			q.add(new int[] {nx, ny, nd});
    			}
    			
    			
    				
    		
    			
    			
    		}
    	}
    	
    }
    
    
    static void bfs(int x, int y, int color) {
    	ArrayDeque<int[]> q = new ArrayDeque<>();
    	visited[y][x] = true;
    	map[y][x] = color;
    	q.add(new int [] {x,y});
    	
    	while(!q.isEmpty()) {
    		int[] now = q.poll();
    		
    		for(int i=0; i<4; i++) {
    			int nx = moveX[i] + now[0];
    			int ny = moveY[i] + now[1];
    			
    			if(nx<0 || ny<0|| nx>=N || ny>=N || visited[ny][nx]
    					|| map[ny][nx] == 0)
    				continue;
    			visited[ny][nx] = true;
    			map[ny][nx] = color;
    			q.add(new int[] {nx, ny});
    			
    		}
    	}
    }
    

}

