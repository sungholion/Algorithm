import java.io.*;
import java.util.*;

public class Main {

   static class Baseball {
      String num;
      int strike;
      int ball;

      Baseball(String num, int strike, int ball) {
         this.num = num;
         this.strike = strike;
         this.ball = ball;
      }
   }

   static ArrayList<Baseball> baseball = new ArrayList<>();

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringTokenizer st;

      int n = Integer.parseInt(br.readLine());

      // 질문 입력받기
      for (int i = 0; i < n; i++) {
         st = new StringTokenizer(br.readLine());
         baseball.add(new Baseball(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
      }

      int cnt = 0;

      // 123 ~ 987까지의 모든 세 자리 수 탐색
      for (int i = 123; i <= 987; i++) {
         if (!isValid(i)) continue; // 각 자리 숫자가 중복되지 않는 유효한 숫자인지 체크

         boolean isPossible = true;

         // 모든 질문에 대해 검사
         for (Baseball b : baseball) {
            int strike = 0;
            int ball = 0;

            String guess = Integer.toString(i); // 추측하는 숫자
            String target = b.num; // 주어진 질문의 숫자

            // 스트라이크 계산
            for (int j = 0; j < 3; j++) {
               if (guess.charAt(j) == target.charAt(j)) {
                  strike++;
               }
            }

            // 볼 계산
            for (int j = 0; j < 3; j++) {
               if (guess.charAt(j) != target.charAt(j) && target.contains(Character.toString(guess.charAt(j)))) {
                  ball++;
               }
            }

            // 질문의 strike와 ball이 일치하지 않으면 후보에서 제외
            if (strike != b.strike || ball != b.ball) {
               isPossible = false;
               break;
            }
         }

         if (isPossible) cnt++; // 가능한 답이면 카운트 증가
      }

      bw.write(Integer.toString(cnt));
      bw.flush();
      br.close();
      bw.close();
   }

   // 각 자리 숫자가 중복되지 않도록 하는 함수
   static boolean isValid(int num) {
      String s = Integer.toString(num);
      
      if(s.charAt(0) == '0' || s.charAt(1) == '0' || s.charAt(2) == '0') return false;
      
      return s.charAt(0) != s.charAt(1) && s.charAt(1) != s.charAt(2) && s.charAt(0) != s.charAt(2);
   }
}
