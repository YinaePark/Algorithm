class Solution {
    int[] board;
    int count = 0;
    int answer = 0;
    
    public int solution(int n) {
        
        board = new int[n];
        backtracking(0, n);
        return answer;
    }
    
    // 같은 idx 이거나 대각선이면 
    private void backtracking(int start, int n){
        // n개 배치 완료 시 종료
        if(start == n){
            answer++;
            return;
        }
        
        // 이번 행에 넣을 숫자를 0~n-1 반복
        for(int i=0; i<n; i++){
            // 이전과 비교해서 이번에 놓을 게 안전하면 백트래킹
            if(isSafe(start, i)){
                board[start] = i;
                backtracking(start+1, n);
            }
            
        }
    }
    
    private boolean isSafe(int now, int num){
        for(int prev=0; prev<now; prev++){
            // 같은 행이거나 대각선
            if(board[prev] == num || Math.abs(board[prev] - num) == Math.abs(prev - now)){
                return false;
            }
        }
        return true;
    }
}