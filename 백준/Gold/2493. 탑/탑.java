
import java.io.*;
import java.util.*;

public class Main {
	/* 
	 * 
	 * N = 500,000 이면 n^2면클남
	 * 1. height[] 에 높이저장
	 * 2. stack에 index를 하나씩 push하면서, 오름차순이 깨지면?
	 * 
	 * 1) peek값이 현재값보다크면? peeek가 수신함
	 * 2) peek값이 현재값보다작으면? empty되거나 더큰거나올때까지 pop
	 *  
	 * ->아마 n
	 * 
	 * 
	 * 반례_)
	 * 1. 높이가 서로다른탑이니까 같은경우는 x
	 * 2. 1개일떄 상관x
	 * 
	 * 
	 * */

	static int N;
	static int[] height;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		height = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=N; i++) {
			int recieve = 0;
			while(!stack.isEmpty()) {
				int prev = stack.peek();
				if(height[prev] > height[i]) {
					recieve = prev;
					break;
				}else {
					stack.pop();
				}
			}
			
			sb.append(recieve + " ");
			stack.push(i);
			
		}
		
		System.out.println(sb.toString());
		
	}
	
	
	
}
