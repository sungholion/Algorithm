import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int H = N;
        int W = 2 * N - 1;

        map = new char[H][W];
        for (int i = 0; i < H; i++) {
            Arrays.fill(map[i], ' ');
        }

        draw(0, N - 1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < H; i++) {
            sb.append(map[i]).append('\n');
        }
        System.out.print(sb);
    }

    static void draw(int r, int c, int n) {
        if (n == 3) {
            map[r][c] = '*';
            map[r + 1][c - 1] = '*';
            map[r + 1][c + 1] = '*';
            for (int j = c - 2; j <= c + 2; j++) {
                map[r + 2][j] = '*';
            }
            return;
        }

        int half = n / 2;
        draw(r, c, half);

        draw(r + half, c - half, half);

        draw(r + half, c + half, half);
    }
}
