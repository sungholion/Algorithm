import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] student = new boolean[31];
        for(int t=0; t<28; t++){
            int x = Integer.parseInt(br.readLine());
            student[x] = true;
        }

        for(int i=1; i<31; i++){
            if(!student[i]) System.out.println(i);
        }


    }
}