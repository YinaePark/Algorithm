import java.util.ArrayDeque;


class Solution {
    int N, M, sx, sy, lx, ly, ex, ey;
    int[] rr = {1, -1, 0, 0};
    int[] cc = {0, 0, 1, -1};
	private static class Node{
		int r, c;
		public Node(int r, int c){
			//x좌표
			this.r = r;
			//y좌표
			this.c = c;
		}
	}
    
    public int solution(String[] maps) {


        // y개수
        N = maps.length;
        // x개수
        M  = maps[0].length();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(maps[i].charAt(j) == 'S'){
                    sy = i;
                    sx = j;
                }
                else if(maps[i].charAt(j) == 'L'){
                    ly = i;
                    lx = j;
                }
                else if(maps[i].charAt(j) == 'E'){
                    ey = i;
                    ex = j;
                }
            }
        }
        
        int[][] dist = new int[N][M];
        ArrayDeque<Node> q = new ArrayDeque<>();

        // 시작 > 레버 
        q.addLast(new Node(sx, sy));
        // dist[sy][sx] = ;
        
        while(!q.isEmpty()){
            Node now = q.pollFirst();
            for(int i=0; i<4; i++){
                int n_x = now.r + rr[i];
                int n_y = now.c + cc[i];
                
                if(n_x < 0 || n_y < 0 || n_x >= M || n_y >= N || maps[n_y].charAt(n_x) == 'X'){
                    continue;
                }
                if(dist[n_y][n_x] == 0){
                    q.addLast(new Node(n_x, n_y));
                    dist[n_y][n_x] = dist[now.c][now.r] + 1;
                }
                
            }    
        }
        int sToL = dist[ly][lx];
        if(sToL == 0) return -1;
        
        // 레버 > 도착
        int[][] dist2 = new int[N][M];

        q.addLast(new Node(lx, ly));
        
        while(!q.isEmpty()){
            Node now = q.pollFirst();
            for(int i=0; i<4; i++){
                int n_x = now.r + rr[i];
                int n_y = now.c + cc[i];
                
                if(n_x < 0 || n_y < 0 || n_x >= M || n_y >= N || maps[n_y].charAt(n_x) == 'X'){
                    continue;
                }
                if(dist2[n_y][n_x] == 0){
                    q.addLast(new Node(n_x, n_y));
                    dist2[n_y][n_x] = dist2[now.c][now.r] + 1;
                }
                
            }    
        }
    
        return dist2[ey][ex] == 0 ? -1 : dist2[ey][ex] + sToL;
        
    }
}