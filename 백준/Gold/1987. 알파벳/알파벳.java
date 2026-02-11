import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[] word = new boolean[26];
    static int ans = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for(int i = 0; i < R; i++){
            String str = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = str.charAt(j);
            }
        }

        dfs(0, 0, 1); // 시작칸도 포함
        System.out.print(ans);
    }

    static void dfs(int x, int y, int depth){
        char ch = map[x][y];
        int idx = ch - 'A';
        if(word[idx]) return;

        word[idx] = true;
        ans = Math.max(ans, depth);

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            dfs(nx, ny, depth + 1);
        }
        word[idx] = false;
    }

}
