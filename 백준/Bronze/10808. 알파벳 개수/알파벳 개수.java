import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String alpa = "abcdefghijklmnopqrstuvwxyz";
		int[] alpa_cnt = new int[26];
		String str = br.readLine();

		for(int i=0; i<str.length(); i++) {
			for(int j=0; j<alpa.length(); j++) {
				if(str.charAt(i) == alpa.charAt(j)) alpa_cnt[j]++;
			}
		}
		
		for(int i=0; i<alpa_cnt.length; i++) System.out.print(alpa_cnt[i] + " ");
	}
}