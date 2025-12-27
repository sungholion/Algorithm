import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        for(int i = 666; ; i++){
            String s = String.valueOf(i);
            if(s.contains("666")) cnt++;
            if(cnt == N){
                System.out.println(i);
                break;
            }
        }

    }
}
