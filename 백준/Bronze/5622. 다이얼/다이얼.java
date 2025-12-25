import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int total = 0;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int num = c - 'A';
            int time = 0;
            if(num < 15){
                time = num / 3 + 3; // 걸리는 시간
            } else if (num >= 15 && num <= 18){
                time = 8;
            } else if (num > 18 && num <= 21){
                time = 9;
            } else {
                time = 10;
            }
            total += time;

        }
        System.out.println(total);


            /* 3으로 나눈 몫에다가 3을 더하면 됌.
            ABC 012 -> 3으로 나눴을 때 몫 0   : 걸리는 시간 3
            DEF 345 -> 3으로 나눴을 때 몫 1   : 걸리는 시간 4
            GHI 678 -> "" 2
            JKL 91011 -> '' 3
            MNO 121314 -> "" 4
            PQRS 15161718
            TUV 192021
            */
    }
}