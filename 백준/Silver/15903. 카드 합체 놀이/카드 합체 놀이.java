
import java.io.*;
import java.util.*;

public class Main {
	/* 
	 * 
	 * */

	static int N, M;
	static int[] cards;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Long> pq = new PriorityQueue<>((a,b) ->Long.compare(a,b));
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			Long num = Long.parseLong(st.nextToken()); 
			pq.add(num);
		}
		
		for(int i=0; i<M; i++) {
			Long num1 = pq.poll();
			Long num2 = pq.poll();
			pq.add(num1+num2);
			pq.add(num1+num2);
		}
		
		Long sum = 0L;
		while(!pq.isEmpty()) {
			sum += pq.poll();
		}
		
		System.out.println(sum);
	}
}
