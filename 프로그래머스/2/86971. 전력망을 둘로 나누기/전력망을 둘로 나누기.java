class Solution {
    boolean[] visited;
    int[][] adjArr;
    public int solution(int n, int[][] wires) {
        // adjArr 만들기
        adjArr = new int[n][n];
        for(int i=0; i<wires.length; i++){
            adjArr[wires[i][0]-1][wires[i][1]-1] = 1;
            adjArr[wires[i][1]-1][wires[i][0]-1] = 1;
        }
        for(int i=0; i<n; i++){
            adjArr[i][i] = 1;
        }

        
        int diff = Integer.MAX_VALUE;
        
        for(int i=0; i<wires.length; i++){
            // visited 초기화
            visited = new boolean[n];
            int cnt = 0;

            // 선 끊기
            adjArr[wires[i][0]-1][wires[i][1]-1] = 0;
            adjArr[wires[i][1]-1][wires[i][0]-1] = 0;
            
            dfs(0, n);
            
            // 0과 연결된 개수
            for(int j=0; j<n; j++){
                if (visited[j] == true) cnt++;
            }
            
            if(diff > Math.abs((n-cnt)-cnt)){
                diff = Math.abs((n-cnt)-cnt);
            }
            
            // 다시 선 연결
            adjArr[wires[i][0]-1][wires[i][1]-1] = 1;
            adjArr[wires[i][1]-1][wires[i][0]-1] = 1;
        }
        // 답
        return diff;
    }
    
    void dfs(int start, int n){
        visited[start] = true;
        for(int next=0; next<n; next++){
            if(visited[next] == false && adjArr[start][next] == 1){
                dfs(next, n);
            }
        }
    }
    
}