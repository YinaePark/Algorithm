
import java.util.*;
import java.io.*;

class Main
{
	
	static int T;
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int K;
		String w;
		
		T = Integer.parseInt(br.readLine());
		for(int game=0; game<T; game++) {
			w = br.readLine();
			K = Integer.parseInt(br.readLine());
			contStr(w, K);
		}
		
	}
	
	public static void contStr(String word, int k) {
		// map에 각 글자의 등장 index 저장
		Map<Character, ArrayList<Integer>> map = new HashMap<>();
		for(int i=0; i<word.length(); i++) {
			char c = word.charAt(i);
			map.computeIfAbsent(c, key -> new ArrayList<>()).add(i);
		}
		
		// k개 이하만 존재하는 문자 삭제
		map.entrySet().removeIf(entry -> entry.getValue().size() < k);
		
		
		if(map.isEmpty()) {
			System.out.println("-1");
			return;
		}
		
		// 어떤 문자를 정확히 k개 포함하는 가장 짧은 연속 문자열
		int min=Integer.MAX_VALUE;
		int max=0;
		for(Map.Entry<Character, ArrayList<Integer>> entry : map.entrySet()) {
			int s;
			int idx = k-1;
			
			// System.out.println("키" + entry.getKey() + " 밸류: "+ entry.getValue());
			
			while(idx < entry.getValue().size()) {
				int diff = entry.getValue().get(idx) - entry.getValue().get(idx - k + 1) + 1;
				if(diff<min) min = diff;
				if(diff>max) max = diff;
				idx++;
			}
		}
		
		System.out.println(min +" " + max);
		
		
//		for(Map.Entry<Character, ArrayList<Integer>> entry : map.entrySet()) {
//			System.out.println("키" + entry.getKey() + " 밸류: "+ entry.getValue());
//			
//		}
	}
	
}
