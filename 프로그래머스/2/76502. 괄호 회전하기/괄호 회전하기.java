import java.util.ArrayDeque;
import java.util.Arrays;



class Solution {
    
    char[] c;
    ArrayDeque<Character> stack;
    int answer;
    
    
    public int solution(String s) {
        
        answer = 0;
        c = s.toCharArray();
        stack = new ArrayDeque<>();
        
        for(int idx=0; idx < c.length; idx++){
            if(isCorrect(idx)) answer++;
        }
        
        return answer;
    }
    
    public boolean isCorrect(int start){
        for(int j=0; j<c.length; j++){
                char prev;
                switch (c[(j+start)% c.length]) {
                    case '{':
                    case '(':
                    case '[':
                        stack.push(c[(j+start)%c.length]);
                        break;
                    case '}':
                        if(stack.isEmpty())
                            return false;
                        prev = stack.pop();
                        if(prev != '{')
                            return false;
                            break;
                    case ')':
                         if(stack.isEmpty())
                            return false;
                        prev = stack.pop();
                        if(prev != '(')
                            return false;
                        break;
                    case ']':
                        if(stack.isEmpty())
                            return false;
                        prev = stack.pop();
                        if(prev != '[')
                            return false;
                        break;
                }
            }
        if(!stack.isEmpty()) return false;
        return true;
    }
}