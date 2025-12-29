import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int sum = 0;
        int idx = 0;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '*'){
                idx = i;
            } else {
                int num = c - '0';
                sum += i % 2 == 0 ? num : 3 * num;
            }
        }

        for(int i = 0; i <= 9; i++){
            if(idx % 2 == 0){
                if(((sum + i) % 10) == 0){
                    sb.append(i);
                    break;
                }
            } else {
                if((sum + 3 * i) % 10 == 0){
                    sb.append(i);
                    break;
                }

            }
        }

        System.out.print(sb.toString());

    }
}
