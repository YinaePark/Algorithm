import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums){
            map.merge(num, 1, Integer::sum);
        }
        
        int tot = nums.length;
        
        return Math.min(tot/2, map.size());
    }
}