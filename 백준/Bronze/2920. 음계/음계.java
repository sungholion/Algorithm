import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] music = new int[8];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < music.length; i++) {
            music[i] = Integer.parseInt(st.nextToken());
        }

        if(music[0] == 1){
            boolean isAsc = true;
            for(int i = 1; i < music.length; i++) {
                if(music[i] != music[i-1] + 1){
                    isAsc = false;
                    break;
                }
            }
            if(isAsc) sb.append("ascending");
            else sb.append("mixed");
        } else if(music[0] == 8){
            boolean isDesc = true;
            for(int i = 1; i < music.length; i++) {
                if(music[i] != music[i-1] - 1){
                    isDesc = false;
                    break;
                }
            }
            if(isDesc) sb.append("descending");
            else sb.append("mixed");
        } else{
            sb.append("mixed");
        }

        System.out.println(sb.toString());
    }
}