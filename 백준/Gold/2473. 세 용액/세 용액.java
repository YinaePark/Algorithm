import java.io.*;
import java.util.*;

public class Main {
	/*  주어진 수의 합이 제일 0에 가까운 것 찾기
	 * 10^9만큼임
	 * 
	 * 다른문제(일반적인) 풀이
	 * 1. 2개 합을 먼저 구해서 정렬
	 * 2. 원래 배열에서 2개합과 더해서 0에 제일가까운 값을 이진탐색으로 찾기
	 * -> N^2logN
	 * ====
	 * 
	 * 다른 풀이
	 * N개의 용액 각각에대해 다른 두개의 용액을 투포인터로 구하기
	 * k라는 용액에 대해, left = k+1 right = N-1
	 * 
	 * 
	 *
	 * */
	
	static int N;
	static int[] arr;
	
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       N = Integer.parseInt(st.nextToken());
       arr = new int[N];
       st = new StringTokenizer(br.readLine());
       for(int i=0; i<N; i++) {
    	   arr[i] = Integer.parseInt(st.nextToken());
    	 
       }
       Arrays.sort(arr);
       int[] answer = new int[3];
       long result = Long.MAX_VALUE;
       
       
       for(int i=0; i<N-1; i++) {
    	   int left = i+1;
    	   int right = N-1;
    	   while(left < right) {
    		   
    		   long tmp = (long)arr[i] + arr[right] + arr[left];
    		   if(result > Math.abs(tmp)) {
    			   answer[0] = i;
    			   answer[1] = left;
    			   answer[2] = right;
    			   result = Math.abs(tmp);
    		   }
    		   if(tmp == 0) {
    			   for(int num : answer) {
    		    	   System.out.print(arr[num]+" ");
    		       }
    			   return;
    		   }
    		   
    		   if(tmp > 0) {
    			   right--;
    			   continue;
    		   }
    		   
    		   left++;
    		   
    		
    		   
    		   
    		   
    	   }
       }
       
       
       for(int i : answer) {
    	   System.out.print(arr[i]+" ");
       }
       
    }
    

}

