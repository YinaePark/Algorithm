import java.util.*;

class Solution {
    	public static boolean[] isPrime = new boolean[10000000];
	public static char[] arr;
	public static boolean[] visited;
	public static Set<Integer> set = new HashSet<>();
	
    
    public int solution(String numbers) {
        
		arr = numbers.toCharArray();
		
		int len = arr.length;
		visited = new boolean[len];
		
		fillPrime();
		
		for(int i=1; i<=len; i++) {
			dfs(0, i, "");
		}
		
		int count = 0;
		for(int num : set) {
			if(isPrime[num]) count++;
		}
		
        return count;
    }
    // 백트래킹으로...
	public static void dfs(int depth, int goalLen, String curr) {
		if(depth == goalLen) {
			set.add(Integer.parseInt(curr));
			return;
		}
		for(int i=0; i<arr.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(depth+1, goalLen, curr+arr[i]);
				visited[i] = false;
			}
		}
	}
    // 소수 판별 (최대 : 10^7)
	public static void fillPrime() {
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		for(int i = 2; i<Math.sqrt(10000000); i++) {
			// 소수라면, 배수를 모두 false처리. 이때, 그 이하수는 모두 검사햇으므로 i*i 부터 
			if(isPrime[i]) {
				for(int j=i*i; j<10000000; j+=i) {
					isPrime[j] = false;
				}
			}
		}
	}
}