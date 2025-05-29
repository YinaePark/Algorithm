import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[prices.length];
        // answer[prices.length-1] = 0;
        stack.push(0);
        
        for(int i=1; i<prices.length; i++){
            int prev = stack.peek();
            int now = i;
            if(prices[now] >= prices[prev]){
                stack.push(i);
                continue;
            }
            

            while(!stack.isEmpty() && prices[now] < prices[stack.peek()]){

                prev = stack.pop();
                answer[prev] = now-prev;
            }
            stack.push(now);
        }
        
        while(!stack.isEmpty()){
            int idx = stack.pop();
            answer[idx] = prices.length - idx - 1;
        }
        
        return answer;
    }
}