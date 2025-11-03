
import java.io.*;
import java.util.*;

public class Main {
	/*  
	 * 주의!! x,y,z,k가 같아도됨
	 * N=10^3
	 * 완탐x
	 * x+y = k-z
	 * 
	 * 1. N^2로 두개고른값의 sum 저장(중복값 포함)
	 * 2. arr, sum 둘 다 정렬
	 * 3. arr를 이중반복하면서 arr[i]-arr[j]가 sum에 존재할 경우 출력,
	 * 	이때, k가 최대가 되도록해야하므로 거꾸로반복하면서 최댓값출력 후 리턴하기
	 * 
	 * 
	 * */
	
	static int N;
	static int[] arr, sum;
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        sum = new int[N*N];
        
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
        		sum[i*N+j] = arr[i] + arr[j];
        	}
        }
        
        Arrays.sort(arr);
        Arrays.sort(sum);
        
        // arr를 이중 반복하면서, k - z = sum이 되는 k가 있으면 리턴
        for(int k=N-1; k>=0; k--) {
        	for(int i=0; i<=k; i++) {
        		int target = arr[k] - arr[i];

        		if(Arrays.binarySearch(sum, target) >= 0) {
        			System.out.println(arr[k]);
        			return;
        		}
        	}
        }
        
        
//        System.out.println();
    }
    

    

}

