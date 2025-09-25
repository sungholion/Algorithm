import java.util.*;

class Solution {
    static int n, m;
    static int[][] idLand;              // 각 칸의 섬 id (0 = 미라벨링)
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        idLand = new int[n][m];

        // 1) 전체 라벨링: 섬에 id(1,2,3,...) 찍고, sizes[id]에 섬 크기 저장
        List<Integer> sizes = new ArrayList<>();
        sizes.add(0); // 인덱스 0은 비워 두기(편의상 id를 1부터)
        int nextId = 1;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (land[r][c] == 1 && idLand[r][c] == 0) {
                    int area = labelBFS(land, r, c, nextId);
                    sizes.add(area);   // sizes.get(nextId) == area
                    nextId++;
                }
            }
        }

        // 2) 열별로 등장하는 섬 id를 Set으로 중복 제거하여 합산 → 최댓값
        int answer = 0;
        for (int col = 0; col < m; col++) {
            int sum = 0;
            HashSet<Integer> seen = new HashSet<>();
            for (int row = 0; row < n; row++) {
                int id = idLand[row][col];
                if (id != 0 && seen.add(id)) {
                    sum += sizes.get(id);
                }
            }
            answer = Math.max(answer, sum);
        }
        return answer;
    }

    // BFS로 같은 섬을 모두 방문하며 idLand에 id를 찍고, 섬 크기(area)를 리턴
    private static int labelBFS(int[][] land, int sr, int sc, int id) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});
        idLand[sr][sc] = id;

        int area = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int k = 0; k < 4; k++) {
                int nr = r + dx[k];
                int nc = c + dy[k];
                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if (land[nr][nc] == 0 || idLand[nr][nc] != 0) continue;

                idLand[nr][nc] = id;          // 같은 섬이면 같은 id를 찍는다
                q.offer(new int[]{nr, nc});
                area++;
            }
        }
        return area;
    }
}
