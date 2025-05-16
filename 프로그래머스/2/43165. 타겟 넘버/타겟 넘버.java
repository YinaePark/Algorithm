import java.util.Arrays;
import java.util.ArrayDeque;

class Solution {
    boolean visited[];
    int n;
    int answer = 0;

    public int solution(int[] numbers, int target) {
        n = numbers.length;
        System.out.println("n : " + n);
        dfs(0, numbers[0], numbers, target);
        dfs(0, -numbers[0], numbers, target);

        return answer;
    }
    
    public void dfs(int start, int sum, int[] numbers, int target){
        if(start == n-1 && sum == target){
            answer++;
            return;
        }
        else if(start == n-1) return;
        
        int next = numbers[start+1];

         dfs(start+1, sum+next, numbers, target);
         dfs(start+1, sum-next, numbers, target);
    }
}