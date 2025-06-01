
import java.util.*;
import java.io.*;

class Main
{
	
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer st = new StringTokenizer(br.readLine());
		
		String str = br.readLine();
		
		int i=1;
		int strPointer = 0;
		while(true) {
			
			String token = Integer.toString(i);
			char[] chs = token.toCharArray();
			
			
			for(char c : chs) {
				if(strPointer == str.length()) break;
				if(c == str.charAt(strPointer)) {
					strPointer++;
				}
			}
			i++;
			
			if(strPointer == str.length()) {
				bw.write(i-1+"");
				// System.out.println(i);
				break;
			}
			
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
	

	
}
