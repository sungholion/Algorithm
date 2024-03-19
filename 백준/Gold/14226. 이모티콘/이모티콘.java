import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int time;
    int emo;
    int clip;
    
    public Node(int time, int emo, int clip) {
        this.time = time;
        this.emo = emo;
        this.clip = clip;
    }
}

public class Main {
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int S = Integer.parseInt(br.readLine());
        
        bw.write(bfs(S) + "");
        bw.flush();
        bw.close();
        br.close();
    }
    
    static int bfs(int S) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 1, 0));
        boolean[][] visited = new boolean[2001][2001];
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            
            if (cur.emo == S) {
                return cur.time;
            }
            
            // 1번 연산 
            if (!visited[cur.emo][cur.emo]) {
                q.offer(new Node(cur.time + 1, cur.emo, cur.emo));
                visited[cur.emo][cur.emo] = true;
            }
            
            // 2번 연산
            if (cur.clip > 0 && cur.emo + cur.clip <= 2000 && !visited[cur.emo + cur.clip][cur.clip]) {
                q.offer(new Node(cur.time + 1, cur.emo + cur.clip, cur.clip));
                visited[cur.emo + cur.clip][cur.clip] = true;
            }
            
            // 3번 연산
            if (cur.emo > 0 && !visited[cur.emo - 1][cur.clip]) {
                q.offer(new Node(cur.time + 1, cur.emo - 1, cur.clip));
                visited[cur.emo - 1][cur.clip] = true;
            }
        }
        
        return -1; 
    }
}
