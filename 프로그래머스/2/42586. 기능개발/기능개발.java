import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int start = 0;
        int day = 0;
        int len = progresses.length;
        
        
        
        while(start < len){
            int completedCnt = 0;
            // 앞의 기능 완료되려면 얼마나 필요한지
            int passedDays = (int)Math.ceil((100 - (double)(progresses[start]))/(speeds[start]));
            // 그만큼 진행
            for(int i=start; i<len; i++){
                progresses[i] += speeds[i]*passedDays;
            }
            day += passedDays;
            for(int i=start; i<len; i++){
                if(progresses[i] < 100){
                    break;
                }
                completedCnt++;
            }
            answer.add(completedCnt);
            start += completedCnt;
            
        }
        
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}