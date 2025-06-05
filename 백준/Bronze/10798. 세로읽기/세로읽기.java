import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char[][] arr = new char[5][15];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                arr[i][j] = ' ';
            }
        }

        for(int i = 0; i < arr.length; i++){
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++)
                arr[i][j] = str.charAt(j);
        }

        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 5; j++){
                if(arr[j][i] != ' ')
                    sb.append(arr[j][i]);}
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}