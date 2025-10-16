
import java.io.*;
import java.util.*;

public class Main {
	/* 
	 * 실수한부분 : set.size()를 미리변수지정안해서 poll할때마다 변경
	 * 마지막에서의 중복제거안함
	 * */

	static int N, M;
	static int[] nums;
	static int[] candidates;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		
		TreeSet<Integer> set = new TreeSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			set.add(tmp);
		}
		
		int setSize = set.size();
		int[] arr = new int[M];
		candidates = new int[setSize];
		
		
		for(int i=0; i<setSize; i++) {
			candidates[i] = set.pollFirst();

			
		}
				
		bt(0, arr, 0);
		
		
		
		
	} 
	

	static void bt(int depth, int[] arr, int now) {
		if(depth == M) {
			StringBuilder sb = new StringBuilder();
			for(int num : arr) {
				sb.append(num + " ");
			}
			System.out.println(sb.toString());
			return;
		}
		
		// 큰 수부터 선택
		for(int i=now; i<candidates.length; i++) {
			arr[depth] = candidates[i];
			bt(depth+1, arr, i);
		}
		
	}
	
	
	

}
