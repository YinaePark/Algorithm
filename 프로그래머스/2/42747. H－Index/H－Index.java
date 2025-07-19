import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for(int i=0; i<n; i++){
            // h = citations[i] = 인용된 개수
            // h번 이상 인용된 논문 개수 = i번~n-1까지 >= h
            // 나머지
            if(n-i <= citations[i]){
                
                return n-i;
            }
        }
        return 0;
    }
}