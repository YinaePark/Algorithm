
import java.io.*;
import java.util.*;

public class Main {
	/*  
	 * 
	 * M = 10^2
	 * N = 10^4
	 * 
	 * 
	 * 좌표압축(NlogN)
	 * 1.행성정렬하기
	 * 2.binarySearch로 정렬된 배열에서 해당 배열의 값이 몇번쨰순윈지 찾기 
	 * 
	 * ==================
	 * 첨에 틀린점
	 * 1. A = [1,1,2], B = [1,2,2] 인 경우에도 정렬 인덱스 열이 같아져 잘못 같은 우주로 취급
	 * 2. 람다 Comparator 쓰면시간초과
	 * 
	 * */
	

	
	static int M, N;
	
	static int[][] arr, arrSorted, compressed;
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
       
        arr = new int[M][N];
        arrSorted = new int[M][N];
        compressed = new int[M][N];
        
        // O(M*N)
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<N; j++) {
        		int v = Integer.parseInt(st.nextToken());
        		arr[i][j] = v;
        		arrSorted[i][j] = v;
        		
        	}
        }
        Map<String, Integer> map = new HashMap<>();
        
        // M * (NlogN)
        for(int i=0; i<M; i++) {
        	// 값 오름차순, 동일값이면 idx 오름차순 정렬
        	Arrays.sort(arrSorted[i]);
        	for(int j=0; j<N; j++) {
        		compressed[i][j] = Arrays.binarySearch(arrSorted[i], arr[i][j]);
        		
        	}
        }
        
        int cnt=0;
        
        for(int i=0; i<M; i++) {
        	for(int j=i+1; j<M; j++) {
        		boolean flag = true;
        		for(int k=0; k<N; k++) {
        			if(compressed[i][k] != compressed[j][k]) {
        				flag=false;
        				break;
        			}
        		}
        		if(flag)
        			cnt++;
        	}
        }
        

        
        System.out.println(cnt);
    }
    

    

}

