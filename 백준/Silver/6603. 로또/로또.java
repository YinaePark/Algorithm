
import java.io.*;
import java.util.*;

public class Main {
	/* 
	 * 
	 * */

	static int N;
	static int[] nums;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N == 0)
				break;
			nums = new int[N];
			visited = new boolean[N];
			for(int i=0; i<N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
//				System.out.println()
			}
			
			
			bt(0, new int[6], 0);
			
			
			sb.append("\n");
		}
		
		
		System.out.println(sb.toString());
	}
	
	static void bt(int depth, int[] arr, int now) {
		if(depth == 6) {
			for(int i=0; i<6; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			
			return;
		}
		
		for(int i=now; i<N; i++) {
			if(visited[i])
				continue;
			visited[i] = true;
			arr[depth] = nums[i];
			bt(depth+1, arr, i);
			visited[i] = false;

		}
		
	}
		
}
