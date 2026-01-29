    import java.io.*;
    import java.math.BigInteger;
    import java.util.*;

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            String str;
            while(!(str = br.readLine()).equals("#")){
                int cnt = 0;
                for(int i = 0; i < str.length(); i++){
                    char c = str.charAt(i);
                    c = Character.toLowerCase(c);
                    if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                        cnt++;
                    }
                }
                sb.append(cnt).append("\n");
            }
            System.out.print(sb);
        }
    }
