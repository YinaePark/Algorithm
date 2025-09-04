import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> pos = new ArrayList<>(); 
        List<Integer> neg = new ArrayList<>();  
        int ones = 0;                          
        int zeros = 0;                         

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x > 1) {
                pos.add(x);
            } else if (x == 1) {
                ones++;
            } else if (x == 0) {
                zeros++;
            } else {
                neg.add(x);
            }
        }

        pos.sort(Collections.reverseOrder());
        Collections.sort(neg);

        long ans = 0;

        // 1은 그냥 더함
        ans += ones;

        for (int i = 0; i + 1 < pos.size(); i += 2) {
            ans += pos.get(i) * pos.get(i + 1);
        }
        if (pos.size() % 2 == 1) {  // 홀수 개 남으면 마지막은 그냥 더하기
            ans += pos.get(pos.size() - 1);
        }

        // 음수 페어링
        for (int i = 0; i + 1 < neg.size(); i += 2) {
            ans += neg.get(i) * neg.get(i + 1);
        }
        if (neg.size() % 2 == 1) {  // 음수 하나 남음
            if (zeros == 0) {      // 0이 없으면 그냥 더하기
                ans += neg.get(neg.size() - 1);
            }
            // 0이 있으면 무시
        }

        System.out.println(ans);
    }
}
