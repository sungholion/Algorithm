import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int tc=0; tc<t; tc++){
            String str = br.readLine();
            int sum = 0;
            int cum = 0;
            
            for(int i=0; i<str.length(); i++){
                if(str.charAt(i) == 'O'){
                    cum++;
                    sum += cum;
                } else if(str.charAt(i) == 'X'){
                    cum = 0;
                }
            }
            bw.write(sum + "\n");
        }
        
        bw.flush();
        bw.close();
    }
}
