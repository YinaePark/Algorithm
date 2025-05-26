import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
       int n = nums.length;

        // 숫자, 원래 인덱스 저장
        Map<Integer, Integer> map = new HashMap<>();


        int[] result = new int[2];

        for(int i=0; i<n; i++){
        	
            int complement = target - nums[i];
            System.out.println("c: " + complement);
            if(map.containsKey(complement)){
            	result[0] = map.get(complement);
                result[1] = i;
                break;
            }
            else{
                map.put(nums[i], i);
            }
        }
    
        
        return result;
    }
}