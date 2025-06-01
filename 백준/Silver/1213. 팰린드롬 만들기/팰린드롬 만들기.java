

import java.util.*;
import java.io.*;

class Main
{
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String name = br.readLine();
		
		Map<Character, Integer> map = new TreeMap<>();
		
		for(int i=0; i<name.length(); i++) {
			char c = name.charAt(i);
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		
		char mid = 'c';
		int oddNum = 0;
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			if(entry.getValue()%2 == 1) {
				if(oddNum>=1) {
					System.out.println("I'm Sorry Hansoo");
					return;
				}
				else {
					oddNum++;
					mid = entry.getKey();
				}
			}
		}
		
		// 시간절약을 위해 StringBuilder 사용하기 
		StringBuilder left = new StringBuilder();
		for(Map.Entry<Character, Integer> e : map.entrySet()) {
			char ch = e.getKey();
			int cnt = e.getValue()/2;
			for(int i=0; i<cnt; i++) {
				left.append(ch);
			}
		}
	
		StringBuilder right = new StringBuilder(left).reverse();
		
		String middle = "";
		if(oddNum==1) {
			middle = String.valueOf(mid);
		}
		
		StringBuilder answer = new StringBuilder();
		answer.append(left);
		answer.append(middle);
		answer.append(right);
		
		bw.write(answer.toString());
		bw.newLine();
		bw.flush();
		bw.close();
		br.close();
		
	}
	

	
}
