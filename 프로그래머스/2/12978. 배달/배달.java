import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    private static class Node{
        int dest;
        int cost;
        public Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        // adjList 만들기
        ArrayList<Node>[] adjList = new ArrayList[N];
        for(int i=0; i<N; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int[] edge : road){
            adjList[edge[0]-1].add(new Node(edge[1]-1, edge[2]));
            adjList[edge[1]-1].add(new Node(edge[0]-1, edge[2]));

        }
        // dist 배열 초기화
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)->Integer.compare(o1.cost, o2.cost));
        pq.add(new Node(0, 0));
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            // 이미 방문했으면...
            if(dist[now.dest] < now.cost){
                continue;
            }
            
            // 다음 모든 엣지들에 대해...
            // dist 업데이트여부확인
            for(Node next : adjList[now.dest]){
                if(dist[next.dest] > dist[now.dest] + next.cost){
                    dist[next.dest] = dist[now.dest] + next.cost;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }
        
        int cnt = 0;
        for(int j=0; j<N; j++){
            if(dist[j] <= K) {
                cnt++;
            }
           System.out.println(dist[j]); 

    
        }
        return cnt;
    }
}
