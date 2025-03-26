import java.util.ArrayDeque;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        char[] charArr = s.toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for(char c : charArr){
            switch(c){
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    if(stack.isEmpty())
                        return false;
                    stack.pop();
            }
        }
        if(!stack.isEmpty())
            return false;
        return true;
    }
}