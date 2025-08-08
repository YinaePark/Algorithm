
import java.util.*;
import java.io.*;


public class Main {
	public static int moveX[] = {0,-1,0,1};
	public static int moveY[] = {-1,0,1,0};
	public static int N;
	public static int[][] map;
	public static boolean[][] visited;
	
	
	public static void main(String args[]) throws Exception{
		int[] start = new int[] {0,0,-1};
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		
		// j=x i=y
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int tmp = sc.nextInt();
				map[i][j] = tmp;
				if(tmp==9) {
					start= new int[] {j,i};
					map[i][j] = 0;
				}
					
			}
		}
		
		int result = 0;
		int[] sharkSize = {2,0};
		
		// x, y, time
		int[] end = {start[0], start[1], 0};
		while(end[0] != -1) {

			end = smallBfs(end, sharkSize);
		    if (end[0] == -1) break; // 먹을 물고기 없으면 종료

			result += end[2];
//			System.out.println("result, time: " + result + " " + end[2]);
//			System.out.println("다음시작위치(물고기먹은위치): " + end[0] + " " + end[1]);
			
			sharkSize[1]++;
			if(sharkSize[1] == sharkSize[0]) {
				sharkSize[1] = 0;
				sharkSize[0]++;
//				System.out.println("물고기사이즈가 업그레이드 : " + sharkSize[0]);
				
			}
			
			end[2] = 0;
			
		}
		
		
//		System.out.println(end[0] + "... " + end[1]);
		System.out.println(result);
		
		sc.close();
		
	}
	// sharkSize = {2, 1} -> 상어크기는 2, 2인 상태에서 지금까지 물고기 1마리먹음
	// start : {x, y, time}
	public static int[] smallBfs(int[] start, int[] sharkSize) {
	    visited = new boolean[N][N];
	    ArrayDeque<int[]> q = new ArrayDeque<>();
	    q.add(new int[] {start[0], start[1], 0});  // x, y, dist
	    visited[start[1]][start[0]] = true;

	    List<int[]> candidate = new ArrayList<>();
	    boolean isFound = false;

	    while (!q.isEmpty()) {
	        int qSize = q.size();

	        for (int i = 0; i < qSize; i++) {
	            int[] s = q.poll();
	            int x = s[0], y = s[1], dist = s[2];

	            // 먹을 수 있는 물고기 발견
	            if (map[y][x] != 0 && map[y][x] < sharkSize[0]) {
	                candidate.add(s);
	                isFound = true;
	            }

	            // 후보 찾은 후에는 다음 노드 탐색 안 함 (같은 레벨만 후보 모으기 위함)
	            if (isFound) continue;

	            for (int d = 0; d < 4; d++) {
	                int nx = x + moveX[d];
	                int ny = y + moveY[d];

	                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
	                if (visited[ny][nx]) continue;
	                if (map[ny][nx] > sharkSize[0]) continue;

	                visited[ny][nx] = true;
	                q.add(new int[] {nx, ny, dist + 1});
	            }
	        }

	        if (isFound) {
	            // 후보 중에서 가장 위쪽(y가 가장 작은), 왼쪽(x가 가장 작은) 우선으로 정렬 후 첫 번째 반환
	            candidate.sort((a, b) -> {
	                if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
	                return Integer.compare(a[0], b[0]);
	            });

	            int[] fish = candidate.get(0);
	            map[fish[1]][fish[0]] = 0;  // 먹은 자리 비우기
	            return fish;
	        }
	    }

	    // 물고기 못 찾으면 종료 신호
	    return new int[] {-1, -1, 0};
	}

	
}
