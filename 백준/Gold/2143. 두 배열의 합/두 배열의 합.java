import java.io.*;
import java.util.*;

public class Main {
	/* N,M = 10^3
	 * A: N 
	 * B: M
	 * A부분배열의 합 + B의 부분배열의 합 = T인 모든 부배열쌍의 개수
	 * A 부분배열은, 원소1개인것N개, 원소2개인것N-1개, 원소 3개인것N-2... + ... 원소 N개인것 1개 다 합치면 
	 * N(N+1)/2 
	 * 
	 * 1. A,B 각각 부분배열의 합이 될수있는 모든 수 구하고 정렬하기
	 * 2. 투포인터 or binary로 T인것 찾기
	 * 
	 * =====
	 * binarySearch로 : target = T - subA[i] 를 sub[B]에서 찾기
	 * 이떄 여러개일수있음을 주의
	 * 
	 * =====
	 * 투포인터
	 * =====
	 * 
	 * 
	 * 틀린이유:
	 * 오버플롱 !!!!!!!!!!!!!!!!!!!!!!!!!!
	 * 1) answer, 
	 * 2) sum
	 * 
	 * 
	 * */
	
	static long T;
	static int N, M;
	static int[] A,B;
	static long[] subA, subB;
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = new int[N];
    	st = new StringTokenizer(br.readLine());

        for(int i=0;i<N; i++) {
        	A[i] = Integer.parseInt(st.nextToken()); 
        }
        
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        B = new int[M];
    	st = new StringTokenizer(br.readLine());

        for(int i=0;i<M; i++) {
        	B[i] = Integer.parseInt(st.nextToken()); 
        }
        
        // 연속배열의 부분합 모든 경우에대해 다구하기
        subA = new long[N*(N+1)/2];
        subB = new long[M*(M+1)/2];

        int idx = 0;
        for(int i=0; i<N; i++) {
        	long sum = 0;
        	for(int j=i; j<N; j++) {
        		sum += A[j];
        		subA[idx++] = sum;
        	}
        }
        idx = 0;
        for(int i=0; i<M; i++) {
        	long sum = 0;
        	for(int j=i; j<M; j++) {
        		sum += B[j];
        		subB[idx++] = sum;
        	}
        }
        
        Arrays.sort(subA);
        Arrays.sort(subB);
        
        // 1. 투포인터
        int aIdx = 0;
        int bIdx = M*(M+1)/2 - 1;
        long answer = 0;
        while(true) {
        	// 범위 벗어나면 종료
        	if(aIdx >= N*(N+1)/2 || bIdx < 0 ) {
        		System.out.println(answer);
        		return;
        	}
        	
        	long tmpA = subA[aIdx];
        	long tmpB = subB[bIdx];
        	long tmpSum = tmpA + tmpB;
        	if(T == tmpSum) {
        		long aCnt = 0;
        		long bCnt = 0;
        		while(aIdx < N*(N+1)/2 && subA[aIdx] == tmpA) {
        			aCnt++;
        			aIdx++;
        		}
        		while(bIdx >= 0 && subB[bIdx] == tmpB) {
        			bCnt++;
        			bIdx--;
        		}
        		
        		answer += aCnt * bCnt;
        		
        		
        	}
        	// 타겟보다 크면 줄이기
        	else if(T<tmpSum) {
        		bIdx--;
        	}
        	else if(T>tmpSum) {
        		aIdx++;
        	}
        	
        	
        }
        
        
        
        
        
        
    }
    

    

}

