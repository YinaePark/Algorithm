import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int w, h;
        w = (brown-2)/2;
        
        while(w>0){
            if((brown - 2*w)%2 != 0) continue;
            h = (brown - 2*w)/2 + 2;
            if(yellow == (w-2)*(h-2)){
                answer[0] = h;
                answer[1] = w;
            }
            w--;
        }
        
        return answer;
    }
}

/**
가로 w 세로 h라고 하면,
brown 개수 = 2*w + (h-2)*2
yellow 개수 = (w-2) * (h-2)
**/

