import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        int prev = arr[0];
        List<Integer> answer = new ArrayList<>();
        answer.add(prev);
        
        for(int i=1; i<arr.length; i++){
            if(prev == arr[i]) continue;
            prev = arr[i];
            answer.add(arr[i]);
        }
        
        
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}