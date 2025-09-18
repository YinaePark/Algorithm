
import java.util.*;
import java.io.*;


public class Main {
	/*
	 * 반례 : 최소 두 개의 자음
	 * 
	 * */
	
	static int L,C;
	static char[] arr;
	static char[] answer;
	static boolean[] visited;


	public static void main(String args[]) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[C];
		answer = new char[L];
		visited = new boolean[C];
		
		String str = br.readLine().replace(" ", "");
		arr = str.toCharArray();
		
		Arrays.sort(arr);
		
		bt(0,0);
		
//		System.out.println(isPossible("aaaaaaaaaaaa"));
		
	}
	
	static void bt(int depth, int curr) {
		if(depth == L) {
			StringBuilder sb = new StringBuilder();

			for(int i=0; i<L; i++) {
				char c = answer[i];
				sb.append(c);
			}
			
			String str = sb.toString();
			if(isPossible(str)){
				System.out.println(str);
			}
			
		}
		
		
		for(int i=curr; i<C; i++) {
			if(depth==L) continue;
			if(visited[i]) continue;
			visited[i] = true;
			answer[depth] = arr[i];
			bt(depth+1, i);
			visited[i] = false;
		}
	}
	
	 static boolean isPossible(String str) {
		 int jaeumCnt = 0;
		 int moeumCnt = 0;
		 boolean moeumflag = false;
		 char[] moeum = {'a', 'e', 'i', 'o', 'u'};
		
		 for(int i=0; i<str.length(); i++) {
			 for(int j=0; j<5; j++) {
				 if(str.charAt(i) == moeum[j]) {
					// 자음 이미 2개이상이면 가능함
					if(jaeumCnt>=2) return true;
					// 아직 자음개수 확인 안됐으면 다음 글자로 넘어가기
					moeumflag = true;
					moeumCnt++;
					break;
				 }

			 }
			 // 자음인 경우
			 if(!moeumflag) {

				jaeumCnt++;
				
			 }	
			 moeumflag = false;
 
		 }
		 if(moeumCnt >= 1 && jaeumCnt >=2) return true;
		 return false;
	 }
}

