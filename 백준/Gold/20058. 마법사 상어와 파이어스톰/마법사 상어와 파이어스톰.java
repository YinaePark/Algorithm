
import java.io.*;
import java.util.*;

public class Main {
	/* 
	 * 1. 한변 2^N인데, 
	 * 2. 단계 L마다 한변2^L인 부분격자로 나누고, 그 부분격자를 시계방향90도회전
	 *    그담에 얼음있는 칸3개이상과 인접해있지 않ㅇ느 칸은(모서리같은거..) 얼음이 1 줄어든다.
	 * 
	 * 특이사항 :
	 * - System.arraycopy(src, src시작위치, dest, dest시작위치, 길이);
	 * - chunk가 1씩 크게나오는괴기스러운현상... -> finalCnt함수에서 bfs 호출할떄 0아닌것만호출
	 * - --할때 0이면 --안하게처리해야함
	 * */
	
	static int N, Q;
	static int[] moveX = {0,0,-1,1};
	static int[] moveY = {-1,1,0,0};
	
	static int[][] map;
	static boolean[][] visited;
	static int chunk = 0;
	static int tot = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken()); // Q : 몇단곈지
		
		int sideLen = 1<<N;
		
		map = new int[sideLen][sideLen];
		visited = new boolean[sideLen][sideLen];
		
		// map입력받기
		for(int i=0; i<sideLen; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<sideLen; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int level=0; level<Q; level++) {
			
			int L = Integer.parseInt(st.nextToken());
			int unitLen = 1<<L;
			int t = sideLen/unitLen;
			// 시계방향스핀
			for(int i=0; i<t; i++) {
				for(int j=0; j<t; j++) {
					spin(sideLen, unitLen, i*unitLen ,j*unitLen);
				}
			}
			// 인접 안한 칸은 얼음 -1
			updateIce(sideLen);

		}
		
		// 얼음 덩어리크기, 남은 얼음 합
		finalCnt(sideLen);
		
		System.out.println(tot);
		System.out.println(chunk);

	} 
	
	static void finalCnt(int sideLen) {
		for(int i=0; i<sideLen; i++) {
			for(int j=0; j<sideLen; j++) {
				if(!visited[i][j] && map[i][j] != 0) {
					bfs(j,i,sideLen);
				}
			}
		}
	}
	
	static void bfs(int x, int y, int sideLen) {
		int tmpCnt=1;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		visited[y][x] = true;
		tot += map[y][x];
		q.add(new int[] {x,y});
		
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
		
			x = now[0];
			y = now[1];
			
			for(int d=0; d<4; d++) {
				int nx = moveX[d] + x;
				int ny = moveY[d] + y;
				
				if(nx<0 || ny<0 || nx>=sideLen || ny>=sideLen 
						|| visited[ny][nx] || map[ny][nx]==0) continue;

				visited[ny][nx] = true;
				tmpCnt++;
				tot += map[ny][nx];
				q.add(new int[] {nx, ny});
			}
		}
		
		// 젤큰덩어리 업데이트
		if(chunk < tmpCnt) chunk = tmpCnt;
		
	}
	
	
	// x, y : 회전시작할 유닛사각형의 0,0
	static void spin(int sideLen, int unitLen, int x, int y) {

		// 먼저 원본을 unit에 복사 후, unit을 회전해서 원본수정
		int[][] unit = new int[unitLen][unitLen];
		for(int j=0; j<unitLen; j++) {
			System.arraycopy(map[y+j], x, unit[j], 0, unitLen);	
		}
		
		// 회전 : y=i인 줄을 x=(unitLen-i-1) 줄로 옮기기
		for(int i=0; i<unitLen; i++) {
			for(int j=0; j<unitLen; j++) {
				map[y + j][x + unitLen-i-1] = unit[i][j];
			}
		}
		
		
	}
	
	static void updateIce(int sideLen) {
		List<int[]> minus = new ArrayList<>();
		for(int i=0; i<sideLen; i++) {
			for(int j=0; j<sideLen; j++) {
				int aroundCnt=0;
				for(int d=0; d<4; d++) {
					int nx = moveX[d] + j;
					int ny = moveY[d] + i;
					
					if(nx<0 || ny<0 || nx>=sideLen || ny>=sideLen) continue;
					
					if(map[ny][nx] != 0) aroundCnt++;
				}
				
				if(aroundCnt<3 && map[i][j] != 0) minus.add(new int[] {j,i});
				
			}
			
		}
		
		for(int[] num : minus) {
			map[num[1]][num[0]]--;
		}
	}

}
