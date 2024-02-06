import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		
		int s =0, e = str.length()-1;
		int cnt = str.length()/2;
		boolean pal = true;
		
		while(s < e) {
			cnt--;
			if(str.charAt(s++) != str.charAt(e--)) {
				pal = false;
				break;
			}
		}
		if(pal)
			bw.write(1 + "\n");
		else
			bw.write(0 + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}