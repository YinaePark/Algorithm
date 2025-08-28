
import java.util.*;
import java.io.*;


public class Main {
	/*
	 * 10^5 >> 아마 O(NlogN) 가능할듯
	 * */
	
	
	public static void main(String args[]) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		List<int[]> Is = new ArrayList<>();
	
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			Is.add(new int[] {s, e});
		}
		
		// 끝나는시간먼저, 시작시간그다음 정렬
		Collections.sort(Is, (o1, o2)->{
				if(o1[1] == o2[1]) {
					return Integer.compare(o1[0], o2[0]);
				}
				return Integer.compare(o1[1], o2[1]);
		});
		
		int answer = 0;
		int nowTime = 0;
		
		
		for(int[] i : Is) {
			int s = i[0];
			int e = i[1];
			if(s>=nowTime) {
				answer++;
				nowTime = e;
			}
		}
	
		
		System.out.println(answer);
	}
	
	
}
