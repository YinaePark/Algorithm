import java.util.*;

class Solution {
    public String solution(String number, int k) {
        int len = number.length();
        int removeCnt=0;
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i=0; i<len; i++){
            
            // 다 제거했으면 멈추기
            // if(removeCnt == k) break;
            int num = number.charAt(i) - '0';
            // 스택 비어있으면 그냥 push
            if(stack.isEmpty()){
                
                stack.push(num);
                continue;
            }
            while((!stack.isEmpty()) && (stack.peek() < num) && (removeCnt < k)){
                stack.pop();
                removeCnt++;
            }
            stack.push(num);
            
        }
        
        
        
        StringBuilder sb = new StringBuilder();
        for(int i : stack){
            sb.append(i);
        }
        
        // 아직 안된거있다면..
        while(removeCnt < k && sb.length() >0){
            sb.deleteCharAt(0);
        }
        
        sb.reverse();
        
        
        return sb.toString();
    }
}