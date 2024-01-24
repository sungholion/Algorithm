import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		char[][] arr = new char[5][15];
		int[] size = new int[5];
		
		for(int i=0; i<5; i++) {
			char[] str = br.readLine().toCharArray();
			arr[i] = str;
			size[i] = str.length;
		}
		
		for(int j=0; j<15; j++) {
			for(int i=0; i<5; i++) {
				if(j < arr[i].length) {
					System.out.print(arr[i][j]);
				}
			}
		}
		
		
			
		
	}
}