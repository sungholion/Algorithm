import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] num = new int[7];
        boolean exist_odd = false;
        int sum = 0;
        int min = 100;
        
        for(int i=0; i<7; i++){
            int x = Integer.parseInt(br.readLine());
            
            if(x%2 !=0){
                num[i] = x;
                sum+= num[i];
                if(num[i] < min)
                    min = num[i];
                exist_odd = true;
            }
        }


        if(!exist_odd) System.out.println("-1");
        else{
            System.out.println(sum);
            System.out.println(min);
        }

    }
}
