
import java.io.*;
import java.util.*;

public class Main {
	/* 
	 *
	 * */
	
	// c=x r=y
	static int n,r,c;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		dnc(c, r, n, 0);
		
	}
	
	static void dnc(int x, int y, int n, int sum) {
		if(n==1) {
			
			System.out.println(sum + y*2 + x);
			return;
		}
		
		
		// 4개로 쪼갰을때 한 칸에 몇개있는지
		int unitCnt = (int)Math.pow(2, (n*2-2));
		// 한줄 길이
		int len = (int)Math.pow(2, n);
		
		int pos=3;
		// 몇번째칸인지?(0,1,2,3)
		if(x<len/2 && y<len/2) pos = 0;
		else if(x<len/2) {
			pos=2;
		}else if(y<len/2) {
			pos=1;
		}
		sum += (unitCnt * pos);
		
		// 해당 pos에서의 idx 찾기
		if(pos==1 || pos ==3) {
			x -= len/2;
		}
		if(pos==2 || pos ==3) {
			y -= len/2;
		}
	
		dnc(x, y, n-1, sum);
		
		
		
	}

}
