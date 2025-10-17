
import java.io.*;
import java.util.*;

public class Main {
	/* 
	 * 일단 N을 보면 절대 백트래킹이나 완탐은아님
	 * 선을 그을 때 선택한 두 점 위치가 주어짐(1차원)
	 * 정렬을 끝나는 점 순으로 하고, 끝나는 점 같으면 시작점순으로
	 * 
	 * Q. N=10^6인데 NlogN됨.>?;
	 * 
	 * 반례: -> 5나와야하는데 4나옴... 
	 *  3
		1 5
		2 3
		4 6

	 * 
	 * */

	static int N;
	static Long[][] lines;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		lines = new Long[N][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			lines[i][0] = Long.parseLong(st.nextToken());
			lines[i][1] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(lines, ((a,b)->(a[0]==b[0]? Long.compare(a[1],b[1]) : Long.compare(a[0],b[0]) )));
		
		Long answer = 0L;
		// 현재까지 이어진 선분의 끝점을 기억하면서.. 
		Long start = lines[0][0];
		Long end = lines[0][1];
		
		for(int i=0; i<N; i++) {
			if(lines[i][0] <= end) {
				
				if(end < lines[i][1]) {
					end = lines[i][1];
				}
				
			} else {
				answer += end - start;

				end = lines[i][1];
				start = lines[i][0];
				

			}
		}
		
		// 마지막에 남은 값 처리
		answer += end - start;
		
		System.out.println(answer);
		
	}
}
