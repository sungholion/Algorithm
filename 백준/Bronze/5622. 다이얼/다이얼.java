import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        String[] dial = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
        int total = 0;
        for(char c : str.toCharArray()) {
            for(int i = 0; i < dial.length; i++) {
                if(dial[i].indexOf(c) != -1){
                    total += i + 3;
                    break;
                }
            }
        }
        System.out.println(total);

    }
}