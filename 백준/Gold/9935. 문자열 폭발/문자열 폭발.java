
import java.io.*;
import java.util.*;

public class Main {
	/*  
	 *문자열 길이<10^6
	 *폭발문자열이 폭발하면 문자열에서사라짐, 남은문자열 합쳐짐, 
	 *
	 *sol) 스택사용한 O(N)
	 * */
	
	static int N, M;
	static String empty = "FRULA";
	static String str, bomb;
	static int bombLen;
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        str = br.readLine();
        bomb = br.readLine();
        bombLen = bomb.length();
        
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for(int i=0; i<str.length(); i++) {
        	char now = str.charAt(i);
        	// 스택이 bomb보다 길고, bomb의 마지막문자면 확인해보기
        	if(stack.size() >= bombLen-1 && now == bomb.charAt(bombLen-1)) {
        		
        		StringBuilder tmp = new StringBuilder();
        		boolean isBomb=true;
        		for(int b=bombLen-2; b>=0; b--) {
        			if(bomb.charAt(b) == stack.peek()) {
//        				System.out.println("지금삭제한거:  " + stack.peek());
        				tmp.append(stack.pop());
        				
        			}else {
        				isBomb = false;
        				break;
        			}
        		}
        		
        		// 만약 아니었으면 다시 스택에 집어넣기
        		if(!isBomb) {
        			char[] temp = tmp.reverse().toString().toCharArray();
        			for(char c : temp) {
//        				System.out.println("스택에다시넣는중 " + c);
        				stack.push(c);
        			}
        			stack.push(now);
        		}	
        	
        	}
        	else {
        		stack.push(now);
        	}
        	
        	
        }
        
        if(stack.isEmpty()) {
        	System.out.println("FRULA");
        	return;
        }
      
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()) {
        	ans.append(stack.pop());
        }
        
        System.out.println(ans.reverse());
       
    }
    

}
    