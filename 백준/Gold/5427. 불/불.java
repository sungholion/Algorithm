import java.io.*;
import java.util.*;

public class Main {
    static int w, h;
    static char[][] map;
    static int[][] fireTime;
    static int[][] personTime;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            fireTime = new int[h][w];
            personTime = new int[h][w];

            ArrayDeque<int[]> fireQ = new ArrayDeque<>();
            ArrayDeque<int[]> personQ = new ArrayDeque<>();

            for (int i = 0; i < h; i++) {
                String str = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = str.charAt(j);
                    fireTime[i][j] = -1;
                    personTime[i][j] = -1;

                    if (map[i][j] == '*') {
                        fireQ.offer(new int[]{i, j});
                        fireTime[i][j] = 0;
                    } else if (map[i][j] == '@') {
                        personQ.offer(new int[]{i, j});
                        personTime[i][j] = 0;
                    }
                }
            }

            // 1. 불 BFS
            while (!fireQ.isEmpty()) {
                int[] cur = fireQ.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = cur[0] + dx[i], ny = cur[1] + dy[i];
                    if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                    if (map[nx][ny] == '#' || fireTime[nx][ny] != -1) continue;
                    fireTime[nx][ny] = fireTime[cur[0]][cur[1]] + 1;
                    fireQ.offer(new int[]{nx, ny});
                }
            }

            // 2. 사람 BFS 
            int result = -1;
            boolean isEscaped = false;
            while (!personQ.isEmpty() && !isEscaped) {
                int[] cur = personQ.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = cur[0] + dx[i], ny = cur[1] + dy[i];

                    // 탈출 조건
                    if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                        result = personTime[cur[0]][cur[1]] + 1;
                        isEscaped = true; // 플래그를 true로 변경해서 while문 빠지기
                        break; // 현재 for문을 빠져나감
                    }

                    if (map[nx][ny] == '#' || personTime[nx][ny] != -1) continue;
                    if (fireTime[nx][ny] != -1 && personTime[cur[0]][cur[1]] + 1 >= fireTime[nx][ny]) continue;

                    personTime[nx][ny] = personTime[cur[0]][cur[1]] + 1;
                    personQ.offer(new int[]{nx, ny});
                }
            }

            if (isEscaped) sb.append(result).append("\n");
            else sb.append("IMPOSSIBLE\n");
        }
        System.out.print(sb);
    }
}