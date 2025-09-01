
import java.util.*;
import java.io.*;


public class Main {
	/*
	 * 1. 도착마을이 빠른 순, 보내는마을이 빠른 순 차례로 정렬(같은 도착이라면 먼저출발하는 화물)
	 * 2. 각 구간별 현재 적재량 배열 만들기, section[i] 는 i~i+1, 초기값은 모두 0
	 * 3. 정렬된 박스들을 순서대로 처리하며, 최대 적재 가능량 계산
	 * 		박스가 (s,e,w)일 때, 박스는 s~e-1까지 구간에서 트럭을 차지한다.
	 * 		최대 적재 가능량 = min(w, (C-section[s]), (C-section[s+1]), ... , (C-section[e-1]))
	 * 				
	 *
	 * */
	static int N, C, M;
	static int[] section;
	static int[][] box;
	
	public static void main(String args[]) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(br.readLine());
		
		section = new int[N];
		// s, e, w
		box = new int[M][3];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		// e가 빠른순, e가 같다면 s 빠른순 정렬
		Arrays.sort(box, (o1, o2)->(o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]));
		
		// 박스에 대해 반복..
		for(int i=0; i<M; i++) {
			int s = box[i][0];
			int e = box[i][1];
			int w = box[i][2];
			
			// 최대 적재량 찾기
			int maxWeight = w;
			for(int j=s; j<e; j++) {
				maxWeight = Math.min(maxWeight, C-section[j]);
			}
			
			// 찾은 적재량을 업데이트하기
			if(maxWeight <= 0) continue;
			
			for(int j=s; j<e; j++) {
				section[j] += maxWeight;
			}
			answer += maxWeight;
			
		}
		
		System.out.println(answer);
	}
	
	
}
