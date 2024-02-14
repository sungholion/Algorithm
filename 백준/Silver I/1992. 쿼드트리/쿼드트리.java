import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] video;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		video = new int[n][n];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) 
				video[i][j] = Character.getNumericValue(str.charAt(j));
		}
		
		zipVideo(0,0,n);
    }   

    static void zipVideo(int col, int low, int s) {
    	// 종료 조건 : 배열 안 원소가 모두 같을 때 (0 또는 1), 그 원소 출력 후 종료
    	if(canZip(col, low, s)) {
    		System.out.print(video[col][low]);
    		return;
    	}
    	
    	s /=2;
    	// 유도 파트 : 배열 안 원소가 다르면 1/4로 나누어 재귀
    	System.out.print('(');
    	zipVideo(col, low, s);
    	zipVideo(col, low + s, s);
    	zipVideo(col + s, low, s);
    	zipVideo(col + s, low + s, s);
    	System.out.print(')');
    	//   
    	
    }
    
    static boolean canZip(int col, int low, int s) {
    	int data = video[col][low];
    	for(int i=col; i<col+s; i++) {
    		for(int j=low; j<low+s; j++) {
    			if(data != video[i][j]) 
    				return false;
    		}
    	}
    	return true;
    }
    
}
       