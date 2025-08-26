
import java.util.*;
import java.io.*;


public class Main {
	static int N;
	static int[] guiltScore;
	static int[][] R;
	static int enjinIdx;
	static int max=0;
	static boolean[] visited;
	
	static int stoi(String s) { return Integer.parseInt(s);}
	
	public static void main(String args[]) throws Exception{		
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = stoi(st.nextToken());	
		guiltScore = new int[N];
		visited = new boolean[N];
		
		R = new int[N][N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			guiltScore[i] = stoi(st.nextToken());
		}	
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				R[i][j] = stoi(st.nextToken());
			}
		}
		enjinIdx = stoi(br.readLine());
		
		if(N==1) {
			System.out.println(0);
			return;
		}
//		
		backtracking(0, 0);
		
		System.out.println(max);
	}
	/*
	 * 백트래킹 : 되도록 오래하려면.. 최대 N까지 할수있음
	 * 누구일단죽여보고 은진이가 걸리면 max = depth로 업데이트해보기
	 * 
	 * */
	static boolean isFound = false;
	static void backtracking(int depth, int nightCnt) {

		if(visited[enjinIdx] || (depth == N-1)) {
			max = Math.max(nightCnt, max);
			return;
		}
		
		
		// 홀수, 낮이면 : 유죄제일높은사람이 죽음
		if((N-depth)%2 == 1) {
			int maxidx = -1;
			int maxScore = Integer.MIN_VALUE;
			// max 같으면 작은수부터죽임.. 
			for(int i=N-1; i>=0; i--) {
				if(!visited[i] && (guiltScore[i] >= maxScore)) {
					maxidx = i;
					maxScore = guiltScore[i];
				}
			}

			visited[maxidx] = true;
			backtracking(depth+1, nightCnt);
			visited[maxidx] = false;
			
		}
		else {
			nightCnt++;
			// 밤이면 : 은진이가 본인 빼고 골라서 죽임
			for(int i=0; i<N; i++) {
				if(visited[i] || i == enjinIdx) continue;
				
				visited[i] = true;
				killedScore(i);
				
				backtracking(depth+1, nightCnt);
				
				visited[i] = false;
				restoreScore(i);
				
			}
		}		
		
		
		
	}
		
	//참가자 killed가 죽었다면, 다른 참가자 i의 유죄 지수는 R[killed][i]만큼 변한다.
	static void killedScore(int killed) {
		for(int i=0; i<N; i++) {
			guiltScore[i] += R[killed][i];
		}
		
	}
	
	static void restoreScore(int killed) {
		for(int i=0; i<N; i++) {
			guiltScore[i] -= R[killed][i];
		}
	}
}
