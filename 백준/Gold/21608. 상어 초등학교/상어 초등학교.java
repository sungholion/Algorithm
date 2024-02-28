import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main{
    static int n;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] room;
	static int[][] myfriends;
	static int score;
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        room = new int[n][n];
        myfriends = new int[n * n + 1][4];
       
        for(int i = 0; i < n * n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int studentNo = Integer.parseInt(st.nextToken());
        
            for(int j=0; j<4; j++)
            	myfriends[studentNo][j] =Integer.parseInt(st.nextToken());
            
            seat(studentNo);
            
            
        }
        
        System.out.println(getScore(score));
        
    
        
    }
    
    static void seat(int studentNo) {
    	int maxLove = 0;
    	int maxBlank = 0;
    	int x = 0, y = 0;
    
    	
    	for(int i = n-1; i >=0; i--) {
    		for(int j=n-1; j >=0; j--) {
    			if(room[i][j] != 0) continue;	// 빈자리 아니면 넘어감.
    			
    			int love = 0;
    			int blank = 0;
    			
    			for(int k = 0; k < 4; k++) {
    				int nx = i +dx[k];
    				int ny = j +dy[k];
    				
    				if(nx >=0 &&ny >=0 && nx <n && ny < n) {
    					if(room[nx][ny] == 0) blank++;
    					else {
    						for(int l = 0; l <4; l++) {
    							if(room[nx][ny] == myfriends[studentNo][l]) {
    								love++;
    							}
    						}
    					}
    				}
    			}
    			
    			if (maxLove < love || (maxLove== love && maxBlank <= blank)) {
                    maxLove = love;
                    maxBlank = blank;
                    x = i; y = j;
                }
    		}
    	}
    	room[x][y] = studentNo;
    }
    
    static int getScore(int score) {
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
    			int studentno = room[i][j];
    			int cnt = 0;
    			
    			for(int k=0; k<4; k++) {
    				 int nx = i + dx[k];
                     int ny = j + dy[k];

                     if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                         continue;
                     }
                     
                     for (int l = 0; l < 4; l++) {
                         if (room[nx][ny] == myfriends[studentno][l]) {
                             cnt++;
                         }
                     }
    			}
    			
    			if(cnt == 1) score+= 1;
    			else if(cnt == 2) score += 10;
    			else if(cnt == 3) score += 100;
    			else if(cnt == 4) score += 1000;
    		}
    	}
    	return score;
    }
}