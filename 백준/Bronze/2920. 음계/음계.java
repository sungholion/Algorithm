import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] asc = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] desc = {8, 7, 6, 5, 4, 3, 2, 1};

        int[] arr = new int[8];
        for(int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean flag = true;
        if(arr[0] == 1){
            for(int i = 0; i < 8; i++) {
                if(arr[i] != asc[i]){
                    flag = false;
                    break;
                }
            }
            if(flag)
                bw.write("ascending\n");
            else
                bw.write("mixed\n");

        } else if(arr[0] == 8){
            for(int i = 0; i < 8; i++) {
                if(arr[i] != desc[i]){
                    flag = false;
                    break;
                }
            }
            if(flag)
                bw.write("descending\n");
            else
                bw.write("mixed\n");

        } else{
            bw.write("mixed\n");
        }



        br.close();
        bw.flush();
        bw.close();
    }
}