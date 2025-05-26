class Solution {
    int deletedZeroCnt = 0;
    int transCnt = 0;
    
    public int[] solution(String s) {
        
        while(!s.equals("1")){
            char[] arr = s.toCharArray();
            int tmp=0;
            // 0 개수 카운트
            for(int i=0; i<arr.length; i++){
                if(arr[i] == '0'){
                    tmp++;
                }
            }
            // 삭제할 0 개수
            deletedZeroCnt += tmp;
            
            // x의 길이 c
            int xLength = arr.length - tmp;
            
            // s는 다시 x의 길이 c를 2진법으로 표현한 문자열
            s = Integer.toBinaryString(xLength);
            transCnt++;
        }
        
        int[] answer = new int[2];
        answer[1] = deletedZeroCnt;
        answer[0] = transCnt;
        return answer;
    }
}