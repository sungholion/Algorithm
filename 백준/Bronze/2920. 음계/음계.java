import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());

        boolean ascFlag = true;
        boolean desFlag = true;
        if(start == 1){
            int ascNum = 2;
            for(int i=0; i<7; i++){
                int asc = Integer.parseInt(st.nextToken());
                if(asc != ascNum){
                    ascFlag = false;
                    break;
                }
                ascNum++;
            }
            if(ascFlag){
                bw.write("ascending\n");
            } else{
                bw.write("mixed\n");
            }
        } else if(start == 8){
            int desNum = 7;
            for(int i=0; i<7; i++){
                int des = Integer.parseInt(st.nextToken());
                if(des != desNum){
                    desFlag = false;
                    break;
                }
                desNum--;
            }
            if(desFlag) {
                bw.write("descending\n");
            } else {
                bw.write("mixed\n");
            }
        } else {
            bw.write("mixed\n");
        }

        bw.flush();
        bw.close();
    }
}
