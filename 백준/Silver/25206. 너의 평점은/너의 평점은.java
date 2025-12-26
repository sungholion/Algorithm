import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        double sum = 0;
        int creditSum = 0;
        for(int i=0; i<20; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken(); // 과목명은 필요 없음
            int credit = st.nextToken().charAt(0) - '0'; // 학점
            String grade = st.nextToken();
            if(!grade.equals("P"))  // P면 계산 제외
                creditSum += credit;

            if(grade.equals("A+")){
                sum += 4.5 * credit;
            } else if(grade.equals("A0")){
                sum += 4.0 * credit;
            } else if(grade.equals("B+")){
                sum += 3.5 * credit;
            } else if(grade.equals("B0")){
                sum += 3.0 * credit;
            } else if(grade.equals("C+")){
                sum += 2.5 * credit;
            } else if(grade.equals("C0")){
                sum += 2.0 * credit;
            } else if(grade.equals("D+")){
                sum += 1.5 * credit;
            } else if(grade.equals("D0")){
                sum += 1.0 * credit;
            } else if(grade.equals("F")){
                sum += 0;
            }
        }

        System.out.println(sum / creditSum);
    }
}