import java.util.ArrayDeque;


class Solution {
    public int solution(int[][] board, int[] moves) {
        int N = board.length;
        // 사라진 인형의 개수
        int answer = 0;
        // 쌓기
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] topDepth = new int[N];
        
        // 각 칸의 top 인덱스 구하기
        for(int j=0; j<N; j++){
            for(int i=0; i<N; i++){
                if(board[i][j] != 0){
                    topDepth[j] = i;
                    break;
                }
            }
        }
           
        // for(int i=0; i<N; i++){
        //     System.out.println(topDepth[i]);
        // }
        
        // moves 개수만큼 반복
        for(int i=0; i<moves.length; i++){
            // 칸의 인덱스는 moves[i]-1
            int rail = moves[i]-1;
            
            // 칸이 비어있으면 continue
            if(topDepth[rail] == N)
                continue;
            // 두 인형이 같으면 터뜨리기
            if(!stack.isEmpty() && stack.peek() == board[topDepth[rail]][rail]){
                board[topDepth[rail]][rail] = 0;
                topDepth[rail]++;
                stack.pop();
                answer+=2;
                continue;
            }
            // 다르면 그냥 쌓기
            stack.push(board[topDepth[rail]][rail]);
            board[topDepth[rail]][rail] = 0;
            topDepth[moves[i]-1]++;
                 
        }
        
        return answer;
    }
}