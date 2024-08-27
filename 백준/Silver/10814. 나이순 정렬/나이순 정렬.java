import java.util.*;
import java.io.*;

class User{
   int age;
   String name;

   User(int age, String name){
      this.age = age;
      this.name = name;
   }
}

public class Main{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringBuilder sb = new StringBuilder();

      int n = Integer.parseInt(br.readLine());
      User[] users = new User[n];

      for(int i = 0; i < n; i++){
         StringTokenizer st = new StringTokenizer(br.readLine());
         users[i] = new User(Integer.parseInt(st.nextToken()), st.nextToken());
      }

      Arrays.sort(users, (a, b) -> a.age - b.age);

      for(User user : users){
         sb.append(user.age).append(" ").append(user.name).append("\n");
      }

      bw.write(sb.toString());
      bw.flush();
      bw.close();
      br.close();
   }
}