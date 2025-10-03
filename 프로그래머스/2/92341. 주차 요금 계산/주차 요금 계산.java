import java.io.*;
import java.util.*;

/*
Math.ceil할떄 소숫점안버리게 조심
*/

class Solution {
   
    static int basicTime, basicFee, unitTime, unitFee;
    static int endTime = 23 * 60 + 59;
    
    // 차번호 , 누적요금
    static Map<Integer, Integer> map = new TreeMap<>();
    
    public int[] solution(int[] fees, String[] records) {
        basicTime = fees[0];
        basicFee = fees[1];
        unitTime = fees[2];
        unitFee = fees[3];
        
        // 시간(숫자), 차량번호(숫자), in=0 out=1
        int[][] newRecords = new int[records.length][3];
        
        for(int i=0; i<records.length; i++){
            String record = records[i];
            String[] r = record.split(" ");
            
            int[] newRecord = new int[3];
            newRecord[0] = parseTime(r[0]);
            newRecord[1] = Integer.parseInt(r[1]);
            newRecord[2] = r[2].charAt(0) == 'I' ? 0 : 1;
            
            newRecords[i] = newRecord;
            
        }
        
        // 차량번호순, 차량번호같으면 시간빠른순
        Arrays.sort(newRecords, (a,b)->(a[1]==b[1] ? a[0]-b[0] : a[1]-b[1]));
        
        
        // 차량기록순으로 2개씩끊어서 calcFee 호출. 이때 같은차에대해기록 홀수개면 마지막은 23:59dla
        for(int i=0; i<newRecords.length; i++){
            
            // in이 마지막 기록이거나, 다음 차가 이번차랑 다른 경우
            if((i+1 == newRecords.length) || newRecords[i+1][1] != newRecords[i][1]){
                cumulTime(newRecords[i][1], newRecords[i][0], endTime);
                
                continue;
            }
            // 아니면 두개씩 계산하고, i++하기
            cumulTime(newRecords[i][1], newRecords[i][0], newRecords[i+1][0]);
            i+=1;
        }
        
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        int i=0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int cumulativeTime = entry.getValue();
            int finalFee = basicFee;
            if(cumulativeTime > basicTime){
                finalFee += (int)Math.ceil((double)(cumulativeTime - basicTime) / (double)unitTime) * unitFee;
            }
            answer.add(finalFee);
            i++;
        
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    // 시간을 분으로 환산
    static int parseTime(String time){
        String[] times = time.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }
    
    // in/out 기록 받아서 누적시간계산
    static void cumulTime(int carNum, int inTime, int outTime){
        int stayTime = outTime - inTime;
        map.merge(carNum, stayTime, Integer::sum);
    }
    
    
}