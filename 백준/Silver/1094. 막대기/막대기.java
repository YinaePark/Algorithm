
import java.io.*;
import java.util.*;

public class Main {
	/*
	 * */
	
	static int X;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        X = Integer.parseInt(st.nextToken());
        
        
        int cnt = 0;
        char[] result = toBit(X).toCharArray();
        for(int i=0; i<result.length; i++) {
        	if(result[i] == '1') {
        		cnt++;
        	}
        }
        
        System.out.println(cnt);

     
    }
    
    static String toBit(int X) {
    	StringBuilder sb = new StringBuilder();
    	while(X > 0) {
    		sb.append(X%2);
    		X /= 2;
    	}
    	return sb.reverse().toString();
    }
}

