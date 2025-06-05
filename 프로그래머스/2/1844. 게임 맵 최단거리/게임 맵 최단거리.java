import java.util.*;


class Solution {
    int[] moveX = {0,0,-1,1};
    int[] moveY = {1,-1,0,0};
    boolean[][] visited;
    int[][] dist;
    int n, m;
    
    public class Point{
        int x, y;
        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    
    public int solution(int[][] maps) {
        // n y
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        dist = new int[n][m];
        
        return bfs(maps);
    }
    
    public int bfs(int[][] maps){
        ArrayDeque<Point> q = new ArrayDeque<>();
        q.add(new Point(0,0));
        visited[0][0] = true;
        dist[0][0] = 1;
        
        while(!q.isEmpty()){
            Point now = q.poll();
            if(now.x == m-1 && now.y == n-1)
                return dist[now.y][now.x];
            
            for(int i=0; i<4; i++){
                int nextX = now.x + moveX[i];
                int nextY = now.y + moveY[i];
                if(nextX<0 || nextY<0 || nextX>=m || nextY>=n 
                   || visited[nextY][nextX] || maps[nextY][nextX] == 0) continue;
                
                q.add(new Point(nextX, nextY));
                visited[nextY][nextX] = true;
                dist[nextY][nextX] = dist[now.y][now.x] + 1;
            }
        }
        return -1;
    }
   
    
}