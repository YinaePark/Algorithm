import java.util.*;
import java.io.*;
class Solution {
    /*
    참고 https://2jinishappy.tistory.com/200
    위상정렬로 풀기 : parent>child로 방향만들고 order에있는것들도방향간선으로 넣고, 사이클생기는지확인 -> t/f만 반환하면되기때문에...
    
    방법2:bfs -> 모든점 방문가능한지만을 체크하면되니까 단순하게 ㄱㄱ(최단거리가아님...)
    다음 방을 발견 했을 때, 그 전에 먼저 방문해야 하는 방이 있는지 확인합니다.
    - 방문 한적이 있을 때 = 큐에 넣는다
    - 방문 한적이 없을 때 = 지금 들어갈 수 없으므로, discovered 배열에 체크만 합니다(discovered 쓰는이유: q에 중복으로 넣는거 방지)

    y방에 방문했을 때, after[y] = x이고, discovered[x]인 경우 x는 y를 방문하지 못해서 못갔었기 때문에 이제는 갈 수 있으므로 x를 큐에 넣습니다.
     
    }
    */
  
    
    
    public boolean solution(int n, int[][] path, int[][] order) {
     
        int[] prev = new int[n];
        int[] next = new int[n];
        List<Integer>[] graph = new List[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        
        Arrays.fill(prev, -1);
        Arrays.fill(next, -1);

        for(int[] o : order){
            prev[o[1]] = (o[0]);
            next[o[0]] = (o[1]);
        }
          
        for(int[] p : path){
            graph[p[0]].add(p[1]);
            graph[p[1]].add(p[0]);
        }
        
        // prev[0]에 뭐가있으면 안됨
        if(prev[0] != -1) return false;
        
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        boolean[] discovered = new boolean[n];
        q.add(0);
        visited[0] = true;
        discovered[0] = true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            visited[now] = true;
            discovered[now] = true;
            
            // now 방문시 이미 방문은했는데 visited안됐던 점 q에 넣음
            // 돌아가서 다시방문해도 ㄱㅊ아서..
            if(next[now] != -1 && discovered[next[now]]){
                q.add(next[now]);
            }
            
            // 인접점들에 대해
            // prev없거나 prev 방문했으면 걍방문처리하고q에넣고 
            // prev있으면 discovered만업뎃
            for(int nextRoom : graph[now]){
                if(visited[nextRoom]) continue;
                if(prev[nextRoom] == -1 || visited[prev[nextRoom]]){
                    visited[nextRoom] = true;
                    discovered[nextRoom] = true;
                    q.add(nextRoom);
                    continue;
                }
                discovered[nextRoom] = true;
                
            }
            
        }
            
        for(boolean b : visited){
            if(!b) return false;
        }
        return true;
        

    }
}