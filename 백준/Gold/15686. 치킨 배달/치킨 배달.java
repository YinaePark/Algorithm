
import java.io.*;
import java.util.*;

public class Main {
	/* 
	 *
	 * r,c : y,x이고 1부터 시작
	 * 치킨거리 = 각 1에 대해, 제일 가까운 2와의 거리들의 합
	 * 
	 * 치킨거리가 최소가 되도록 도시에 M개 2만 남기기
	 * 
	 * 치킨집 최대 13개이므로,
	 * 
	 * 1. 치킨집 좌표 리스트, 집 좌표 리스트 미리 뽑고,
	 * 2. dist[h][c] 로 거리 미리 계산
	 * 3. c 조합마다 dist[h][선택된 치킨들] 의 min 구하기
	 * 
	 * */
	
	static int N, M;
	static int[][] map, chicken, house, dist;
	static int C=0;
	static int H=0;
	static int min = Integer.MAX_VALUE;
	
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	map = new int[N][N];
    	chicken = new int[13][2];
    	house = new int[101][2];
    	
    	// 초기화
    	for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<N; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    			if(map[i][j] == 2) {
    				chicken[C][0] = j;
    				chicken[C][1] = i;
    				C++;
    			}
    			else if(map[i][j] == 1) {
    				house[H][0] = j;
    				house[H][1] = i;
    				H++;
    			}
    		}
    	}
    	
    	dist = new int[H][C];
    	for(int i=0; i<H; i++) {
    		for(int j=0; j<C; j++) {
    			dist[i][j] 
    					= Math.abs(chicken[j][0] - house[i][0]) 
    					+ Math.abs(chicken[j][1] - house[i][1]);
    		}
    		
    	}
    	
    	combination(0, new int[M], 0);
    	
    	System.out.println(min);
    	
    	
    }
    
    // 치킨 중 M개 조합 돌리기
    // cnt : 고른 개수
    // idx : 현재
    public static void combination(int start, int[] comb, int cnt) {
    	if(cnt == M) {
    		simul(comb);
    		
    		return;
    	}
    	
    	for(int i=start; i<C; i++) {
    		comb[cnt] = i;
    		combination(i+1, comb, cnt+1);
    	}
    	
    	
    }
    
    public static void simul(int[] comb) {
    	// 모든 집에 대해, 선택된 치킨과 거리 중 최소를 업뎃
    	int sum = 0;
    	
    	for(int i=0; i<H; i++) {
    		int tmpMin = Integer.MAX_VALUE;
    		// 선택된 치킨들과의 거리 비교
    		for(int j=0; j<M; j++) {
    			if(tmpMin > dist[i][comb[j]]) {
    				tmpMin = dist[i][comb[j]];
    			}
    		}
    		sum += tmpMin;
    	}
    	
    	
    	if(min > sum) {
    		min = sum;
    	}
    }

}
