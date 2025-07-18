import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        int answer = 0;
        // 전체 개수
        int totalProcess = priorities.length;
        
        // 최댓값인지 판별용 
        // priorities는 1~9
        int[] count = new int[10];
        
        // 큐에 int[] {원래 인덱스, priorities 값}을 저장
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for(int i=0; i<totalProcess; i++){
            count[priorities[i]]++;
            q.add(new int[]{i, priorities[i]});
        }
        
        
        
        // 찾고 싶은 location일 때까지 반복
        while(true) {
            // 테스트출력
        // for(int i=0; i<10; i++){
        //     System.out.println(i + " 에는 지금 count가.. " + count[i]);
        // }
        //     System.out.println("=============");
            
            // 현재 프로세스
            int[] currProcess = q.poll();
            int currLocation = currProcess[0];
            int currPriority = currProcess[1];
            
            
            // 테스트출력
            // System.out.println("지금 프로세스 : " + currLocation + " 중요도: " + currPriority);
            
            // 프로세스가 최고우선순위인지 판단
            for(int i=9; i>0; i--){
                // 현재 최고 우선순위
                if(count[i] != 0){
                    int max = i;
                    // 현재 프로세스가 최고우선순위라면
                    // 프로세스 제거
                    if(currPriority == max){
                        count[i]--;
                        answer++;
                        if(location == currLocation){
                            return answer;
                        }
                        continue;
                    }
                    
                    // 현재프로세스가 최고우선순위가 아니라면
                    // 다시 큐의 맨 뒤에 넣기
                    q.add(currProcess);
                    break;
                }
            }
            
            
            
        }
        
    }
}