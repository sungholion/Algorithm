import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		
		char[] alpa = new char[26];
		char start = 'a';
		for(int i=0; i<26; i++) {
			alpa[i] = (char) ((int)start + i);
		}
		
		int[] alpa_c = new int[26];
		for(int i=0; i<26; i++)
			alpa_c[i] = -1;
		
		for(int i=0; i<str.length; i++) {
			for(int j=0; j<alpa.length; j++) {
				if(str[i] == alpa[j] && alpa_c[j] == -1) {
					alpa_c[j] = i;
				}
			}
		}
		
		for(int i=0; i<alpa_c.length; i++) {
			if(i == 25)
				System.out.print(alpa_c[i]);
			else
				System.out.print(alpa_c[i] + " ");
		}
		
	}
}



