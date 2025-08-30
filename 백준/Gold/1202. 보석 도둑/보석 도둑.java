

import java.util.*;
import java.io.*;


public class Main {
	/*
	 * 
	 * 3 * 10^5 >> O(NlogN) 
	 * dp로는 터짐
	 * 
	 * */
	static int N, K;
	static int[][] jw;
	static long[] C;
	
	public static void main(String args[]) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		C = new long[K];
		jw = new int[N][2];

		
		// 보석 무게, 가격 입력
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			jw[i][0] = m;
			jw[i][1] = v;
		}
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			C[i] = Long.parseLong(st.nextToken());
			
		}
		
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o2[1] - o1[1]));

		
		Arrays.sort(jw, ((o1, o2) -> o1[0] - o2[0]));
		Arrays.sort(C);
		
		long answer = 0;
		/*
		 * 보석을 가벼운것부터 시도
		 * 가방을 작은것부터 시도
		 * 현재 가방에 넣을 수 있는 보석을 모두 후보에 넣고, 
		 * 그중 가장 비싼 보석을 꺼내서 가방에넣기
		 * */
		
		int jwIdx = 0;
		
		for(int i=0; i<K; i++) {
			
			// 현재 가방 i에 들어가는 모든 보석을 후보pq에 넣기
			for(int j=jwIdx; j<N; j++) {
				if(jw[j][0] <= C[i]) {
					pq.add(jw[j]);
					jwIdx++;
					
				}else {
					break;
					
				}
			}
			
			if(pq.isEmpty()) continue;
			int[] nowJw = pq.poll();
//			System.out.println(nowJw[0] + " " + nowJw[1]);
			 
			answer += nowJw[1];
			
		}
		
		System.out.println(answer);
	}
	
	
}
