
import java.io.*;
import java.util.*;

public class Main {
	/* 
	 * 수업 빨리 끝나는 순 정렬, 
	 * 
	 * */

	static int N;
	static int[][] classes;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		classes = new int[N][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			classes[i][0] = Integer.parseInt(st.nextToken());
			classes[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
		//시작시간 빠른순으로 정렬
		Arrays.sort(classes, (a,b)->(a[0]==b[0] ? a[1]-b[1] : a[0] - b[0]));
		// 끝나는시간 빨리끝나는순으로 저장
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(a-b));
		pq.add(classes[0][1]);
		
		//강의실 재활용가능여부
		for(int i=1; i<N; i++) {
			if(!pq.isEmpty() && (pq.peek() <= classes[i][0])) {
				pq.poll();
			}
			pq.add(classes[i][1]);
		}
		
		
		System.out.println(pq.size());
	}
}
