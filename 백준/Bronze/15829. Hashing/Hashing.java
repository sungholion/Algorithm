import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();

        long sum = 0;
        for(int i=0; i<str.length(); i++){
            sum += (str.charAt(i) - 'a' + 1) * Math.pow(31, i);
        }

        System.out.println(sum % 1234567891);
    }
}