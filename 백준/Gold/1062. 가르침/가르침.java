
import java.util.*;
import java.io.*;


public class Main {
	static int N, K;
	static int maxWords = 0;
	static int[] wordMask;
	
	public static void main(String args[]) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(K<5) {
			System.out.println(0);
			return;
		}
		if(K==26) {
			System.out.println(N);
			return;
		}
		
		wordMask = new int[N];
		
		for(int i=0; i<N; i++) {
			
			String word = br.readLine();
			for(int j=4; j<word.length()-4; j++) {
				char c = word.charAt(j);
				wordMask[i] |= (1<<(c-'a'));
			}
			
		}
		
		int basicMask = 0;
        basicMask |= (1 << ('a' - 'a'));
        basicMask |= (1 << ('n' - 'a'));
        basicMask |= (1 << ('t' - 'a'));
        basicMask |= (1 << ('i' - 'a'));
        basicMask |= (1 << ('c' - 'a'));
        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;
        
		backtracking(0, 1, K-5, basicMask);
		
		System.out.println(maxWords);
		
	}
	
	static boolean visited[] = new boolean[26];
	
	// 알파벳 K-5개 고르기
	// 단어중에 해당 알파벳으로만 만들 수 있는 단어 몇갠지 고르기
	// 걍 21C(k-5) 로 알파벳조합찾아서 몇개포함하는지 찾고, max 업데이트 
	
	static void backtracking(int depth, int start, int target, int alphabets) {

		if(depth == target) {
			int wordCnt=0;
			for(int i=0; i<N; i++) {
				// alphabets에있는 모든 글자로 wordMask를 만들수있는지 확인
				if((wordMask[i] | alphabets) != alphabets) {
					continue;
				}
				wordCnt++;
			}
			if(wordCnt>maxWords) maxWords=wordCnt;
			return;
		}
		
		// 알파벳 고르기
		
		for(int i=start; i<26; i++) {
			int tmp = i+'a';
			// a,c,i,n,t 거나 이미 고른 단어면 제끼기
			if(visited[i] || (tmp == 'a') || (tmp == 'c') 
					|| (tmp == 'i') || (tmp == 'n') || (tmp == 't')) {
				 continue;
			}
			
			visited[i] = true;
			alphabets |= (1<<i);
			
			backtracking(depth+1, i, target, alphabets);
			
			visited[i] = false;
			alphabets &= ~(1<<i);
			
		}
		
	}
	
	
	

	
}
