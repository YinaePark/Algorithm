import java.util.*;
class Solution {
    /*
    1. 미로탈출에 필요한 최단시간찾기 -> 다익스트라
    2. 간선은 현재있는 하나의 노드가 아니라, 연결되어있는 두 노드 상태에 따라 방향이 결정됨(모든 trap의 state를 체크해야함)
    traps는 10개 미만이기때문에 비트마스크로 트랩상태 체크(이때 좌표압축 필요)
    
    역방향: 연결된 노드중 하나만 trap on일 떄 역방향임
    
    */

    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        
        List<Integer> trapMapping = new ArrayList<>();
        Map<Integer, Integer> trapIdx = new HashMap<>();
        int idx=0;
        for(int t : traps){
            trapMapping.add(t);
            trapIdx.put(t, idx);
            idx++;
        }
        
        List<int[]>[] reversedGraph = new List[n+1];
        List<int[]>[] graph = new List[n+1];
        
        for(int i=0; i<n+1; i++){
            graph[i] = new ArrayList<>();
            reversedGraph[i] = new ArrayList<>();
        }
        
        for(int[] r : roads){
            graph[r[0]].add(new int[] {r[1], r[2]});
            reversedGraph[r[1]].add(new int[] {r[0], r[2]});
        }
    
        
        // {도착노드, cost, state}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        
        int[][] minDist = new int[n+1][1<<(traps.length+1)];
        for(int i=0; i<n+1; i++){
            Arrays.fill(minDist[i], Integer.MAX_VALUE);

        }
        minDist[start][0] = 0;
        // 시작방과 도착방은 함정 아님
        pq.add(new int[] {start, 0, 0});
    
        
        while(!pq.isEmpty()){
            int[] elem = pq.poll();
            int now = elem[0];
            int nowCost = elem[1];
            int nowState = elem[2];
            boolean nowTrap = false;
            
            // 만약 시작점==도착점이면 멈추기(항상미로탈출가능)
            if(now == end){
                return nowCost;
            }
            
            if (minDist[now][nowState] < nowCost) 
                continue;

            // 현재 트랩을 밟았는지 표시
            if(trapIdx.containsKey(now)){
                if(((1<<trapIdx.get(now)) & nowState) != 0){
                    nowTrap= true;
                }
            }
            
            // 1) 정방향 그래프 탐색 (now -> next[0])
            for (int[] next : graph[now]) {
                int nextNode = next[0];
                int w = next[1];

                // next가 트랩이고 ON인지
                boolean nextTrap = false;
                if (trapIdx.containsKey(nextNode)) {
                    int bit = trapIdx.get(nextNode);
                    if (((1 << bit) & nowState) != 0) {
                        nextTrap = true;
                    }
                }

                // 두 비트가 같으면 정방향, 다르면 역방향
                boolean reversed = nowTrap ^ nextTrap;

                // 정방향인 경우에만 graph[now] 사용 가능
                if (reversed) continue;

                // 다음 상태 (nextNode가 트랩이면 비트 토글)
                int nextState = nowState;
                if (trapIdx.containsKey(nextNode)) {
                    int bit = trapIdx.get(nextNode);
                    nextState = nowState ^ (1 << bit);
                }

                int nextCost = nowCost + w;
                if (nextCost < minDist[nextNode][nextState]) {
                    minDist[nextNode][nextState] = nextCost;
                    pq.add(new int[]{nextNode, nextCost, nextState});
                }
            }

            // 2) 역방향 그래프 탐색 (원래 from -> now였던 간선이, 뒤집힌 경우 now -> from이 됨)
            for (int[] prev : reversedGraph[now]) {
                int prevNode = prev[0]; // 원래는 prevNode -> now 였음
                int w = prev[1];

                // prevNode가 트랩이고 ON인지
                boolean prevTrap = false;
                if (trapIdx.containsKey(prevNode)) {
                    int bit = trapIdx.get(prevNode);
                    if (((1 << bit) & nowState) != 0) {
                        prevTrap = true;
                    }
                }

                // 이 간선이 뒤집혔는지
                boolean reversed = nowTrap ^ prevTrap;

                // 뒤집힌 경우에만 now -> prevNode 로 이동 가능
                if (!reversed) continue;

                int nextNode = prevNode;

                int nextState = nowState;
                if (trapIdx.containsKey(nextNode)) {
                    int bit = trapIdx.get(nextNode);
                    nextState = nowState ^ (1 << bit);
                }

                int nextCost = nowCost + w;
                if (nextCost < minDist[nextNode][nextState]) {
                    minDist[nextNode][nextState] = nextCost;
                    pq.add(new int[]{nextNode, nextCost, nextState});
                }
            }
        }
        
        
        
        return -1;
    }
}