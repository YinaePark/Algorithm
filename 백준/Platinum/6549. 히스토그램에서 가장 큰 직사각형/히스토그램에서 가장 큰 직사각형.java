
import java.io.*;
import java.util.*;

public class Main {
	/* 
	 * - monotonic stack.. 
	 * - 아이디어: i=0~n까지 반복하면서, 
	 *          n이전 막대를 높이로하는 직사각형의 최대 넓이구하기
	 *          스택에 idx를 저장,
	 * 1. 오름차순으로 스택에 쌓다가, 내림차순이 나오면, 내림차순 안나올때까지 pop반복하면서,
	 *  이전 막대들로 만들 수 있는 직사각형 계산, 오름차순되면 push하기
	 * 2. 계산공식:
	 *    width : stack.isEmpty면: 첨부터 현재까지 전체넓이
	 *    아니면? idx - stack.peek() - 1 : 이전 더 낮은 막대 다음부터 현재 직전까지
	 *  
	 *    예를들어서 height[] = {5, 6, 2} 이면 idx=2에서 pop후
	 *    i) height[1] 을 높이로하는 직사각형계산 -> width=1 (오름차순이니까..)
	 *    ii) height[0]을 높이로하는 직사각형계산 -> width=2 
	 *    
	 *    idx=3(extended)에서 height[2]를 높이로하는 직사가곃ㅇ 계산 -> width=3
	 * 
	 *   */
	
	static int N;
	static long[] h;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			if(N == 0) break;
			
			// 마지막 0
			h = new long[N+1];
			
			for(int i=0; i<N; i++) {
				h[i] = Long.parseLong(st.nextToken());
			}
			
			long max=0;
			// idx 저장
			ArrayDeque<Integer> stack = new ArrayDeque<>();
			
			for(int i=0; i<=N; i++) {
				
				// 내림차순인동안
				while(!stack.isEmpty() && h[stack.peek()] > h[i]) {
					long height = h[stack.pop()];
					long width = stack.isEmpty() ? i : i - stack.peek() -1;
					
					max = Math.max(max, (long)height * width);
				}
				
				stack.push(i);
			}
			
			System.out.println(max);
		}
		

	} 
	


}
