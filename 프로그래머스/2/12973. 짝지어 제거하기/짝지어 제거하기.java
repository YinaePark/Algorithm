import java.util.ArrayDeque;

class Solution
{
    public int solution(String s)
    {
        char[] c = s.toCharArray();
        // System.out.println
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for(int i=0; i<c.length; i++){
            if(!stack.isEmpty() && c[i] == stack.peek()){
                stack.pop();
                continue;
            }
            stack.push(c[i]);
        }
        if(!stack.isEmpty()) return 0;
        return 1;
    }
}