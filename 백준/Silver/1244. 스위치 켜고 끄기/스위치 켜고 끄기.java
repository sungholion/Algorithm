import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 스위치 개수
        
        int[] org = new int[n+1];	// 원본 스위치
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<n+1; i++)
        	org[i] = Integer.parseInt(st.nextToken());
        
        int p = Integer.parseInt(br.readLine());	// 학생 수
        for(int t=0; t<p; t++) {
        	st = new StringTokenizer(br.readLine());
        	int s = Integer.parseInt(st.nextToken());	// 성별
        	int num = Integer.parseInt(st.nextToken()); // 스위치 번호
        	
        	// 성별이 남자인 경우
        	if(s == 1) {
        		for(int i=1; i<n+1; i++) {
        			if(i % num == 0)	// 받은 스위치 번호의 배수인 경우에
        				org[i] = (org[i] == 0) ? 1 : 0;	// 스위치 상태를 반대로 바꿈
        		}
        	}
        	
        	// 성별이 여자인 경우
        	else if(s == 2) {
        		org[num] = org[num] == 0 ? 1 : 0;
        		int move = 1;
        		while(true) {
        			if((num-move) >=1 && (num+move) <= n) {
            			if(org[num-move] == org[num+move]) {
            				org[num-move] = org[num-move] == 0 ? 1 : 0;
            				org[num+move] = org[num+move] == 0 ? 1 : 0;
            				move++;
            			}
            			else if(org[num-move] != org[num+move]) {
            				move--;
            				break;
            			}
            		}
        			else {
        				break;
        			}
        		}
        	}
        }
        
        for(int i=1; i<n+1; i++) {
        	System.out.print(org[i] + " ");
        	if(i % 20 == 0) 
        		System.out.println();
        }
    }
}
