import java.util.*;
import java.io.*;

class Solution {
    // static boolean[] isPrime = new boolean[10000001];
    
    public int solution(int n, int k) {
        // findPrime();
        
        String[] nums = getKnum(n,k).split("0");
        int answer = 0;
        
        for(String num : nums) {
            if(num.compareTo("") == 0) continue;
            long intNum = Long.parseLong(num);

            // if(isPrime[intNum]){
            if(isPrime(intNum)){
                answer++;
            } 
        }
        
        
        return answer;
    }
    
    static boolean isPrime(long num){
        if(num<=1) return false;
        for(long i=2; i*i<=num; i++){
            if(num%i == 0) return false;
        }
        return true;
    }
    // isPrime 업데이트
//     static void findPrime(){
//         Arrays.fill(isPrime, true);
//         isPrime[0] = false;
//         isPrime[1] = false;
        
//         // 제곱근까지만 반복
//         for(int i=2; i*i<=10000000; i++){
//             if(!isPrime[i]) continue;
//             // 소수들의 배수를 없애기
//             for(int j=i*i; j<=10000000; j=j+i){
//                 isPrime[j] = false;
//             }
//         }
//     }
    
    
    // n을 K진수로 바꾸기
    /*
     몫이 k로 나눌수 없을 때까지 나누고, 
     마지막 남은 몫과 나누는과정에서의 나머지들
    */
    static String getKnum(int n, int k){
        int num = n;
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            int remain = num % k;
            num = num/k;
            sb.append(remain);
        }
        if(num != 0){
            sb.append(num);
        }
        
        sb.reverse();
        return sb.toString();
    }
    
}



