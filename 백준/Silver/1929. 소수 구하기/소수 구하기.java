
import java.util.*;
import java.io.*;


public class Main {
	/*
	 * 에라토스테네스의 체 :
	 * sqrt(N) 까지만 확인,
	 * prime인 경우만 배수 체크
	 * */
	
	public static int M, N;
	public static boolean[] isPrime;

	
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		isPrime = new boolean[N+1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		checkPrime(N);
		
		for(int i=M; i<=N; i++) {
			if(isPrime[i]) {
				System.out.println(i);
			}
		}
		
		
	}
	
	public static void checkPrime(int N) {
		// 루트N까지만 체크해도됨 
		for(int i=2; i*i<=N; i++) {
			if(isPrime[i]) {
				// 2*i 부터하지 않아도 됨(이미 최적화되어있음)
				for(int j=i*i; j<=N; j+=i) {
					isPrime[j] = false;
				}
			}
		}
	}
	
}
