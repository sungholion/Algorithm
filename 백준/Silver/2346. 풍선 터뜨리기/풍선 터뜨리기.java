import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) dq.offer(new int[]{i, Integer.parseInt(st.nextToken())});

        // 첫 번째 풍선부터 터뜨리기
        while (!dq.isEmpty()) {
            int[] now = dq.pollFirst(); // 맨 앞 풍선 터뜨림
            sb.append(now[0]).append(" "); // 풍선 번호 출력
            if (dq.isEmpty()) break; // 다 터졌으면 종료

            int move = now[1];
            if (move > 0) {
                for (int i = 0; i < move - 1; i++) {
                    dq.offerLast(dq.pollFirst());
                }
            } else {
                for (int i = 0; i < Math.abs(move); i++) {
                    dq.offerFirst(dq.pollLast());
                }
            }
        }

        System.out.print(sb);
    }
}