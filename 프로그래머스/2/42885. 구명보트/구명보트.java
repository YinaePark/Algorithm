import java.util.*;

/*


*/
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int i : people){
            map.merge(i, 1, Integer::sum);
        }
        
        
        while(!map.isEmpty()){
            answer++;
            
            // 제일 무게 나가는 사람 태우기
            int max = map.lastKey();
            if(map.get(max) == 1){
                map.remove(max);
            }else{
                map.merge(max, -1, Integer::sum);
            }
            
            int remainWeight = limit - max;
            
            if(!map.isEmpty()){
                int min = map.firstKey();
                
                // 최소인 사람 못 태우면 break;
                if(remainWeight - min < 0){
                    continue;
                }
                // 최소인 사람 태울 수 있으면 태우고 더 태울수 있는지 확인
                if(map.get(min) == 1){
                    map.remove(min);
                }else{
                    map.merge(min, -1, Integer::sum);
                }
                remainWeight -= min;
            }
            
        }
        
        
        
        return answer;
    }
}