import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] arr = new int[n + 1]; // 0..n

        for (int x : lost)    arr[x] -= 1; // -1
        for (int x : reserve) arr[x] += 1; // +1 (겹치면 0)

        for (int i = 1; i <= n; i++) {
            if (arr[i] == -1) {
                if (i > 1 && arr[i - 1] == 1) {        // 왼쪽 먼저 (경계 먼저 체크!)
                    arr[i] = 0; arr[i - 1] = 0;
                } else if (i < n && arr[i + 1] == 1) { // 오른쪽 (경계 먼저 체크!)
                    arr[i] = 0; arr[i + 1] = 0;
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) if (arr[i] >= 0) cnt++;
        return cnt;
    }
}
