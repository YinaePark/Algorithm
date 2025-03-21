import java.util.ArrayList;
import java.util.ArrayDeque;



class Solution {
    public int solution(String begin, String target, String[] words) {
        int n = words.length + 2;
        int[][] adjArr = new int[n][n];
        ArrayList<String> w = new ArrayList<> ();
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        
        boolean isTargetInWords = false;
    for(String word : words) {
        if(word.equals(target)) {
            isTargetInWords = true;
            break;
        }
    }
    if(!isTargetInWords) return 0;
        
        // 새 String array 만들기
        w.add(begin);
        for(int i=0; i<words.length; i++){
            w.add(words[i]);
        }
        w.add(target);
        
        // adj arr 만들기
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j) continue;
                if(distWord(w.get(i), w.get(j)) == true){
                    adjArr[i][j] = 1;
                    adjArr[j][i] = 1;
                }
            }
        }
        
        // bfs
        // begin 넣기
        ArrayDeque<Integer> q = new ArrayDeque<> ();
        q.add(0);
        visited[0] = true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            for(int next=0; next<n; next++){
                if((visited[next] == false) && adjArr[next][now] == 1){
                    q.add(next);
                    dist[next] = dist[now] + 1;
                    visited[next] = true;
                }
            }
        }
        
        return dist[n-1];
    }
    
    private boolean distWord(String a, String b){
        int cnt = 0;
        for(int i=0; i<a.length(); i++){
            // 다른 개수 세기
            if(a.charAt(i) != b.charAt(i)) cnt++;
            if(cnt > 1) return false;
        }
        return cnt == 0 ? false : true;
        
    }
}