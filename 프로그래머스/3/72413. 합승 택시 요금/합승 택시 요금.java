import java.util.*;
/*
두사람이 모두 귀가할때 소요되는 예상 최저택시요금
합승해도되고 안해도됨

첨에생각한방법: 얘도 시간초과안나지만...
1.s>a,b로 각자돌리고합
2. 모든 점 k에 대해 돌린 후에, s로부터 k까지의 cost + k로부터 a까지 cost + k로부터 b까지의 cost 들과, s로부터 a, s로부터 b까지의 cost 비교하기

O(V+E) 400200
N<200
100 000 000

생각해보니.. 
걍 s, a, b에서 dijkstra 돌리면됩니다
*/
class Solution {
    static List<int[]>[] graph;
    static int N;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new List[n+1];
        N = n;
        for(int i=0; i<n+1; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] f : fares){
            graph[f[0]].add(new int[] {f[1], f[2]});
            graph[f[1]].add(new int[] {f[0], f[2]});

        }
        
        int[] aDist = dijkstra(a);
        int[] bDist = dijkstra(b);
        int[] sDist = dijkstra(s);
        
        
      
        return compare(aDist, bDist, sDist, a, b);
    }
    
    static int compare(int[] ad, int[] bd, int[] sd, int a, int b){
        int min = sd[a] + sd[b];
        
        for(int i=1; i<N+1; i++){
            if(sd[i] == Integer.MAX_VALUE 
              || bd[i] == Integer.MAX_VALUE
              || ad[i] == Integer.MAX_VALUE)
                continue;
            int tmp = sd[i] + ad[i] + bd[i];
            if(tmp < min){
                min = tmp;
            }
        }
        
        return min;
    }
    
    static int[] dijkstra(int start){
        int[] dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        pq.add(new int[] {start,0});
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            
            if(dist[now[0]] < now[1]){
                continue;
            }
            
            for(int[] next : graph[now[0]]){

                if(dist[next[0]] > next[1] + dist[now[0]]){
                    dist[next[0]] = next[1] + dist[now[0]];
                    pq.add(new int[] {next[0], dist[next[0]]});
                }
            }                                       
                                                   
                
            }
        
        return dist;
    }
}