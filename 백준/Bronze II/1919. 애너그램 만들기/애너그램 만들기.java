import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String alpa = "abcdefghijklmnopqrstuvwxyz";

		String str1 = br.readLine();
		String str2 = br.readLine();
		
		int[] alpa_cnt_str1 = new int[26];
		int[] alpa_cnt_str2 = new int[26];
			
		for(int i=0; i<str1.length(); i++) {
			for(int j=0; j<alpa.length(); j++) {
				if(str1.charAt(i) == alpa.charAt(j)) alpa_cnt_str1[j]++;
			}
		}
		
		for(int i=0; i<str2.length(); i++) {
			for(int j=0; j<alpa.length(); j++) {
				if(str2.charAt(i) == alpa.charAt(j)) alpa_cnt_str2[j]++;
			}
		}
		
		
		int cnt_str1 = 0;
		int cnt_str2 = 0;
		int cnt_common = 0;
		for(int i=0; i<alpa_cnt_str1.length; i++) {
			if(alpa_cnt_str1[i]!=0) cnt_str1+= alpa_cnt_str1[i];
			if(alpa_cnt_str2[i]!=0) cnt_str2+= alpa_cnt_str2[i];
			if(alpa_cnt_str1[i]!=0 && alpa_cnt_str2[i]!=0) {
				cnt_common += alpa_cnt_str1[i] <= alpa_cnt_str2[i] ? alpa_cnt_str1[i] : alpa_cnt_str2[i];
			}
		}
		
		
		int res = cnt_str1 + cnt_str2 - (2 * cnt_common);
		System.out.println(res);
		
	}
}