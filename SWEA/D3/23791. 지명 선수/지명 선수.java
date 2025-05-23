/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    static boolean[] picked;
    static int[] teamA;
    static int[] teamB;
    static char[] result;
    static int idxA;
    static int idxB;
    static char c;
    static int tot;
        
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            
            // 개수
			int n = sc.nextInt();
            // sc.nextLine();
            picked = new boolean[n+1];
            teamA = new int[n+1];
            teamB = new int[n+1];
            result = new char[n+1];

            
            // 선호선수정보저장
            for(int i=1; i<=n; i++){
            	teamA[i] = sc.nextInt();
                // System.out.println(teamA[i]);
            }
            for(int i=1; i<=n; i++){
            	teamB[i] = sc.nextInt();
                // System.out.println(teamB[i]);

            }

            idxA = 1;
           	idxB = 1;
            // 뽑힌선수 수
            tot = 0;
            
            while(tot < n){
                int backNum = teamA[idxA];
                // 이미 뽑혔으면
                if(picked[backNum]){
                    idxA++;
                    continue;
                }
                else{
                	result[backNum] = 'A';
                    picked[backNum] = true;
                    tot++;
                    idxA++;
                }
                while(idxB<=n){
                    backNum = teamB[idxB];
                    if(picked[backNum]){
                        idxB++;
                        continue;
                    }
                    result[backNum] = 'B';
                    picked[backNum] = true;
					tot++;
                    idxB++;
                    break;
                }
            }
            
            for(int i=1; i<=n; i++){
                System.out.print(result[i]);
            }
            System.out.println();
        }
	}
    
   
}