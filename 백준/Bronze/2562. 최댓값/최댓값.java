import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[10];
        for(int i=1; i<=9; i++)
            arr[i] = Integer.parseInt(br.readLine());

        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        for(int i=1; i<=9; i++){
            if(arr[i] > max){
                max = arr[i];
                maxIdx = i;
            }
        }

        bw.write(max + "\n" + maxIdx);
        bw.flush();
        bw.close();
    }
}
