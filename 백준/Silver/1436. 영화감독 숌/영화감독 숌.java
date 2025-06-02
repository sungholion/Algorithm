import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int movie = 666;
        int cnt = 1;
      
        while(cnt != N){
            movie++;
            if(String.valueOf(movie).contains("666"))
                cnt++;
        }
        

        sb.append(movie);
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }


}