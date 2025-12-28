import java.io.*;
import java.util.*;

public class Main {
    static class Document {
        int idx;     
        int priority;  

        Document(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Queue<Document> queue = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.add(new Document(i, priority)); 
            }

            int count = 0;

            while (true) {
                Document front = queue.poll(); 
                
                boolean hasHigher = false;
                for (Document doc : queue) {
                    if (doc.priority > front.priority) {
                        hasHigher = true;
                        break;
                    }
                }

                if (hasHigher) {
                    queue.add(front);
                } else {
                    count++;
                    if (front.idx == M) {
                        System.out.println(count);
                        break;
                    }
                }
            }
        }
    }
}
