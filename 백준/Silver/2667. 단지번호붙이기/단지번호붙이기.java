import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<Integer> list = new ArrayList<>();
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }


        int cnt = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    cnt++;
                    bfs(new int[]{i, j});
                }
            }
        }
        sb.append(cnt).append("\n");
        Collections.sort(list);
        for(int x : list)
            sb.append(x).append("\n");
        System.out.print(sb);
    }

    static void bfs(int[] point){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited[point[0]][point[1]] = true;
        q.offer(point);

        int cnt = 1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx >= N || nx < 0 || ny >= N || ny < 0) continue;
                if(map[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    cnt++;
                }
            }
        }
        list.add(cnt);
    }
}