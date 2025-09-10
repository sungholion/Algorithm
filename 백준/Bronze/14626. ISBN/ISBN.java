import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int loc = -1;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '*'){
                loc = i;
                break;
            }
        }

        for(int i = 0; i<=9; i++){
            int sum = 0;
            for(int j = 0; j<str.length(); j++){
                int w = j % 2 == 0 ? 1 : 3;
                int d = j == loc ? i : str.charAt(j) - '0';
                sum += d * w;
            }
            if(sum % 10 == 0){
                System.out.println(i);
                return;
            }
        }
    }
}