import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] music = new int[8];
        for(int i = 0; i < 8; i++) music[i] = Integer.parseInt(st.nextToken());

        if(music[0] == 1){
            boolean isAsc = true;
            for(int i = 1; i < 8; i++){
                if(music[i] <= music[i-1]) isAsc = false;
            }
            if(isAsc) System.out.println("ascending");
            else System.out.println("mixed");
        } else if(music[0] == 8){
            boolean isDesc = true;
            for(int i = 1; i < 8; i++){
                if(music[i] >= music[i-1]) isDesc = false;
            }
            if(isDesc) System.out.println("descending");
            else System.out.println("mixed");
        } else {
            System.out.println("mixed");
        }
    }
}
