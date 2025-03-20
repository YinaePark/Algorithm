import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Arrays;


class Solution {
    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;
    private static int[] dist;
        
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        dist = new int[m*n];

        // 인접리스트 초기화
        // graphnum = i*5 + j
        adjList = new ArrayList[n*m];
        for(int i=0; i<n*m; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(maps[i][j] == 1){
                    if(j!=0 && maps[i][j-1] == 1){
                        adjList[i*m+j].add(i*m+j-1);
                    }
                    if(i!=0 && maps[i-1][j] == 1){
                        adjList[i*m+j].add((i-1)*m+j);
                    }
                    if(j!=m-1 && maps[i][j+1] == 1){
                        adjList[i*m+j].add(i*m+j+1);
                    }
                    if(i!=n-1 && maps[i+1][j] == 1){
                        adjList[i*m+j].add((i+1)*m+j);
                    }
                }
            }
        }
        
        visited = new boolean[n*m];
        Arrays.fill(dist, -2);
        
        bfs(0);
        return dist[n*m-1]+1;
    }
    
    private static void bfs(int n){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        visited[n] = true;
        queue.add(n);
        dist[n] = 0;
        
        while(!queue.isEmpty()){
            int now = queue.poll();
            
            for(int next : adjList[now]){
                if(!visited[next]){
                    queue.add(next);
                    dist[next] = dist[now]+1;
                    visited[next] = true;
                }
            }
        }
    }
    
}