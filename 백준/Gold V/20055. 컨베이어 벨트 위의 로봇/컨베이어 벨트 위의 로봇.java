import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] belt;
    static boolean[] robot;
    static Queue <Integer> q = new LinkedList<>();
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        belt = new int[2*N];
        robot = new boolean[2*N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<2*N; i++)
            belt[i] = Integer.parseInt(st.nextToken());


        while(true){
            one();
            two();
            three();
            if(four()){
                break;
            }
            else continue;
        }

        System.out.println(cnt);

//        for(int i=0; i<2*N; i++)
//            System.out.print(belt[i] + " ");
    }

    static void one(){
        cnt++;

        int temp = belt[0];
        belt[0] = belt[2*N-1];
        for(int i = 2*N-2; i>=0; i--)
            belt[i+1] = belt[i];
        belt[1] = temp;


        for(int i = N-1; i>=0; i--){
            robot[i+1] = robot[i];
        }
        robot[0] = false;
        robot[N-1] = false;


    }

    static void two(){

        for(int i=N-1; i>=0; i--){
            if(robot[i]){
                if(belt[i+1] >= 1 && !robot[i+1]){
                    belt[i+1]--;
                    robot[i+1] = true;
                    robot[i] = false;
                    if(robot[N-1])
                        robot[N-1] = false;
                }
            }
        }
    }

    static void three(){
        if(belt[0]!=0){
            robot[0] = true;
            belt[0]--;
        }
    }

    static boolean four(){
        int zeroBelt = 0;
        for(int i=0; i<2*N; i++){
            if(belt[i] == 0){
                zeroBelt++;
            }
            if(zeroBelt >= K)
                return true;
        }
        return false;
    }
}