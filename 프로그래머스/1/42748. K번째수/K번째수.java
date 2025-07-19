import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int test_case = commands.length;
        int[] answer = new int[test_case];
        
        for(int i=0; i<test_case; i++){
            int start = commands[i][0];
            int end = commands[i][1];
            int target = commands[i][2];
            
            int[] newArr = Arrays.copyOfRange(array, start-1, end);
            Arrays.sort(newArr);
            answer[i] = newArr[target-1];
        }
        return answer;
    }
}