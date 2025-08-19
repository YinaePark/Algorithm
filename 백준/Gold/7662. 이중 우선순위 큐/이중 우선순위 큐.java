
import java.util.*;
import java.io.*;


public class Main {
	/*
	 * 데이터 삭제 시 : 우선순위 젤 높은 데이터 or 낮은 데이터 중 하나 삭제
	 * PQ쓰면 최솟값 찾기 어려움
	 * treemap 국룰
	 * 
	 * */
	
	
	public static void main(String args[]) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		// 값, 개수
		TreeMap<Integer, Integer> map = new TreeMap<>();
		
		for(int test=0; test<T; test++) {
			
			map = new TreeMap<>();
			
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());

			
			for(int i=0; i<command; i++) {
				st = new StringTokenizer(br.readLine());
				String c = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				
				if(c.charAt(0) == 'I') {
					map.merge(num, 1, Integer::sum);
				}
				
				if(c.charAt(0) == 'D') {
					if(map.isEmpty()) continue;
					if(num == -1) {
						num = map.firstKey();
					}else if(num == 1) {
						num = map.lastKey();
					}
					
					if(map.containsKey(num)) {
						if(map.get(num) == 1) {
							map.remove(num);
							continue;
						}
						else {
							map.merge(num, -1, Integer::sum);

						}
					}
						
					} 
				
			}
			if(map.isEmpty()) {
				System.out.println("EMPTY");
				continue;
			}
			
			int fk = map.firstKey();
			int lk = map.lastKey();
			System.out.println(lk+  " " + fk);
			
			
		}
				
	}
 
		
	
}
