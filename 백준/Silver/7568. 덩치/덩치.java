import java.util.*;
import java.io.*;

class Person{
   int height;
   int weight;
   int rank;

   Person(int height, int weight, int rank){
      this.height = height;
      this.weight = weight;
      this.rank = rank;
   }
}

public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      int n = Integer.parseInt(br.readLine());
      Person[] persons = new Person[n];

      for (int i = 0; i < n; i++) {
         StringTokenizer st = new StringTokenizer(br.readLine());
         Person p = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 1);
         persons[i] = p;
      }

      for(int i = 0; i < n - 1; i++){
         for(int j = i+1; j < n; j++){
            if(persons[i].height < persons[j].height && persons[i].weight < persons[j].weight){
               persons[i].rank++;
            } else if(persons[i].height > persons[j].height && persons[i].weight > persons[j].weight){
               persons[j].rank++;
            }
         }
      }

      for(int i = 0; i < n ; i++){
         bw.write(persons[i].rank + " ");
      }

      bw.flush();
      bw.close();
   }
}