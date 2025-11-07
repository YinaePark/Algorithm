
import java.io.*;
import java.util.*;

public class Main {
	/* 
	 * 최단거리가아니라 켤수있는 모든 방의 스위치수이므로 ..
	 * 한방에 여러개의 스위치가 있을수있고, 하나의 불을 조절하는스위치도 여러개잇을수있음
	 * 
	 * 문제: 불을 켰을 때, 상태에 따라 visited가 달라진다
	 * 다른 문제에서는 visited를 3차원으로해서 state를 체크했는데 경우의 수가 너무많음
	 * 해결법:
	 * 스위치를 하나라도 켜면 다시 0,0으로 가서 탐색 (vistied 초기화)
	 * =========
	 * 처음에 시간초과난이유
	 * 1.0,0을 무조건방문하고, 방문한방은 visited상관없이 스위치매번 켜기때문에 bfs가 무한루프돔
	 * 안 켠 방을 새로켰을때만 true되도록 
	 * */
	
	static int N, M;
	static int [][] map;
	static List<Integer>[][] btns;
	static int[] moveX = {0,0,1,-1};
	static int[] moveY = {-1,1,0,0};
	
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
    
       N = Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());
       
       btns = new List[N][N];
       for(int i=0; i<N; i++) {
    	   for(int j=0; j<N; j++) {
    		   btns[i][j] = new ArrayList<>();
    	   }
       }
       map = new int[N][N];
    		   
    		   
       for(int i=0; i<M; i++) {
    	   st = new StringTokenizer(br.readLine());
    	   // x,y 방에서 a,b 방의 불을 
    	   int x=Integer.parseInt(st.nextToken()) -1;
    	   int y=Integer.parseInt(st.nextToken()) -1;
    	   int a=Integer.parseInt(st.nextToken()) -1 ;
    	   int b=Integer.parseInt(st.nextToken()) -1;
    	   
    	   btns[y][x].add((b*N + a));
       }
       
      
       map[0][0] = 1;

       while(true) {
    	   boolean flag = bfs();
    	   if(!flag)
    		   break;
       }
       
       int cnt = 0;
       for(int i=0; i<N; i++) {
    	   for(int j=0; j<N; j++) {
    		   if(map[i][j] == 1)
    			   cnt++;
    	   }

       } 
       
       System.out.println(cnt);
       
    }
    
    static boolean bfs() {
    	 boolean[][] visited = new boolean[N][N];
    	 ArrayDeque<int[]> q = new ArrayDeque<>();
         visited[0][0] = true;
         q.add(new int[] {0,0});
         // 불켜기
         boolean flag=false;
         
         
         while(!q.isEmpty()) {
      	   int[] now = q.poll();
      	   
      	// 현재 위치에서 누를 수 있는 모든 버튼 활성화
  		   for(int turnOn : btns[now[1]][now[0]]) {
  			   int ty = turnOn/N;
  			   int tx = turnOn%N;
  			   
  			   if(map[ty][tx] == 0) {
  				 map[ty][tx] = 1;
    			   flag=true; 
  			   }
  			   
  		   }  		   
  		   

      	   
      	   for(int i=0; i<4; i++) {
      		   int nx = now[0] + moveX[i];
      		   int ny = now[1] + moveY[i];
      		   
      		   if(nx<0 || ny<0 || nx>=N || ny>=N || visited[ny][nx] || map[ny][nx] == 0)
      			   continue;
      		   visited[ny][nx] = true;

      		   q.add(new int[] {nx,ny});
      	   }
         }
         
         if(flag) {
  			 return true; 
  		 }
  			   
         // 더이상 불 켤게 없으면
         return false;
    }
    

}

