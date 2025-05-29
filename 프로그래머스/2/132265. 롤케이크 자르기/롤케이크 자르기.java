import java.util.*;

class Solution {
    public int solution(int[] topping) {
        
        Set<Integer> mine = new HashSet<>();
        Map<Integer, Integer> yours = new HashMap<>();
        
        // 토핑 종류-개수 파악 O(N)
        for(int t : topping){
            yours.put(t, yours.getOrDefault(t, 0)+1); 
        }
        
        int tot = yours.size();
        
        // 배열에서 한구간씩 옮기면서 mine, yours 계산
        int cnt=0;
        
        for(int t : topping){
            // mine에 t 토핑 추가
            mine.add(t);
            if(yours.get(t) == 1){
                tot--;
            } else{
                yours.put(t, yours.get(t)-1); 
            }
            
            if(mine.size() == tot){
                cnt++;
                // System.out.println("토핑: " + t);
            }
            // System.out.println("mine size: " + mine.size());
            // System.out.println("your size: " + tot);
            // System.out.println("토핑 t: " + t + "는 " + yours.get(t));

        }
        
        
        return cnt;
    }
}