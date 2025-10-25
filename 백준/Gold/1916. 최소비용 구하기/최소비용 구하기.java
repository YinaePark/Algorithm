
import java.io.*;
import java.util.*;

public class Main {
	/*
	 * A>B 최소비용
	 * */
    static int N, M, A, B;
    static int[] minDist;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
  
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        
        List<int[]>[] edge = new List[N+1];
        for(int i=0; i<N+1; i++) {
        	edge[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int s = Integer.parseInt(st.nextToken());
        	int e = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	edge[s].add(new int[] {e,c});
        }
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        pq.add(new int[] {A, 0});
        minDist = new int[N+1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[A] = 0;
        while(!pq.isEmpty()) {
        	int[] now = pq.poll();
        	
        	if(now[1] > minDist[now[0]])
        		continue;
        	
        	for(int[] next : edge[now[0]]) {
        		if(minDist[next[0]] > minDist[now[0]] + next[1]) {
        			minDist[next[0]] = minDist[now[0]] + next[1];
        			pq.add(new int[] {next[0], minDist[next[0]]});
        		}
        	}
        }
        
        System.out.println(minDist[B]);
        
    }
}