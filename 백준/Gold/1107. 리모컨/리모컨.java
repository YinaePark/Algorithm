
import java.util.*;
import java.io.*;

public class Main {
    public static boolean[] isBroken = new boolean[10];

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 목표 채널
        int M = Integer.parseInt(br.readLine());  // 고장난 버튼 개수

        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int btn = Integer.parseInt(st.nextToken());
                isBroken[btn] = true;
            }
        }

        // 1. +, - 버튼만으로 이동하는 경우
        int answer = Math.abs(N - 100);

        // 2. 0 ~ 1,000,000까지 탐색
        for (int x = 0; x <= 1000000; x++) {
            if (isPossible(x)) {
                int press = String.valueOf(x).length(); // 숫자 버튼 누른 횟수
                int move = Math.abs(N - x);            // +, - 버튼 누른 횟수
                answer = Math.min(answer, press + move);
            }
        }

        System.out.println(answer);
    }

    public static boolean isPossible(int n) {
        if (n == 0) {
            return !isBroken[0];
        }
        while (n > 0) {
            int k = n % 10;
            if (isBroken[k]) return false;
            n /= 10;
        }
        return true;
    }
}