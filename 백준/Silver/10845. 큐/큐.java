import java.io.*;
import java.util.StringTokenizer;

public class Main {
   public static int[] q;
   public static int f;
   public static int r;

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringBuilder sb = new StringBuilder();

      StringTokenizer st;
      int N = Integer.parseInt(br.readLine());
      q = new int[N];

      while (N-- > 0) {
         st = new StringTokenizer(br.readLine());

         switch (st.nextToken()) {
            case "push":
               push(Integer.parseInt(st.nextToken()));
               break;

            case "pop":
               sb.append(pop()).append('\n');
               break;

            case "size":
               sb.append(size()).append('\n');
               break;

            case "empty":
               sb.append(empty()).append('\n');
               break;

            case "front":
               sb.append(front()).append('\n');
               break;

            case "back":
               sb.append(back()).append('\n');
               break;
         }
      }

      bw.write(sb.toString());
      bw.flush();
      bw.close();
      br.close();
   }

   public static void push(int item) {
      q[r++] = item;
   }

   public static int pop() {
      if((r-f) == 0) {
         return -1;
      }
      else {
         int res = q[f++];
         q[f - 1] = 0;
         return res;
      }
   }

   public static int size() {
      return r - f;
   }

   public static int empty() {
      if((r-f) == 0) {
         return 1;
      }
      else {
         return 0;
      }
   }

   public static int front() {
      if((r-f) == 0) {
         return -1;
      }
      else {
         return q[f];
      }
   }

   public static int back() {
      if((r-f) == 0) {
         return -1;
      }
      else {
         return q[r-1];
      }
   }

}