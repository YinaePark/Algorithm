

import java.util.*;
import java.io.*;

class Main
{
	
	static String s,t;
	
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		s = br.readLine();
		t = br.readLine();
		
		System.out.println(dfs(s,t));

	}
	
	public static int dfs(String s, String t) {
	
	
		// 일치할경우
		if(t.compareTo(s) == 0) {
			return 1;
		}
		// 종료조건
		if(t.length() <= s.length()) {
			return 0;
		}
			
		int tLen = t.length();
			
		// T가 A로 끝나면 A 삭제 재귀 호출
		if(t.charAt(tLen-1) == 'A') {
			if(dfs(s, t.substring(0, tLen-1)) == 1) {
				return 1;
			}
		} // T가 B로 시작하면 문자열 뒤집고 B 삭제
		if(t.charAt(0) == 'B') {
			tLen = t.length();
			t = new StringBuilder(t).reverse().toString();
			t = t.substring(0, tLen-1);
			if(dfs(s, t) == 1) {
				return 1;
			}
		}
		return 0;
	}
}
