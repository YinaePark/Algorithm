
import java.io.*;
import java.util.*;

public class Main {
	/*  1. x,y좌표바꿈
	 * 2. emptyCnt=0일경우처리
	 * 
	 *
	 * */
	
	static int N, M;
	static List<int[]> emptyList = new ArrayList<>();
	static boolean[] selected;
	static int[] moveX= {0,0,-1,1};
	static int[] moveY= {-1,1,0,0};
	static int emptyCnt=0;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        char[][] map = new char[N][N];
        
        
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<N; j++) {
        		map[i][j] = st.nextToken().charAt(0);
        		if(map[i][j] == '2') {
        			emptyList.add(new int[] {j,i});
        		}
        		if(map[i][j] == '0') {
        			emptyCnt++;
        		}
        	}
        }
        
        if(emptyCnt==0) {
        	System.out.println(0);
        	return;
        }
       
        selected = new boolean[emptyList.size()];
        
        
        selectEmpty(0,0,map);
        
        System.out.println(minResult == Integer.MAX_VALUE ? -1 : minResult);
       
    }
    static int simul(char[][] map) {
    	
    	int answer=Integer.MIN_VALUE;
    	int cnt=0;

    	boolean[][] visited = new boolean[N][N];
    	ArrayDeque<int[]> q = new ArrayDeque<>();
    	
    	for(int[] p : emptyList) {
    		if(map[p[1]][p[0]] == '*') {
    			q.add(new int[] {p[0], p[1], 0});
    			visited[p[1]][p[0]] = true;
    		}
    	}
    	
    	while(!q.isEmpty()) {
    		int[] now = q.poll();
    		
    		for(int i=0; i<4; i++) {
    			int nx = moveX[i] + now[0];
    			int ny = moveY[i] + now[1];
    			int nd = now[2];
    			
    			if(nx<0 || ny<0 || nx>=N || ny>=N || visited[ny][nx]
    					|| map[ny][nx] == '1' )
    				continue;
    			
    			if(map[ny][nx] == '0' && answer < (nd+1)) {
    				answer = (nd+1);
    			}
    			if(map[ny][nx] == '0' ) {
    				cnt++;
    			}
    			// 빈칸or비화성화 바이러스인 경우
    			visited[ny][nx] = true;
    			q.add(new int[] {nx,ny,nd+1});
    			
    			
    			
    		}
    	}
    	
    	
//    	System.out.println("호출:::");
//    	for(int i=0; i<N; i++) {
//    		for(int j=0; j<N; j++) {
//    	    	System.out.print(map[i][j] + " ");
//
//    			
//    		}
//    		System.out.println();
//    	}
    	
    	
    	
    	if(cnt!=emptyCnt)
    		return -1;
    	
    	return answer;
    	
    	
    }
    
    static int minResult = Integer.MAX_VALUE;
    static void selectEmpty(int depth, int now, char[][] map) {
    	if(depth == M) {
    		int result = simul(map);
    		if(result != -1 && result < minResult)
    			minResult = result;
    		return;
    	}
    	
    	for(int i=now; i<emptyList.size(); i++) {
    		if(selected[i])
    			continue;
    		int[] point = emptyList.get(i);
    		
    		
    		map[point[1]][point[0]] = '*';
    		selected[i] = true;
    				
    		selectEmpty(depth+1, i, map);
    		
    		map[point[1]][point[0]] = '2';
    		selected[i] = false;

    	}
    }
    

}
    