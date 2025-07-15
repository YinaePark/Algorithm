import java.util.*;

class Solution {
    Map<String, List<String>> map = new HashMap<>();
    int totalTicket;
    List<String> answer = new ArrayList<>();
    
        
    public String[] solution(String[][] tickets) {
        totalTicket = tickets.length;
        // map: 출발지 - 도착지리스트 
        for(String[] ticket : tickets){
            map.putIfAbsent(ticket[0], new ArrayList<>());
            map.get(ticket[0]).add(ticket[1]);
        }
        
        // 각 출발지별로 목적지를 알파벳 순으로 정렬
        for(String key : map.keySet()) {
            Collections.sort(map.get(key));
        }
        
        answer.add("ICN");
        dfs(1, "ICN");
        
        return answer.toArray(new String[0]);
    }
    
    public boolean dfs(int depth, String start){
        // 티켓을 모두 썼을 경우 종료
        if(depth == totalTicket+1) {
            return true;
        }
        if(!map.containsKey(start) || map.get(start).isEmpty()) {
            return false;
        }
        
        
        for(int i = 0; i < map.get(start).size(); i++){
            // 현재 출발지의 티켓목록을 조회
            String dest = map.get(start).get(i);
            
            map.get(start).remove(i);  // 인덱스로 제거
            answer.add(dest);
            
            if(dfs(depth + 1, dest)){
                return true;
            }
            
            map.get(start).add(i, dest);  // 원래 위치에 복구
            answer.remove(answer.size() - 1);
        }
        
        
        return false;
    }
    
}