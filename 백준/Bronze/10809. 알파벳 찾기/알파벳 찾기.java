import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String alpa = "abcdefghijklmnopqrstuvwxyz";
        int[] cnt = new int[26];
        for(int i=0; i<26; i++){
            cnt[i] = -1;
        }

        for(int i=0; i<str.length(); i++){
            for(int j=0; j<alpa.length(); j++){
                if(str.charAt(i) == alpa.charAt(j) && cnt[j] == -1){
                    cnt[j] = i;
                }
            }
        }

        for(int cntNum : cnt){
            bw.write(cntNum + " ");
        }

        bw.flush();
        bw.close();
    }
}
