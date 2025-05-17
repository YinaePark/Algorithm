import java.util.*;


class Solution {
    
    int[] moveY = {-1, 1, 0, 0};    
    int[] moveX = {0, 0, 1, -1};
    char[][] mapChar;
    
    int mapX, mapY;
    
    boolean[][] visited;
    int[][] dist;
    
    public static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(String[] maps) {
        mapY = maps.length;
        mapX = maps[0].length();
        
        Point start=null;
        Point lever=null;
        Point end=null;
        
        mapChar = new char[mapY][mapX];
        for(int i=0; i<mapY; i++){
            mapChar[i] = maps[i].toCharArray();
            for(int j=0; j<mapX; j++){
                if(mapChar[i][j] == 'S'){
                    start = new Point(j, i);
                } else if(mapChar[i][j] == 'L'){
                    lever = new Point(j, i);
                } else if(mapChar[i][j] == 'E'){
                    end = new Point(j,i);
                }
            }
        }
        visited = new boolean[mapY][mapX];
        dist = new int[mapY][mapX];

        int sTol = bfs(start, lever);
        
        for(int i=0; i<mapY; i++){
            Arrays.fill(visited[i], false);
            Arrays.fill(dist[i], 0);
        }
        
        int lToe = bfs(lever, end);
        
        if(sTol == -1 || lToe == -1){
            return -1;
        }
        return sTol + lToe;

    }
    
    // bfs -> queue
    public int bfs(Point start, Point end){
        ArrayDeque<Point> q = new ArrayDeque<>();
        visited[start.y][start.x] = true;
        q.add(start);
        
        while(!q.isEmpty()){
            Point now = q.poll();
            int sx = now.x;
            int sy = now.y;
            
            if(sx == end.x && sy == end.y) return dist[sy][sx];
            
            for(int i=0; i<4; i++){
                int nx = sx + moveX[i];
                int ny = sy + moveY[i];
                // 벽이거나 범위를 벗어나거나 이미 방문했으면 아님 
                if(nx<0 || ny<0 || nx>= mapX || ny>=mapY || mapChar[ny][nx] == 'X' || visited[ny][nx]){
                    continue;
                }
                // 아니면 visited 처리하구 q에 넣기
                visited[ny][nx] = true;
                dist[ny][nx] = dist[sy][sx]+1;
                q.add(new Point(nx, ny));
            }   
        }
        
        return -1;
    }
}