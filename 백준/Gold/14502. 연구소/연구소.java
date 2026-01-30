import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] mapOrg;
    static ArrayList<int[]> emptySpaces = new ArrayList<>();
    static ArrayDeque<int[]> virusOrg = new ArrayDeque<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int maxSize = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 1. 입력 받기 / 벽 세울 위치 및 바이러스 위치 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        mapOrg =  new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int x = Integer.parseInt(st.nextToken());
                mapOrg[i][j] = x;

                if(x == 0){
                    emptySpaces.add(new int[]{i, j});
                } else if(x == 2){
                    virusOrg.offer(new int[]{i, j});
                }

            }
        }

        // 2. 벽 세우고 -> 바이러스 퍼뜨리고 -> 안전영역 최댓값 갱신
        int size = emptySpaces.size();
        for(int i = 0; i < size - 2; i++){
            for(int j = i + 1; j < size - 1; j++){
                for(int k = j + 1; k < size; k++){
                    simulateWithWalls(i, j, k);
                }
            }
        }
        sb.append(maxSize);
        System.out.println(sb);
    }

    static void  simulateWithWalls(int i, int j, int k){
        int[][] map = getCopyMap(mapOrg);  // 벽을 세울 맵 복사

        int[] a = emptySpaces.get(i);
        int[] b = emptySpaces.get(j);
        int[] c = emptySpaces.get(k);

        buildWall(map, a);  // 해당 위치 벽 세우기
        buildWall(map, b);
        buildWall(map, c);

        spreadVirus(map);
        int curSafe = countSafeArea(map);
        maxSize = Math.max(maxSize, curSafe);
    }

    static int[][] getCopyMap(int[][] map){
        int[][] copyMap = new int[N][M];
        for(int i = 0; i < N; i++){
            copyMap[i] = map[i].clone();
        }
        return copyMap;
    }

    static void buildWall(int[][] map, int[] wallPos){
        map[wallPos[0]][wallPos[1]] = 1;
    }

    static void spreadVirus(int[][] map){
        ArrayDeque<int[]> virus = new ArrayDeque<>(virusOrg);

        while(!virus.isEmpty()){
            int[] cur = virus.poll();

            for(int i = 0; i < 4; i++){
                int nx =  cur[0] + dx[i];
                int ny =  cur[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(map[nx][ny] == 0){
                    map[nx][ny] = 2;
                    virus.offer(new int[]{nx, ny});
                }
            }
        }
    }

    static int countSafeArea(int[][] map){
        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0){
                    count++;
                }
            }
        }
        return count;
    }
}
