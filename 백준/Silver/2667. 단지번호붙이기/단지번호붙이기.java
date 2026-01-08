import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] map;
    static boolean[][] visted;
    static ArrayList<Integer> houseCnt =  new ArrayList<>();
    static int totalCnt;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =  new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visted = new boolean[N][N];
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                char ch = str.charAt(j);
                map[i][j] = ch;
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == '1' && !visted[i][j]){
                    totalCnt++;
                    houseCnt.add(bfs(i, j));
                }
            }
        }
        sb.append(totalCnt).append("\n");
        Collections.sort(houseCnt);
        for(int i = 0; i < totalCnt; i++){
            sb.append(houseCnt.get(i)).append("\n");
        }
        System.out.println(sb.toString());
    }

    static int bfs(int x, int y){
        ArrayDeque<int[]> q =  new ArrayDeque<>();
        q.offer(new int[]{x, y});
        visted[x][y] = true;
        int cnt = 1;

        while(!q.isEmpty()){
            int[] cur =  q.poll();
            for(int i = 0; i < 4; i++){
                int nx =  cur[0] + dx[i];
                int ny =  cur[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(map[nx][ny] == '1' && !visted[nx][ny]){
                    visted[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
