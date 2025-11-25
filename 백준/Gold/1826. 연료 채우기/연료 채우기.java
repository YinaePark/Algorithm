
import java.io.*;
import java.util.*;

public class Main {
	/* 
	 * 1km당 -1
	 * N개주유소중 멈추는 수 최소화하기
	 * 1.현재연료를 다쓸때까지 달리고, 지나온 주유소는 pq에 넣기
	 * 2. 연료다쓰는 순간, 큐에서 제일 주유가능 연료 많은 놈만큼 주유한다.
	 * 3. 연료가 0이될때 큐가 비어있으면 갈수없는 것임
	 * 
	 * */
	
	static int N, dest, remain;
	// 
	static int[][] station;
	
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	station = new int[N][2];
    	for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		station[i][0] = Integer.parseInt(st.nextToken());
    		station[i][1] = Integer.parseInt(st.nextToken());
    		
    	}
		st = new StringTokenizer(br.readLine());
    	dest = Integer.parseInt(st.nextToken());
    	remain = Integer.parseInt(st.nextToken());

		// 가까이있는 순 정렬
    	Arrays.sort(station, (a,b)->(a[0]-b[0]));
    	// 연료 많이채울수있는 순 정렬
    	PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(b[1]-a[1]));
    	
    	int result = 0;
    	int idx=0;
    	for(int i=0; i<dest; i++) {
    		// 현재 갈 수 있는 주유소인지 판별(같은위치에 주유소 여러개일수도)
    		// a:거리(위치) b:거기서 채울수있는양
    		while (idx < N && station[idx][0] <= i) {
    		    pq.add(station[idx]);
    		    idx++;
    		}
    		
    		// 연료 0될때까지 
    		if(remain > 0) {

    			remain--;
    			continue;
    		}
    		
    		// 연료 0되는순간 pq에서 채우기
    		if(pq.isEmpty()) {
    			System.out.println(-1);
    			return;
    		}
    		int[] s = pq.poll();
    		result++;

    		remain += s[1];
			remain--;


    		
    		
    	}
    	System.out.println(result);
    	
    	
    }
    

}
