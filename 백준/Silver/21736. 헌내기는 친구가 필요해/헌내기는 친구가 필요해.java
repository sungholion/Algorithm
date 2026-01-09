import java.io.*;
import java.util.*;

/*
- 캠퍼스(2차원 배열)에서 도연(I)의 위치에서 시작해서 빈 공간(O)로 BFS로 이동하며, P를 만나면 횟수 +1
- P가 0인 경우 TT

 */
class Main{
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =  new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map  = new char[N][M];
        visited = new boolean[N][M];
        int[] startPos = new int[2];
        for(int i = 0; i < N; i++){
            String str =  br.readLine();
            for(int j = 0; j < M; j++){
                char ch = str.charAt(j);
                map[i][j] = ch;
                if(ch == 'I') startPos = new int[]{i, j};
            }
        }

        int pCnt = bfs(startPos);
        if(pCnt == 0) sb.append("TT");
        else sb.append(pCnt);
        System.out.println(sb.toString());
    }

    static int bfs(int[] startPos){
        ArrayDeque<int[]> q =  new ArrayDeque<>();
        q.offer(startPos);
        visited[startPos[0]][startPos[1]] = true;

        int cnt = 0;
        while(!q.isEmpty()){
            int[] curPos = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = curPos[0] + dx[i];
                int ny = curPos[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) continue;
                if(map[nx][ny] == 'O' || map[nx][ny] == 'P'){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    if(map[nx][ny] == 'P') cnt++;
                }
            }
        }
        return cnt;
    }

}
