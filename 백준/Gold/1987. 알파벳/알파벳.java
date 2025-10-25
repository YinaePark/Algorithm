
import java.io.*;
import java.util.*;

public class Main {
	/*
	 * 
	 * */
    static int Y, X;
    static char[][] map;
    static int max=0;
    static boolean[] visited = new boolean[26];
    static int[] moveX = {0,0,-1,1};
    static int[] moveY = {-1,1,0,0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
  
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        map = new char[Y][X];
        for(int i=0; i<Y; i++) {
        	String str = br.readLine();
        	map[i] = str.toCharArray();
        }
        
        visited[map[0][0] - 'A'] = true;
        
        bt(0,0,0);
        System.out.println(max);
        
    }
    
    static void bt(int x, int y, int depth) {
//    	System.out.println(map[y][x]);
    	boolean flag=false;
    	
    	for(int i=0; i<4; i++) {
    		int nx = x + moveX[i];
    		int ny = y+ moveY[i];
    		
    		if(nx<0||ny<0||nx>=X||ny>=Y||
    				visited[map[ny][nx] - 'A'])
    			continue;
    		
    		// 갈수있으면 flag = true로바꾸고 재귀호출
    		flag = true;
    		visited[map[ny][nx] - 'A'] = true;
    		bt(nx, ny, depth+1);
    		visited[map[ny][nx] - 'A'] = false;
    	}
    	// 더이상 갈곳없으면
    	if(!flag) {
    		if(max < depth+1)
    			max = depth+1;
    	}
    }
}