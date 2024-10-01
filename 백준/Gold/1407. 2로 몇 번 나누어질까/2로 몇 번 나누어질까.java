import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(bf.readLine());

      long fromRange = Long.parseLong(st.nextToken());
      long toRange = Long.parseLong(st.nextToken());

      long answer = CalcBinarySqureRoot(toRange) - CalcBinarySqureRoot(fromRange-1);

      System.out.printf("%d", answer);
   }

   public static long CalcBinarySqureRoot(long n) {
      long result = n;

      for(long i=2; i<=n; i<<=1) // 2의 배수만큼씩 증가
         result += (n/i)*(i>>1); // 2의 개수 구하기

      return result;
   }
}