import java.io.*;
import java.util.*;

public class Main {
    
    static boolean[][] map = new boolean[101][101];
    static int[] dx = {0, -1, 0, 1};    // 우, 상, 좌, 하
    static int[] dy = {1, 0, -1, 0};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
    
        int n = Integer.parseInt(br.readLine());
        
        for(int loop = 0; loop < n; loop++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            dragonCurve(x, y, d, g);
        }
        
        int ans = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1])
                    ans++;
            }
        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    static void dragonCurve(int x, int y, int d, int g) {
        List<Integer> dirList = new ArrayList<>();
        dirList.add(d);
        
        for(int i=1; i<= g; i++) {
            for(int j = dirList.size() - 1; j>=0; j--) {
                dirList.add((dirList.get(j) + 1) % 4);
            }
        }
        
        map[x][y] = true;
        for (int dir : dirList) {
            x += dx[dir];
            y += dy[dir];
            map[x][y] = true;
        }
    }
}
