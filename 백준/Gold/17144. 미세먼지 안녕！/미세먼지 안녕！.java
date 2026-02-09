import java.io.*;
import java.util.*;

public class Main {
    static int R, C, T;
    static int[][] a;          // 현재 먼지 상태 + 공청기(-1)
    static int top = -1;       // 위쪽 공기청정기 행
    static int bottom = -1;    // 아래쪽 공기청정기 행
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    static void spread() {
        int[][] diff = new int[R][C]; 

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {

                if (a[r][c] <= 0) continue;
              
                int amount = a[r][c] / 5;
                if (amount == 0) continue; 

                int cnt = 0; 

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                    if (a[nr][nc] == -1) continue;

                    diff[nr][nc] += amount;
                    cnt++;
                }

                diff[r][c] -= amount * cnt;
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (a[r][c] == -1) continue; 
                a[r][c] += diff[r][c];
            }
        }
    }

    static void purify() {
        int r = top;

        for (int i = r - 1; i > 0; i--) a[i][0] = a[i - 1][0];

        for (int j = 0; j < C - 1; j++) a[0][j] = a[0][j + 1];
        
        for (int i = 0; i < r; i++) a[i][C - 1] = a[i + 1][C - 1];

        for (int j = C - 1; j > 1; j--) a[r][j] = a[r][j - 1];

        a[r][1] = 0;

        r = bottom;

        for (int i = r + 1; i < R - 1; i++) a[i][0] = a[i + 1][0];

        for (int j = 0; j < C - 1; j++) a[R - 1][j] = a[R - 1][j + 1];

        for (int i = R - 1; i > r; i--) a[i][C - 1] = a[i - 1][C - 1];

        for (int j = C - 1; j > 1; j--) a[r][j] = a[r][j - 1];

        a[r][1] = 0;

        a[top][0] = -1;
        a[bottom][0] = -1;
    }

    static int sumDust() {
        int sum = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (a[r][c] > 0) sum += a[r][c];
            }
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        a = new int[R][C];

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                a[r][c] = Integer.parseInt(st.nextToken());
                if (a[r][c] == -1) {
                    if (top == -1) top = r;
                    else bottom = r;
                }
            }
        }

        for (int t = 0; t < T; t++) {
            spread();   
            purify();   
        }

        System.out.println(sumDust());
    }
}
