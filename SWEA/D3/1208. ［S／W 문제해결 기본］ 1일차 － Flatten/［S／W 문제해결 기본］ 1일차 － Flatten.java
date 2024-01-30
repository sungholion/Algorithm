import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            // 입력부
            int n = Integer.parseInt(br.readLine()); // dump 횟수
            int[] h = new int[100]; // 상자 높이 배열 100개
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100; i++)
                h[i] = Integer.parseInt(st.nextToken());

            int ans = 0;
            for (int cnt = n; cnt > 0; cnt--) {
                int max_h = h[0]; int min_h = h[0];
                int max_h_idx = 0; int min_h_idx = 0;

                // 가장 높은 상자와 가장 낮은 상자 찾기
                for (int i = 0; i < 100; i++) {
                    if (h[i] > max_h) {
                        max_h = h[i];
                        max_h_idx = i;
                    }
                    if (h[i] < min_h) {
                        min_h = h[i];
                        min_h_idx = i;
                    }
                }

                // 높이 조절
                h[max_h_idx]--;
                h[min_h_idx]++;

                // 높이 차이 갱신
                max_h = h[0];
                min_h = h[0];
                for (int i = 0; i < 100; i++) {
                    if (h[i] > max_h) {
                        max_h = h[i];
                    }
                    if (h[i] < min_h) {
                        min_h = h[i];
                    }
                }

                // 높이 차이 갱신
                ans = max_h - min_h;

                // 높이 차이가 1 이하면 더 이상 덤프할 필요 없음
                if (ans <= 1)
                    break;
            }

            // 출력
            System.out.println("#" + t + " " + ans);
        }
    }
}
