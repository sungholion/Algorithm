import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int w = 0, b = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);
        System.out.println(w);
        System.out.println(b);
    }

    static void divide(int x, int y, int size) {
        if (checkSameColor(x, y, size)) {
            if (map[x][y] == 0) w++;
            else b++;
            return;
        }

        int half = size / 2;
        divide(x, y, half);                  
        divide(x, y + half, half);           
        divide(x + half, y, half);           
        divide(x + half, y + half, half);    
    }

    static boolean checkSameColor(int x, int y, int size) {
        int color = map[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != color) return false;
            }
        }
        return true;
    }
}
