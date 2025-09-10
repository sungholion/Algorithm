import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        int num = 665;
        while(cnt < N){
            num++;
            if(String.valueOf(num).contains("666")) cnt++;
        }
        System.out.println(num);
    }
}