
import java.util.*;
import java.io.*;


public class Main {
	/*
	 *
	 * 문제들을 순회하며, 현재문제의 보상을 힙에 넣고, 
	 * 만약 힙크기>현재문제의 데드라인이면
	 * 힙에서 가장 작은 보상을 제거 
	 * 
	 * why? -> 같은경우... 
	 * 1 5
	 * 2 7
	 * 2 8
	 * */
	static int N;
	
	public static void main(String args[]) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int answer = 0;
		// 데드라인, 컵라면수 (보상 적은 순으로 정렬)
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->(o1[1] - o2[1]));
		
		
		N = Integer.parseInt(st.nextToken());
		
		int assignment[][] = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			assignment[i][0] = Integer.parseInt(st.nextToken());
			assignment[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 데드라인 짧은 순으로 정렬
		Arrays.sort(assignment, (o1,o2) -> o1[0] - o2[0]);
		
		int assignCnt = 0;
		int completedAssignCnt = 0;
		
		for(int i=0; i<N; i++) {
			pq.add(assignment[i]);
			
			// 데드라인보다 size가 크면
			if(pq.size() > assignment[i][0]) {
				pq.poll();
			} 
		}
		
		for(int[] a : pq) {
			answer += a[1];
		}
		
		System.out.println(answer);
	}
	
	
}
