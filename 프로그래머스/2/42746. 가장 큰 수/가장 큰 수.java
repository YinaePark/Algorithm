import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        // numbers 배열을 string 배열로 저장
        ArrayList<String> list = new ArrayList<>();
        for(int num: numbers){
            list.add(String.valueOf(num));
        }
        
        // string 두개 붙인 것을 기준으로 내림차순 정렬
        list.sort((o1, o2) -> {
            int a = Integer.parseInt(o1+o2);
            int b = Integer.parseInt(o2+o1);
            return Integer.compare(b, a);
        });
        
        StringBuilder sb = new StringBuilder();
        for(String str : list){
            sb.append(str);
        }
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}