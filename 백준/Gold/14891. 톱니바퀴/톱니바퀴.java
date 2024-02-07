import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[][] w; // 바퀴 집합
	
	public static void main(String[] args) throws IOException{
		w = new int[4][8];
		for(int i=0; i<4; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j=0; j<8; j++) 
				w[i][j] = Character.getNumericValue(input[j]);
			
		}
		StringTokenizer st; 
		int k = Integer.parseInt(br.readLine());
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken()) -1;
			int d = Integer.parseInt(st.nextToken());
			
			wheelRotate(c,d);
		}
		
		int score = 0;
		if(w[0][0] == 1) score += 1;
		if(w[1][0] == 1) score += 2;
		if(w[2][0] == 1) score += 4;
		if(w[3][0] == 1) score += 8;
		
		bw.write(score+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void wheelRotate(int c, int d) {
		
		checkL(c-1, -d);
		checkR(c+1, -d);
		rotation(c,d);
	}
	
	static void rotation(int c, int d) {
		if(d==1) {
			int temp = w[c][7];
			for(int i=7; i>0; i--) {
				w[c][i] = w[c][i-1];
			}
			w[c][0] = temp;
		}else {
			int temp = w[c][0];
			for(int i=0; i<7; i++) {
				w[c][i] = w[c][i+1];
			}
			w[c][7] = temp;
		}
	}
	
	static void checkL(int c, int d) {
		if(c < 0) return;
		if(w[c][2]==w[c+1][6]) return;
		checkL(c-1, -d);
		rotation(c,d);
	}
	
	static void checkR(int c, int d) {
		if(c > 3) return;
		if(w[c][6] == w[c-1][2]) return;
		checkR(c+1, -d);
		rotation(c,d);
	}
	

}