

import java.util.*;
import java.io.*;

class Main
{
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		int len = str.length();
		char[] c = str.toCharArray();
		
		int numOfA=0;
		for(int i=0; i<len; i++) {
			if(c[i] == 'a') numOfA++;
		}
		
		// 슬라이딩 윈도우
		// 0~numOfA-1까지 반복,
		// idx가 len 넘어가면
		// idx~len-1, 0~(numOfA - (len-idx) - 1)
		
		int minNumOfB = 0;
		int numOfB=0;
		
		for(int i=0; i<numOfA; i++) {
			if(c[i] == 'b') {
				minNumOfB++;
				numOfB++;
			}
		}
		
		StringBuilder st = new StringBuilder();
		StringBuilder second = new StringBuilder(str);
		second.deleteCharAt(str.length()-1);
		st.append(str);
		st.append(second);
		String finalString = st.toString();
		char[] finalCArr = finalString.toCharArray();
		
		for(int idx=1; idx<finalCArr.length-numOfA; idx++) {
			
			if(finalCArr[idx-1] == 'b') {
				numOfB--;
			}
			if(finalCArr[idx+numOfA-1] == 'b') {
				numOfB++;
			}
			if(numOfB<minNumOfB) minNumOfB = numOfB;
			
			
		}
		
		bw.write(minNumOfB+"");
		bw.flush();
		bw.close();
		br.close();
	}
	

	
}
