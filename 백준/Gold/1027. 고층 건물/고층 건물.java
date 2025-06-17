

import java.util.*;
import java.io.*;

class Main
{
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		String line = br.readLine();
		
		StringTokenizer st = new StringTokenizer(line);
		int nums = st.countTokens();
		long[] building = new long[nums];
		for(int i=0; i<nums; i++) {
			building[i] = Long.parseLong(st.nextToken());
		}
		
		boolean possible[][] = new boolean[n][n];

		
		// 0~n-1 번째 빌딩까지 돌면서, 오른쪽 빌딩과 기울기 비교
		for(int now=0; now<n; now++) {
			double maxSlope=Double.NEGATIVE_INFINITY;
			
			
			for(int next=now+1; next<n; next++) {
				double nowSlope = getSlope(now, next, building[now], building[next]);
				if(next-now==1 || nowSlope>maxSlope) {
					//System.out.println("이건 가능하다 now, next " + now + " " + next);
					maxSlope = nowSlope;
					possible[now][next] = true;
					possible[next][now] = true;
				}
				
			}
		}
		
		int maxBuilding = 0;
		int maxResult = -1;
		for(int i=0; i<n; i++) {
			int result=0;
			for(int j=0; j<n; j++) {
				if(possible[i][j]) result++;
			}
			if(result>maxResult) {
				maxBuilding = i;
				maxResult = result;
			}
		}
		
		System.out.println(maxResult);
		
	}
	
	// 기울기 출력함수, 
	public static double getSlope(long x1, long x2, long y1, long y2) {
		return (double)(y2-y1)/(x2-x1);
	}
	
}
