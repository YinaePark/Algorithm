

import java.util.*;
import java.io.*;


public class Main {
	/*
	 * 
	 * */
	
	static Set<Integer> set = new HashSet<>();
	static int M;
	
	public static void main(String args[]) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			char s = command.charAt(0);
			
			if(command.compareTo("all") == 0) {
				set = new HashSet<>();
				for(int j=1; j<=20; j++) {
					set.add(j);
				}
				continue;
			}
			if(s == 'e') {
				set = new HashSet<>();
				continue;
			}
			
			int x = Integer.parseInt(st.nextToken());
			
			if(s == 'r') {
				if(set.contains(x)) set.remove(x);
				continue;
			}
			if(s == 'c') {
				sb.append(set.contains(x) ? 1 : 0);
				sb.append("\n");
				continue;
			}
			if(s == 't') {
				if(set.contains(x)) {
					set.remove(x);
				}else {
					set.add(x);
				}
				continue;
			}
			if(s == 'a') {
				set.add(x);
				continue;
			} 
			
			
		}
		
		System.out.println(sb.toString());
		
	}
	
}
