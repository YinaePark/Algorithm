
import java.util.*;
import java.io.*;


public class Main {
	
	public static boolean[] isMal;
	public static List<Integer>[] network;
	
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		network = (List<Integer>[]) new List[N+1];
		for(int i=1; i<=N; i++) {
			network[i] = new ArrayList<>();
		}
		
		
		// String line = sc.nextLine();
		// 입력받기
		int lines = sc.nextInt();
		for(int l = 0; l<lines; l++){

			
			int s = sc.nextInt();
			int e = sc.nextInt();
			
			// 간선 추가
			network[s].add(e);
			network[e].add(s);
			
		}
		
		isMal = new boolean[N+1];
		isMal[1] = true;
		dfs(1);
		
		int cnt=0;
		for(int i=2; i<N+1; i++) {
			if(isMal[i]) {
//				System.out.println("MAL: " + i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}
	
	public static void dfs(int start) {
		
		for(int end : network[start]) {
			if(isMal[end]) continue;
			
			isMal[end] = true;
			dfs(end);
		}
		return;
	}
}
