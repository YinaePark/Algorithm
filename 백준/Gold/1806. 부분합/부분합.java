
import java.util.*;
import java.io.*;


public class Main {
	
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		int N, S;
		
		N = sc.nextInt();
		S = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		//투포인터,
		// start ~ end-1까지
		int sum=arr[0];
		int start = 0;
		int end = 1;
		int minLen = Integer.MAX_VALUE;
		
		
		while(true) {
			
			// S보다 크면, start를 오른쪽으로 옮김
			if(sum>=S) {
				minLen = Math.min(minLen, end-start);
				sum -= arr[start];
				start++;
				continue;
			}
			if(end >= N) {
				break;
			}
			else {
				sum += arr[end];
				end++;
			}
		}
		
        System.out.println((minLen == Integer.MAX_VALUE) ? 0 : minLen);
		
	}
	
}
