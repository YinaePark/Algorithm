import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    // 방향: 0: 왼쪽, 1: 오른쪽, 2: 위, 3: 아래
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    private class Node implements Comparable<Node> {
        int x, y, d, cost;
        public Node(int x, int y, int d, int cost) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }
    
    public int solution(int[][] board) {
        int n = board.length;
        // 3차원 배열: dist[y][x][d]는 (x,y)에 d 방향으로 도착했을 때의 최소 비용
        int[][][] dist = new int[n][n][4];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        // 시작점 (0,0)에서는 비용 0, 하지만 첫 이동은 (0,0)에서 인접한 칸으로 진행
        // 오른쪽 이동: (0,0) -> (1,0) → 방향 1, 비용 100
        if(board[0][1] == 0) {
            dist[0][1][1] = 100;
            pq.add(new Node(1, 0, 1, 100));
        }
        // 아래쪽 이동: (0,0) -> (0,1) → 방향 3, 비용 100
        if(board[1][0] == 0) {
            dist[1][0][3] = 100;
            pq.add(new Node(0, 1, 3, 100));
        }
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            // 만약 현재 상태가 이미 더 낮은 비용으로 갱신되어 있다면 건너뜁니다.
            if(now.cost > dist[now.y][now.x][now.d]) continue;
            
            for (int next_d = 0; next_d < 4; next_d++){
                int next_x = now.x + dx[next_d];
                int next_y = now.y + dy[next_d];
                
                if(next_x < 0 || next_x >= n || next_y < 0 || next_y >= n) continue;
                if(board[next_y][next_x] == 1) continue;
                
                // 같은 방향이면 직선 도로: 100원, 방향 전환이면 코너: 600원 (100 + 500)
                int addCost = (now.d == next_d) ? 100 : 600;
                int newCost = now.cost + addCost;
                
                if(newCost < dist[next_y][next_x][next_d]){
                    dist[next_y][next_x][next_d] = newCost;
                    pq.add(new Node(next_x, next_y, next_d, newCost));
                }
            }
        }
        
        // 도착점 (n-1, n-1)에 대해 4방향 중 최소 비용 선택
        int answer = Integer.MAX_VALUE;
        for (int d = 0; d < 4; d++){
            answer = Math.min(answer, dist[n-1][n-1][d]);
        }
        return answer;
    }
}
