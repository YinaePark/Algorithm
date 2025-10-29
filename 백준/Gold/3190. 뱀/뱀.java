
import java.io.*;
import java.util.*;

public class Main {
	/* 
	 * 틀렸던이유:
	 * 1. 0based로 바꾸지 않음
	 * 2.. 게임시작으로부터 X초가 끝난 후!!!!!!!!에 방향전한해야하는데 먼저전환했음
	 * */
	
	static int N, K, L;
	static int[][] map;
	// 상 우 하 좌 오른쪽회전=+1 왼쪽히전 -1
	static int[] moveX = {0, 1, 0, -1};
	static int[] moveY = {-1, 0, 1, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        ArrayDeque<int[]> directionQ = new ArrayDeque<>();
        map = new int[N][N];
        
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) -1; 
            int x = Integer.parseInt(st.nextToken()) -1; 
            map[y][x] = 1;
        }
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        for(int i=0; i<L; i++) {
        	st = new StringTokenizer(br.readLine());
        	int t = Integer.parseInt(st.nextToken()); 
        	char c = st.nextToken().charAt(0);
        	if(c=='L') {
        		directionQ.addLast(new int[] {t, -1});
  
        	}else {
        		directionQ.addLast(new int[] {t, 1});
        	}
        	
        }
        
        
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int nx = 0;
        int ny = 0;
        int[] head = {0,0};
        q.addFirst(head);
        int dir = 1;
        map[0][0] = 2;
        int T=0;
        
        while(true) {
        	T++;
        	nx += moveX[dir];
        	ny += moveY[dir];
        	
        	
        	if(ny<0 || nx<0 || nx>=N || ny>=N || map[ny][nx] == 2) {
        		System.out.println(T);
        		return;
        	} 
        	// 사과없다면 몸길이를 줄여서 꼬리를 비워줌
        	if(map[ny][nx] == 0) {
        		int[] tail = q.pollLast();
        		map[tail[1]][tail[0]] = 0;
        	} 
        	
        
        	//새로바뀐 head 큐에넣기
        	map[ny][nx] = 2;
        	q.addFirst(new int[] {nx, ny});
        	
        	// 시간 T에서 방향바꿈
        	if(!directionQ.isEmpty() && directionQ.peek()[0] == T) {
        		dir = (4+dir+directionQ.poll()[1])%4;
        	}
        	
        	
        }
        
        
        

     
    }
    

}

