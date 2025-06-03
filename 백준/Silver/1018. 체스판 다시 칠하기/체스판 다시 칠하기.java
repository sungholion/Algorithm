import java.io.*;
import java.util.*;

public class Main {
   public static boolean[][] board;
   public static int min = 64;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        board = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                if(str.charAt(j) == 'W')
                    board[i][j] = true;
                else
                    board[i][j] = false;
            }
        }

        int row = N - 7;
        int col = M - 7;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                chess(i, j);
            }
        }
        sb.append(min).append("\n");

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void chess(int x, int y) {
        int end_x = x + 8;
        int end_y = y + 8;
        int cnt = 0;

        boolean tf = board[x][y];    // 첫 칸 색깔

        for(int i = x; i < end_x; i++) {
            for(int j = y; j < end_y; j++) {

                if(board[i][j] != tf)
                    cnt++;

                tf = (!tf);
            }

            tf = (!tf);
        }

        cnt = Math.min(cnt, 64 - cnt);  // 시작이 B일 때와, W일 때 비교

        min = Math.min(min, cnt);
    }
}
