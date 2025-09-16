
import java.util.*;
import java.io.*;


public class Main {
	/*
	 * 투포인터 
	 * - 일단 에라토스테네스의 체로 소수 구해놓기
	 * - 포인터 0,1부터시작해서, 소수 아니거나 N보다 커지면 이동
	 * - n보다 커져도 줄어들수도있으니까..
	 * 
	 * 예상반례
	 * - 숫자커져서 end,start가 오버플로우
	 * 
	 * */
	
	static int N;
	static boolean[] isPrime = new boolean[4000002];
	static int cnt=0;


	public static void main(String args[]) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		
		Arrays.fill(isPrime, true);
		findPrime();
		
		// 현재 
		int start=2;
		int end=2;
		int sum=2;
		
		while(true) {
			// 만들 수 있으면 카운트 늘리고, 다음 소수가 N보다 작으면 추가하기
			if(sum == N) {
				cnt++;
				if(end <= N) {
					end++;
					while(end <= N && !isPrime[end]) {
						end++;
					}
					sum += end;
				} else {
					break;
				}
//				System.out.println("카운트 추가됨 : " + start + " " + end + " sum " + sum);
				continue;
			}
			
			// 이미 합이 N보다 크면 맨 왼쪽소수를 빼보기
			if(sum > N) {
				
				sum -= start;
				start++;
				while(start <= N && !isPrime[start]) {
					start++;
				}
				
				if(end < start) break;
				
//				System.out.println("이미 합이 N보다 커서 start뻄 : " + start + " " + end +  " sum " + sum);
				continue;
			}
			
			// 다 탐색했으면...
			if(end < start) break;
			
			// 합이 N보다 작으면 다음 소수도 넣어보기
			if(sum < N) {
				end++;
				while(end <= N && !isPrime[end]) {
					end++;
				}
				
				sum += end;
			}
			
		}
		
		
		System.out.println(cnt);
		
		
	}
	
	static void findPrime() {
		isPrime[0] = false;
		isPrime[1] = false;
		
		for(int i=2; i<2002; i++) {
			if(!isPrime[i]) continue;
			for(int j=i*i; j<4000002; j+=i) {
				isPrime[j] = false;
			}
		}
	}
	
}

