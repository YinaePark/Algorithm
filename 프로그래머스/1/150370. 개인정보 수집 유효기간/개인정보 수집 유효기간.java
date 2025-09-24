import java.util.*;
import java.io.*;

/*

*/

/* string[] 를 바로 int[]로
 Arrays.stream(st.nextToken().split("\\."))
           .mapToInt(Integer::parseInt)
           .toArray();
           
* Lst<Integer> 를 int[]로
list.stream().mapToInt(Integer::intValue).toArray();

*/



class Solution {
    static int benchMark;

    // 개월단위
    static int[] types = new int[26];
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        StringTokenizer st = new StringTokenizer(today);
        int[] todayNum = Arrays.stream(st.nextToken().split("\\."))
            .mapToInt(Integer::parseInt)
            .toArray();
        benchMark = todayNum[0] * 12 * 28 + todayNum[1] * 28 + todayNum[2];
        
        // terms에 몇개월인지 저장
        for(String t : terms){
            st = new StringTokenizer(t);
            String type = st.nextToken();
            int period = Integer.parseInt(st.nextToken());
            
            types[(type.charAt(0)) - 'A'] = period;
        }

        
        List<Integer> answer = new ArrayList<>();
        for(int i=1; i<=privacies.length; i++){
            st = new StringTokenizer(privacies[i-1]);
            int[] date = Arrays.stream(st.nextToken().split("\\."))
                .mapToInt(Integer::parseInt)
                .toArray();
            
            int type = st.nextToken().charAt(0) - 'A';
            
            boolean flag = isExpired(type, date[0] * 12 * 28 + date[1] * 28 + date[2]);
            if(!flag){
                answer.add(i);
            }
            
            
            
        }
    
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    
    static boolean isExpired(int termIdx, int day){
        // 더할 달을 날짜로 환산
        int add = types[termIdx] * 28;
        
        day += add;
        
        // System.out.println("벤치마크 " + benchmarkY + " " + benchmarkD);
        // System.out.println("환산결과 " + sy + " " + sd);

        
        if(day<=benchMark) return false;
        
        return true;
     }
}