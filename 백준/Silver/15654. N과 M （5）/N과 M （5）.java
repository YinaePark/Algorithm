
import java.io.*;
import java.util.*;

public class Main {
	/* 
	 * * */

	static int N, M;
	static int[] nums;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		bt(0, 0, new int[M]);
		
		System.out.println(sb.toString());
	}
	
	static void bt(int start, int depth, int[] arr) {
		if(depth == M) {
			for(int i=0; i<M; i++) {
				sb.append(arr[i] + " ");
				
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i])
				continue;
			visited[i] = true;
			arr[depth] = nums[i];
			bt(i+1, depth+1, arr);
			visited[i] = false;

			
		}
	}
	
	
}
