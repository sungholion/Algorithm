import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int[] length = new int[n];
        int ans = 1;

        for(int k = 0; k < n; k++){
            length[k] = 1;

            for(int i=0; i<k; i++){
                if(arr[i] > arr[k]){
                    length[k] = Math.max(length[k], length[i] + 1);
                    ans = Math.max(ans, length[k]);
                }
            }
        }


//        for(int x : length){
//            System.out.print(x + " ");
//        }
        System.out.println(ans);
    }
}