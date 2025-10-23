
import java.io.*;
import java.util.*;

public class Main {
	/* 
	 * 	완탐x
	 * 1. idx를 push
	 * 2. 오름차순이면 앞건물에서 그건물까지는 보임
	 * 3. 앞건물에서 오름차순깨지면 그 뒤부터다시 오름차순되기전까진 안보임
	 * 왼>오, 오>왼 으로 내림차순 스택 정렬 후스택크기=볼수있는 건물수
	 * 
	 * * */

	static int N;
	static int[] height;
	static int[] closestBuilding;
	static int[] visibleBuilding;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		height = new int[N+1];
		closestBuilding = new int[N+1];
		visibleBuilding = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		
		// 왼쪽에서 볼 수 있는 것
		for(int i=1; i<=N; i++) {
			// 오름차순 안되게 pop
			while(!stack.isEmpty() && height[stack.peek()] <= height[i]) {
				stack.pop();
			}
			visibleBuilding[i] = stack.size();
			if(visibleBuilding[i] > 0)
				closestBuilding[i] = stack.peek();	
			
			
			stack.push(i);
		}
		
		stack = new ArrayDeque<>(); 
	
		// 왼쪽 볼수 있는것
		for(int i=N; i>0; i--) {
			while(!stack.isEmpty() && height[stack.peek()] <= height[i]) {
				stack.pop();
			}
			visibleBuilding[i] += stack.size();
			if(stack.size() > 0 && closestBuilding[i] == 0){
				closestBuilding[i] = stack.peek();	
			}else if(stack.size() > 0 && (stack.peek() - i) < (i-closestBuilding[i]))
				closestBuilding[i] = stack.peek();	
				
			stack.push(i);
		}

		//오른쪽
		for(int i=1; i<=N; i++) {
			
			if(visibleBuilding[i]==0) {
				System.out.println(0);

			}else {
				System.out.print(visibleBuilding[i]+" "+closestBuilding[i]);
				System.out.println();
			}

		}
		
		
	}
	
	
	
}
