import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        String str = br.readLine();
        int totalCnt = 0;
        int cnt = 0;

        int i = 0;
        while(i < M - 2){
            if(str.charAt(i) == 'I' && str.charAt(i + 1) == 'O' && str.charAt(i + 2) == 'I'){
                cnt++;
                if(cnt >= N) totalCnt++;
                i+= 2;
            }
            else{
                cnt = 0;
                i++;
            }
        }

        System.out.println(totalCnt);
    }
}

