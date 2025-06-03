import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int time = 0;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'C') time += 3;
            else if (c >= 'D' && c <= 'F') time += 4;
            else if (c >= 'G' && c <= 'I') time += 5;
            else if (c >= 'J' && c <= 'L') time += 6;
            else if (c >= 'M' && c <= 'O') time += 7;
            else if (c >= 'P' && c <= 'S') time += 8;
            else if (c >= 'T' && c <= 'V') time += 9;
            else if (c >= 'W' && c <= 'Z') time += 10;
        }

        sb.append(time);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}