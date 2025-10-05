import java.util.*;
import java.io.*;
class Solution {
    /*
    문제를잘읽자!..
    - intensity가 최소가 되는 등산코스가 여러 개라면 그중 산봉우리의 번호가 가장 낮은 등산코스를 선택합니다.
    - 걍dfs로하면터짐왜냐면 dfs한번돌리기가 O(V+E)인데, 이건 모든 출-산 경우의쌍에대해서 돌려야하기때문
    - 멀티소스 다익스트라 : start가 여러개일 때, 최단거리(q에 시작점 모두 넣기) 
    - 산봉우리, 출입구는 여러번 못지난다
      - 방법1: 산봉우리에서 나가는 엣지는 생략하기(귀찮음)
      - 방법2: 멀티소스다익스트라 사용할경우에는 아예 now=산봉우리 도달하면 continue해버리기
               next노드들이 출입구이면 지나지말고 continueㅎ9버리기

    */
    
    
    static List<int[]>[] graph;
    static boolean[] isGates;
    static boolean[] isSummits;
    static int[] dist;
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        graph = new List[n+1];
        isGates = new boolean[n+1];
        isSummits = new boolean[n+1];
        dist = new int[n+1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for(int g : gates){
            isGates[g] = true;
        }
        for(int s : summits){
            isSummits[s] = true;
        }
        // 그래프 업뎃
        for(int i=0; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] p : paths){
            graph[p[0]].add(new int[] {p[1], p[2]});
            graph[p[1]].add(new int[] {p[0], p[2]});    
        }
        
        
        // 최소경로: 
        int minSummit=Integer.MAX_VALUE;
        int minIntensity=Integer.MAX_VALUE;
        dijkstra(n, gates);
        for(int s : summits){
            if(dist[s] < minIntensity || (dist[s]==minIntensity && s<minSummit)){
                minSummit = s;
                minIntensity = dist[s];
            }
        }
        
        
        return new int[] {minSummit, minIntensity};
    }
    
    
    static void dijkstra(int n, int[] gates){

        
        // pq에 저장될정보 int[] {dest, cost}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        
        // 모든시작접 q에넣기
        for(int g : gates){
            dist[g] = 0;
            pq.add(new int[] {g, 0});
        }
        
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int nowPoint = now[0];
            int nowDist = now[1];
            // 이미최적화돼잇는지 판단
            if(nowDist > dist[nowPoint])
                continue;
            // 산봉우리 도달 시 더 갈필요없음 
            if(isSummits[nowPoint]) continue;
            
            // 연결된 다른 점들에 대해 반복하면서 
            // nowDist엣지를 지나서 nextPoint로 가는게 기존 dist[next]보다 나으면 갱신
            // 갱신하면서 어떤 점을 전 점으로 지나는지도 갱신
            for(int[] next : graph[nowPoint]){
                // 출입구면 2번못지남
                if(isGates[next[0]]) continue;
                
                if(Math.max(nowDist, next[1]) < dist[next[0]]){
                    dist[next[0]] = Math.max(nowDist, next[1]);
                    pq.add(new int[] {next[0], dist[next[0]]});
                }
            } 
        }
       
        
        return;
        
    }
}