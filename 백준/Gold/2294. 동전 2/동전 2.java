
import java.io.*;
import java.util.*;

public class Main {
	/* 
	 *틀린이유: INF +n 하면 오버플로우남 주의 
	 * */
	
	static int N, K;
	static int[] v;
	// dp[i] = i원 만드는 데 필요한 동전개수
	static int[] dp;
	
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        v = new int[N];
        dp = new int[K+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	v[i] = Integer.parseInt(st.nextToken());
        }
        
        dp[0] = 0;
        // 동전종류 
        for(int val=0; val<N; val++) {
        	int coin = v[val];
        	for(int i=coin; i<=K; i++) {
        		if(dp[i-coin]!=Integer.MAX_VALUE && dp[i] > dp[i-coin]+1) {
        			dp[i] = dp[i-coin]+1;
        		}
        	}
        }
     
        System.out.println(dp[K] == Integer.MAX_VALUE ? -1 : dp[K]);
        		
        
    }
    

}

