class Solution {
    
    // powArr[i] == 5^i
    public int[] powArr = {1, 5, 25, 125, 625, 3125};
    
    public int solution(String word) {
        char[] arr = word.toCharArray();
        int answer = 0;
        
        for(int i=0; i<arr.length; i++){
            int plus=0;
            for(int j=0; j<5-i; j++){
                plus += powArr[j];
            }
            // System.out.println("이건 i" + i + "v플러스는... " + plus);
            switch(arr[i]){
                case 'A':
                    break;
                case 'E':
                    answer += plus;
                    break;
                case 'I':
                    answer += plus * 2;
                    break;
                case 'O':
                    answer += plus * 3;
                    break;
                case 'U':
                    answer += plus * 4;
                    break;
            }
            answer += 1;
            // System.out.println(i + " 번째 글자에서 이만큼.. " + answer);
        }
        
        return answer;
    }
}