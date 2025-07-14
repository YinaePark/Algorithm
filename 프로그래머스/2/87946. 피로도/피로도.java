import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    int answer = -1;
    boolean[] isVisited;
    
    public int solution(int k, int[][] dungeons) {
        // ArrayList<Integer> visitedList = new ArrayList<>();
        isVisited = new boolean[dungeons.length];
        
        for(int i=0; i<dungeons.length; i++){
           if (k >= dungeons[i][0]) {
                ArrayList<Integer> visitedList = new ArrayList<>();
                isVisited[i] = true;
                visitedList.add(i);
                backtracking(dungeons, i, visitedList, k - dungeons[i][1]);
                isVisited[i] = false;
            }

        }
        return answer;
    }
    
    private void backtracking(int[][] dungeons, int start, ArrayList<Integer> visited, int remainK){
        // 테스트 프린트
        // System.out.println("이번 턴에는 " +  start + "던전을 탐색합니다.."  );
        // for(int num : visited){
        //     System.out.print(num + " ... ");
        // }
        // System.out.println("---");
        ///
        
        
        if(visited.size() > answer){
                answer = visited.size();
        }
        
        
        
        // k 충분하면 다음 던전으로 이동
        
        for(int i=0; i<dungeons.length; i++){
            if(!isVisited[i] && remainK >= dungeons[i][0]) {
                visited.add(i);
                isVisited[i] = true;
                backtracking(dungeons, i, visited, remainK-dungeons[i][1]);
                visited.remove(visited.size() - 1);
                isVisited[i] = false;
            }
        }
        
        
        return;
    }
    
    
}