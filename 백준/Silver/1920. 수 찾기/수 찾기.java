
import java.util.*;
import java.io.*;


public class Main {
	/*
	 * 
	 * */
	
	
	public static void main(String args[]) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Set<Integer> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			set.add(num);
		}
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(set.contains(num)) {
				sb.append(1);
			}
			else {
				sb.append(0);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	
}
