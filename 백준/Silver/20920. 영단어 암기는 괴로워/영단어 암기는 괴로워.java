////////////////////////////////////////////////////
/////////////////////////////////////////////////////



import java.util.*;
import java.io.*;

class Main
{
	
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// N: 단어개수, M글자 이상의 단어만 집계
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			if(str.length() < M) {
				continue;
			}
			map.put(str, map.getOrDefault(str, 0)+1);
		}
		
		// Map에서 value 기준으로 정렬하기 위해서는 entrySet으로 변환과정이 필요함
		List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
		
		entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
				// 1. 자주 나올수록(Integer 클수록) 우선
				int freqCmp = e2.getValue().compareTo(e1.getValue());
				if(freqCmp != 0) {
					return freqCmp;
				}
				// 2. 단어가 길수록 우선
				int lenCmp = Integer.compare(e2.getKey().length(), e1.getKey().length());
				if(lenCmp != 0) return lenCmp;
				
				// 3. 알파벳 우선
				return e1.getKey().compareTo(e2.getKey());
			}
		});
		
		for(Map.Entry<String, Integer> entry : entryList) {
			
			bw.write(entry.getKey());
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	

	
}
