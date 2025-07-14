import java.util.*;
import java.util.stream.Collectors;


class Solution {
    // 장르 별 총 재생횟수 
    Map<String, Integer> genreTotalPlays = new HashMap<>();
    // 장르별 노래목록
    Map<String, List<Song>> genereSonglist = new HashMap<>();
    
    public class Song implements Comparable<Song>{
        int idx;
        int plays;
        
        public Song(int idx, int plays){
            this.idx = idx;
            this.plays = plays;
        }
        
        @Override
        public int compareTo(Song other){
            if(this.plays != other.plays){
                return Integer.compare(other.plays, this.plays);
            }
            return Integer.compare(this.idx, other.idx);
        }
        
    }
    
    public int[] solution(String[] genres, int[] plays) {
        // 자료구조채우기
        for(int i=0; i<genres.length; i++){
            String g = genres[i];
            genreTotalPlays.merge(g, plays[i], Integer::sum);
            // 이미 저장 리스트가 있다면 해당 리스트 반환, 아니면 새로 생성
            List<Song> list = genereSonglist.computeIfAbsent(g, k -> new ArrayList<>());
            list.add(new Song(i, plays[i]));
        }
        
        // 장르를 재생횟수별로 정렬 -> O(g log g)
        List<String> sortedGenres = genreTotalPlays.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
        
        // 결과 선언
        List<Integer> result = new ArrayList<>();
        
        // 각 장르별로 노래 선정 
        for(String g : sortedGenres){
            List<Song> songList = genereSonglist.get(g);
            if(songList.size() == 1){
                result.add(songList.get(0).idx);
                continue;
            }
            // 정렬
            Collections.sort(songList);
            for(int i=0; i<2; i++){
                result.add(songList.get(i).idx);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}