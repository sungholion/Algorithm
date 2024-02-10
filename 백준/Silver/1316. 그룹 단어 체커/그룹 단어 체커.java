import java.io.*;

public class Main {
    static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for(int tc=0; tc<n; tc++){
            str = br.readLine();
            if(groupCheck()) cnt++;
        }

        System.out.println(cnt);
    }

    static boolean groupCheck(){
        boolean [] dup = new boolean[26];
        char before = ' ';

        for(int i=0; i<str.length(); i++){
            char cur = str.charAt(i);

            if(cur!= before){   // 이전 문자와 현재 문자가 다를 경우
                    if(!dup[cur - 'a']){
                        dup[cur - 'a'] = true;
                        before = cur;
                    }
                    else return false;
            }
            continue;   // 같은 경우 체크 필요 없음
            }
        return true;    // 그룹단어인 경우
    }
}