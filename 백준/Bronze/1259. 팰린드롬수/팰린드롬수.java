import java.io.*;
import java.util.*;


public class Main {
    static final int MOD = 1234567891;
    static final int R = 31;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while(true){
            String str = br.readLine();
            if(str.equals("0")){
                break;
            }
            int l = Math.round((float) str.length() / 2);
            boolean isPal = true;
            for(int i=0; i<l; i++){
                if(str.charAt(i) != str.charAt(str.length()-1-i)){
                    isPal = false;
                }
            }
            if(isPal)
                sb.append("yes\n");
            else
                sb.append("no\n");
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}