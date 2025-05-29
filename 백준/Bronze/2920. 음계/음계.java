import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[8];
        String res = "";
        for (int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < arr.length - 1; i++){
            if(arr[i] == arr[i+1] - 1)
                res = "ascending\n";
            else if(arr[i] == arr[i+1] + 1)
                res = "descending\n";
            else{
                res = "mixed\n";
                break;
            }
        }

        bw.write(res);
        br.close();
        bw.flush();
        bw.close();
    }
}
