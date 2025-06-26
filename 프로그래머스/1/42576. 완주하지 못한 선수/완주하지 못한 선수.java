import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> name = new HashMap<>();
        
        // for(int i=0; i<c.length; i++){
        //     name.put(participant[i], name.computeIfAbsent(participant[i], k->0) + 1);
        // }
        // merge 이용
        for(String str : participant){
            name.merge(str, 1, Integer::sum);
        }
        
        for(String str : completion){
            name.merge(str, -1, Integer::sum);
        }
        
        for(Map.Entry<String, Integer> e : name.entrySet()){
            if(e.getValue() > 0) return e.getKey();
        }
        return "";
    }
}