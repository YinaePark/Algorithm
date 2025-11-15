
import java.io.*;
import java.util.*;

public class Main {
	/* 
	 * 완제품 조립에 필요한 부품수를 오름차순출력
	 * dp[i][j] = i만드는데 필ㅇ한 j의 수
	 * 
	 * 위상정렬할때, N부터 탐색..
	 * */
	
	// 기본중간부품: 1~N-1, 완제품: N
	static int N, M;
	
	// 결과배열: N만드는데 각 수가 얼마나 필요한지
	static int[] result;
	
	// prevREq[i] = {j,num} i만들때, j가 num개 필요
	static List<int[]>[] prevReq;
	
	// prevDegX = 필요부품수, prevDegX[i] = 0인게 기본붛품
	// prevDegY = 역방향으로 위상정렬하기때문에 얘를 이용해야함
	static int[] prevDegX, prevDegY;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        
        // x를 만드는데 필요한 부품수
        prevDegX = new int[N+1];
        // y가 쓰이는 부품수
        prevDegY = new int[N+1];
        result = new int[N+1];
        
        prevReq = new List[N+1];
        for(int i=0; i<N+1; i++) {
        	prevReq[i] = new ArrayList<>();
        }
        
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            prevReq[x].add(new int[] {y,k});
            prevDegX[x]++;
            prevDegY[y]++;

        }
        

        
        // 역방향으로 계산
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {N, 1});
        result[N] = 1;
        
        while(!q.isEmpty()) {
            // {지금 만들 부품, 그걸 몇개만들지 수량}
        	int[] now = q.poll();
        	
        	// next : now를 만들기 위해 필요한 부품번호, now1개당 next몇개필요?
        	for(int[] next : prevReq[now[0]]) {
        		prevDegY[next[0]]--;
        		
        		// next의 필요량 = now필요량 * now1개당 next필요량
        		result[next[0]] += result[now[0]] * next[1];
        		
        		if(prevDegY[next[0]] == 0) {
        			q.add(new int[] {next[0], result[next[0]]});
        		}
        
        	}
        }
        
        

        // 최종출력, 중간부품 말고 기본부품만
        for(int i=1; i<N+1; i++) {
        	if(prevDegX[i] == 0) {
        		System.out.println(i + " " + result[i]);
        	}
        }
    }
    

}
    