import java.util.*;
import java.io.*;

/*

boolean reports[i][N] -> 유저 i가 누구 신고했는지 표시
reported[i] -> 유저 i를 신고한사람목록(중복없이)

정지기준 k -> reported 길이 비교하고, 맞는애들 set에 넣기
*/
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int N = id_list.length;
        Map<String, Integer> userIdMap = new HashMap<>();
        for(int i=0; i<id_list.length; i++){
            userIdMap.put(id_list[i], i);
        }
        
        boolean[][] reports = new boolean[N][N];
        List<Integer>[] reported = new List[N];
        for(int i=0; i<N; i++){
            reported[i] = new ArrayList<>();
        }
        
        // 저장
        for(int i=0; i<report.length; i++){
            String[] users = report[i].split(" ");
            int user1 = userIdMap.get(users[0]);
            int user2 = userIdMap.get(users[1]);
            // 이미 user1이 user2를 신고했으면?
            if(reports[user1][user2]){
                continue;
            }
            
            reports[user1][user2] = true;
            reported[user2].add(user1);
        }
        // 정지기준 k <= reported 길이 비교
        Set<Integer> blockedUsers = new HashSet<>();
        for(int i=0; i<N; i++){
            if(reported[i].size() >= k){
                blockedUsers.add(i);
            }
        }
        
        // 각 유저가 신고한 유저들이 얼마나 차단됐는지 세기
        int[] answer = new int[N];
        for(int i=0; i<N; i++){
            int cnt = 0;
            for(int blockedUser : blockedUsers){
                if(reports[i][blockedUser]){
                    cnt++;
                }
            }
            answer[i] = cnt;
        }
        
        return answer;
    }
}