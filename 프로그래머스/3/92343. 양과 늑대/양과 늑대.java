import java.util.*;
import java.io.*;
class Solution {
    /*
    백트래킹
    */

    static int max=1;
    static int N;
    static List<Integer>[] graph;
    // [노드][양개수][늑대개수]
    static boolean[][][] visited;
    
    public int solution(int[] info, int[][] edges) {
        N = info.length;
        
        graph = new List[N];
        visited = new boolean[N][N+1][N+1];
        
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }
        
        // 그래프 만들기
        for(int[] e : edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        visited[0][1][0] = true;
        backtracking(0, 0, 0, info);
        
        return max;
    }
    
    // now : 현재노드번호
    static void backtracking(int sheep, int wolf, int now, int[] info){  
        // 맨앞으로 뺸이유: 맨처음에 0, 1이라서 ...         
        if(info[now] == 0) sheep++;
        else if(info[now] == 1) wolf++;
                
        if(wolf>=sheep){
            return;
        }
        if(max < sheep) max = sheep;


        // 인접한 점에 대해 탐색
        for(int next : graph[now]){
            
            // 현재 노드에 있는 것 판단
            if(visited[next][sheep][wolf]) continue;
            int tmp = info[now];
            info[now] = -1;
            visited[now][sheep][wolf] = true;
            
            backtracking(sheep, wolf, next, info);
            
            info[now] = tmp;
            visited[now][sheep][wolf] = false;

        }
        
        visited[now][sheep][wolf] = false;
        
    }
}