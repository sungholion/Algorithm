import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str = br.readLine().toCharArray();
        int cnt = 0;

        for(int i=0; i<str.length; i++){
            if(str[i] == 'c'){
                if(i < str.length -1){  // 마지막 인덱스의 경우 크로티아 알파벳일 수가 없으므로
                    if(str[i+1] == '=') i++;
                    else if(str[i+1] == '-')  i++;
                }
            }
            else if(str[i] == 'd'){
                if(i < str.length - 1){
                    if(str[i+1] == 'z'){
                        if(i < str.length - 2){
                            if(str[i+2] == '=')
                                i+=2;
                        }
                    }
                    else if(str[i+1] == '-') i++;
                }
            }
            else if(str[i] == 'l'){
                if(i < str.length -1)
                    if(str[i+1] == 'j') i++;
            }
            else if(str[i] == 'n'){
                if(i < str.length -1)
                    if(str[i+1] == 'j') i++;
            }
            else if(str[i] == 's'){
                if(i < str.length -1)
                    if(str[i+1] == '=') i++;
            }
            else if(str[i] == 'z'){
                if(i < str.length -1)
                    if(str[i+1] == '=') i++;
            }
            cnt++; // 일반 알파벳의 경우
        }
        System.out.println(cnt);
    }
}