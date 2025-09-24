import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int n = truck_weights.length;
        int time = 0, idx = 0, curW = 0;

        // 큐 원소: {트럭무게, 퇴장시각}
        Queue<int[]> q = new ArrayDeque<>();

        while (idx < n || !q.isEmpty()) {
            time++;

            // 1) 먼저 나갈 트럭 처리 (이번 초에 퇴장하는 트럭)
            while (!q.isEmpty() && q.peek()[1] == time) {
                curW -= q.poll()[0];
            }

            // 2) 다음 트럭 진입 시도 (무게/길이 제한 모두 확인)
            if (idx < n && curW + truck_weights[idx] <= weight && q.size() < bridge_length) {
                curW += truck_weights[idx];
                q.offer(new int[]{truck_weights[idx], time + bridge_length});
                idx++;
            }
        }

        return time;
    }
}
