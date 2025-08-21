import java.util.*;
import java.io.*;

/*
*/

class Solution {
    public class Work implements Comparable<Work>{
        int id;
        int requestAt;
        int workingTime;
        int endAt;
        
        public Work(int id, int requestAt, int workingTime, int endAt){
            this.id = id;
            this.requestAt = requestAt;
            this.workingTime = workingTime;
            this.endAt = endAt;
            
        }
        
        /*
        작업 소요시간 짧음 > 작업 요청시각 빠름 > 작업번호 작음 순
        */
        @Override
        public int compareTo(Work o){
            int result = Integer.compare(this.workingTime, o.workingTime);
            if(result != 0) return result;
            
            result = Integer.compare(this.requestAt, o.requestAt);
            if(result != 0) return result;
            
            result = Integer.compare(this.id, o.id);
            return result;
        }
    }
    
    public int solution(int[][] jobs) {
        
        PriorityQueue<Work> pq = new PriorityQueue<>();

        int time=0;
        int answer = 0;
        
        int size = jobs.length;
        int curr = 0;
        boolean nowWorking = false;
        boolean allRequested = false;
        int allProcessed = 0;
        Arrays.sort(jobs, (o1,o2)->Integer.compare(o1[0], o2[0]));
        
        Work now = null;
        
        // 시간 반복
        for(int i=0; i<1000000; i++){
            
            if(allProcessed == size) break;
            
            // 작업 요청된 프로세스 있는지 체크하고, 있으면 대기큐에 삽입
            while(!allRequested && curr < jobs.length && jobs[curr][0] == i){
                pq.add(new Work(curr, i, jobs[curr][1], 0));
                curr++;
                if(curr == jobs.length){
                    allRequested = true;
                }
            }
            
            // 현재 프로세스 실행중이면
            if(nowWorking){
                // 끝날떄 됐으면 nowWorking 바꾸기
                if(i>=now.endAt){
                    System.out.println("시간 : " + i + "에 프로세스번호 :  " + now.id + " 종료됨"); 
                    System.out.println("answer에 + " + (now.endAt - now.requestAt));

                    nowWorking = false;
                    answer += (now.endAt - now.requestAt);
                    allProcessed++;
                    
                }     
            }
            
            if(nowWorking) continue;
            
            // 실행되고있던 프로세스 끝났으면, 실행가능한 작업 있는지 확인
            if(!pq.isEmpty()){
                now = pq.poll();

                // 새로 시작할 프로세스의 끝날 시간 업데이트
                now.endAt = now.workingTime + i;
                System.out.println(now.id + " 번 프로세스 시작 " + "시간 : " + i + "끝날시간 : " + now.endAt);

                nowWorking = true;
            }

        }
        
        
        return answer/jobs.length;
    }
}