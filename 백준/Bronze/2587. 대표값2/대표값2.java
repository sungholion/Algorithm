import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[5];
        int sum = 0;
        for(int i = 0; i < 5; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        for(int i = 0; i < 5 - 1; i++){
            for(int j = 0; j < 5 - 1 - i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        sb.append(sum / arr.length).append('\n');
        sb.append(arr[arr.length/2]);
        System.out.print(sb.toString());

    }
}
