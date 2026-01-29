import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] orgMap; // 원본 지도
    static int[][] copyMap;
    static int maxSize = Integer.MIN_VALUE; // 안전구역 최대넓이
    static ArrayDeque<int[]> orgBirus = new ArrayDeque<>(); // 불 위치
    static ArrayList<int[]> canGo = new ArrayList<>(); // 빈 칸 위치
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        orgMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 0) canGo.add(new int[]{i, j});
                else if(num == 2) orgBirus.offer(new int[]{i, j});
                orgMap[i][j] = num;
            }
        }


        // 2 . 벽 후보 3개 뽑아서 맵 복사
        for(int i = 0; i < canGo.size() - 2; i++){
            for(int j = i + 1; j < canGo.size() - 1; j++){
                for(int k = j + 1; k < canGo.size(); k++){
                    copyMap = new int[orgMap.length][];
                    for(int c = 0; c < orgMap.length; c++){
                        copyMap[c] = orgMap[c].clone();
                    }
                    int[] a = canGo.get(i);
                    int[] b = canGo.get(j);
                    int[] c = canGo.get(k);
                    copyMap[a[0]][a[1]] = 1;
                    copyMap[b[0]][b[1]] = 1;
                    copyMap[c[0]][c[1]] = 1;

                    // 3. 바이러스 퍼뜨리기
                    ArrayDeque<int[]> copyBirus = new ArrayDeque<>(orgBirus);
                    while(!copyBirus.isEmpty()){
                        int[] cur =  copyBirus.poll();

                        for(int f = 0; f < 4; f++){
                            int nx = cur[0] + dx[f];
                            int ny = cur[1] + dy[f];

                            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                            if(copyMap[nx][ny] == 0){
                                copyMap[nx][ny] = 2;
                                copyBirus.offer(new int[]{nx, ny});
                            }
                        }
                    }


                    // 넓이 갱신
                    int cnt = 0;
                    for(int s = 0; s < N; s++){
                        for(int e = 0; e < M; e++){
                            if(copyMap[s][e] == 0){
                                cnt++;
                            }
                        }
                    }
                    if(cnt > maxSize){
                        maxSize = cnt;
                    }
                }
            }

        }
        System.out.println(maxSize);
    }
}
