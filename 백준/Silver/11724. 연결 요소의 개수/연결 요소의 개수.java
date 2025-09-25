import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static List<Integer>[] g;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        g = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            g[i] = new ArrayList<>();
        }
        visited = new boolean[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a].add(b); g[b].add(a);
        }

        int cnt = 0;
        for(int i = 1; i<=N; i++){
            if(!visited[i]){
                cnt++;
                bfs(i);
            }
        }

        System.out.println(cnt);
        }

        static void bfs(int v){
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(v);
            visited[v] = true;

            while(!q.isEmpty()){
                int cur = q.poll();
                for(int next : g[cur]){
                    if(!visited[next]){
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
        }

    }