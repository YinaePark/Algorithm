class Solution {
        boolean[] visited;
        int remainNode;
        int cnt = 0;
        
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
            for(int i=0; i<n; i++){
                if(visited[i] == false){
                    dfs(i, n, computers);
                    cnt++;
                }
            }
        
        
        int answer = cnt;
        return answer;
    }
    
    private void dfs(int start, int n, int[][] computers){
        visited[start] = true;        
        for(int next=0; next<n; next++){
            if(visited[next] == false && computers[start][next] == 1){
                dfs(next, n, computers);
            }
        }
        
    }
    
    
}