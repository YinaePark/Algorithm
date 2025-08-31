
import java.util.*;
import java.io.*;


public class Main {
	/*
	 * N개의 센서들을 K개 집중국의 그룹으로 묶을때, 각 집중국의 범위들의 합이 제일 작아야함
	 * > 인접한 센서들의 거리 차이를 구하고, 제일 먼 거리 구간을 K-1개 제거하기
	 * 
	 * */
	static int N, K;
	static int[] sensor, diff;
	
	public static void main(String args[]) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		
		sensor = new int[N];
		diff = new int[N-1];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			sensor[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(sensor);
		
		for(int i=0; i<N-1; i++) {
			diff[i] = sensor[i+1]-sensor[i];
		}
		
		
		
		Arrays.sort(diff);
		
		int answer = 0;
		
		
		for(int i=0; i<N-K; i++) {
			answer += diff[i];
		}
		
		
		System.out.println(answer);
	}
	
	
}
