class Solution {
    public boolean isValid(String s) {
                ArrayDeque<Character> stack = new ArrayDeque<>();
        
        char[] arr = s.toCharArray();
        
        for(char c : arr) {
        	if(c == '{' || c == '(' || c == '[') {
        		stack.push(c);
        		continue;
        	}
        	if(stack.isEmpty()) return false;
        	
        	char prev = stack.pop();
        	
        	switch(c) {
        	case '}': 
        		
        		if(prev != '{') return false;
        		break;
        	case ']' :
        		if(prev != '[') return false;
        		break;
        	case ')' :
	    		if(prev != '(') return false;
	    		break;
        	}
        }
        if(!stack.isEmpty()) {
        	return false;
        }
        return true;
    }
}