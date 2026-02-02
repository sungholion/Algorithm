import java.io.*;
import java.util.*;

/*
 * BOJ 2206 - 벽 부수고 이동하기
 *
 * 핵심 아이디어:
 * - (x, y) 위치만으로는 상태가 부족하다.
 * - 같은 칸 (x, y)라도
 *      1) 아직 벽을 안 부순 상태
 *      2) 이미 벽을 한 번 부순 상태
 *   는 이후 선택지가 달라서 "서로 다른 노드"로 봐야 한다.
 *
 * 그래서 BFS 노드를 (x, y, broke) 로 확장한다.
 *  - broke = 0 : 아직 벽을 안 부숨
 *  - broke = 1 : 이미 벽을 한 번 부숨
 *
 * dist[x][y][broke] = 해당 상태로 (x, y)에 도달하는 최단 거리
 *
 * BFS는 "처음 도달"이 최단거리이므로
 * dist가 0이면 미방문, 0이 아니면 방문(최단거리 확정)으로 사용한다.
 */

public class Main {
    static int N, M;
    static int[][] map;
    static int[][][] dist;              // dist[x][y][0/1]
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // BFS 큐에 넣을 상태 노드
    static class Node {
        int x, y;
        int broke; // 0 or 1

        Node(int x, int y, int broke) {
            this.x = x;
            this.y = y;
            this.broke = broke;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1) 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        ArrayDeque<Node> q = new ArrayDeque<>();
        dist = new int[N][M][2];

        // 시작점 (0,0), 아직 벽 안 부숨(broke=0), 거리 1로 시작
        dist[0][0][0] = 1;
        q.offer(new Node(0, 0, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            int x = cur.x;
            int y = cur.y;
            int broke = cur.broke;

            if (x == N - 1 && y == M - 1) {
                return dist[x][y][broke];
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 1) 다음 칸이 빈칸(0)인 경우
                // - 벽을 부순 여부(broke)는 그대로 유지
                // - 해당 상태로 미방문(dist==0)이라면 방문 처리 후 큐 삽입
                if (map[nx][ny] == 0) {
                    if (dist[nx][ny][broke] == 0) {
                        dist[nx][ny][broke] = dist[x][y][broke] + 1;
                        q.offer(new Node(nx, ny, broke));
                    }
                }

                // 2) 다음 칸이 벽(1)인 경우
                // - 아직 벽을 안 부쉈을 때(broke==0)만 부술 수 있음
                // - 벽을 부수고 이동하면 broke가 1로 바뀜
                // - dist[nx][ny][1] 상태로 미방문이면 방문 처리 후 큐 삽입
                else {
                    if (broke == 0 && dist[nx][ny][1] == 0) {
                        dist[nx][ny][1] = dist[x][y][0] + 1;
                        q.offer(new Node(nx, ny, 1));
                    }
                }
            }
        }
        return -1;
    }
}
