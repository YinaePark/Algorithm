import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        // lastkey, firstkey..
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        StringTokenizer st;
        for(String op : operations){
            st = new StringTokenizer(op);
            String command = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            // insert
            if(command.charAt(0)=='I'){
                map.merge(num, 1, Integer::sum);
                continue;
            }
            
            // 삭제연산
            if(map.isEmpty()) continue;
            
            // 최댓값 삭제
            if(num == 1){
                int max = map.lastKey();
                if(map.get(max) == 1) {
                    map.remove(max);
                }else{
                    map.merge(max, -1, Integer::sum);
                }
                continue;
            }
            // 최솟값 삭제
            if(num == -1){
                int min = map.firstKey();
                if(map.get(min) == 1) {
                    map.remove(min);
                }else{
                    map.merge(min, -1, Integer::sum);
                }
                continue;
            }
            
        }
        
        if(map.isEmpty()) {
            return new int[] {0,0};
        }
            
        
        int[] answer = new int[2];
        answer[0] = map.lastKey();
        answer[1] = map.firstKey();
        return answer;
    }
}