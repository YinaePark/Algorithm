import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String[] c : clothes){
            map.merge(c[1], 1, Integer::sum);
        }
        
        int result = 1;
        for(Map.Entry<String, Integer> type : map.entrySet()){
            result *= (type.getValue()+1);
        }
        return result-1;
    }
}