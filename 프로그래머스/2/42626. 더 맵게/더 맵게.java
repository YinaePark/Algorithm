import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int food : scoville){
            pq.add(food);
        }
        
        int cnt = 0;
        
        while(true){
            if(pq.isEmpty()){
                return -1;
            }
            
            int food1 = pq.poll();
            if(food1 >= K){
                return cnt;
            }
            
            if(pq.isEmpty()){
                return -1;
            }
            int food2 = pq.poll();
            
            pq.add(food1 + (food2 * 2));
            cnt++;
            
        }
        
    }
}