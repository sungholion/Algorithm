import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static int[] selected;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int info = Integer.parseInt(st.nextToken());
                if(info == 1) houses.add(new int[]{i, j});
                else if(info == 2) chickens.add(new int[]{i, j});
            }
        }

        selected = new int[M];
        comb(0,0);

        System.out.print(ans);
    }

    static void comb(int idx, int start){
        if(idx == M){
            ans = Math.min(ans, calcCity());
            return;
        }

        for(int i = start; i < chickens.size(); i++){
            selected[idx] = i;
            comb(idx + 1, i + 1);
        }
    }

    static int calcCity(){
        int sum = 0;
        for(int[] h : houses){
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < M; i++){
                int[] chicken = chickens.get(selected[i]);
                int dis = Math.abs(h[0] - chicken[0]) +  Math.abs(h[1] - chicken[1]);
                if(dis < min) min = dis;
            }
            sum += min;

            if(sum >= ans) return sum;
        }
        return sum;
    }
}
