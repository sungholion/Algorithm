import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] heightCnt = new int[257];
        int minHeight = 256, maxHeight = 0;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int h = Integer.parseInt(st.nextToken());
                heightCnt[h]++;
                minHeight = Math.min(minHeight, h);
                maxHeight = Math.max(maxHeight, h);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int ansH = 0;
        for(int h = minHeight; h <= maxHeight; h++){
            long time = 0;
            long blocks = B;

            for(int curH = 0; curH <= 256; curH++){
                if(heightCnt[curH] == 0) continue;
                int diff = curH - h;
                if(diff > 0){ // 내리기
                    time += diff * 2L * heightCnt[curH];
                    blocks += diff * 1L * heightCnt[curH];
                } else if(diff < 0){ // 올리기
                    time += -diff * 1L * heightCnt[curH];
                    blocks -= -diff * 1L * heightCnt[curH];
                }
            }

            if(blocks >= 0){ // 가능
                if(time < minTime || (time == minTime && h > ansH)){
                    minTime = (int)time;
                    ansH = h;
                }
            }
        }

        System.out.println(minTime + " " + ansH);
    }
}