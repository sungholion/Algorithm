import java.io.*;
import java.time.LocalDate;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        if(x > 0 && y > 0){
            sb.append(1);
        } else if(x < 0 && y > 0){
            sb.append(2);
        } else if(x < 0 && y < 0){
            sb.append(3);
        } else if(x > 0 && y < 0){
            sb.append(4);
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}