import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine().toUpperCase();
		String[] str = input.split("");	// 원본 문자열
		
		LinkedHashSet<String> linkedhashSet = new LinkedHashSet<>(Arrays.asList(str));
		String[] new_str = linkedhashSet.toArray(new String[0]); // 중복 제거 문자열
		int[] cnt = new int[new_str.length]; // 중복 세아릴 배열
		
		for(int i=0; i<str.length; i++) {
			for(int j=0; j<new_str.length; j++) {
				if(str[i].equals(new_str[j])) {
					cnt[j]++;
				}
			}
		}
		
		int max = cnt[0];
		int max_idx = 0;
		for(int i=1; i<cnt.length; i++) {
			if(max < cnt[i]) {
				max = cnt[i];
				max_idx = i;
			}
				
		}
		
		boolean ans = true;
		for(int i=0; i<cnt.length; i++) {
			if((cnt[i] == max) && (i!=max_idx)) {
				ans = false;
			}
		}
		
		if(ans) {
			System.out.println(new_str[max_idx]);
		}
		else
			System.out.println("?");
		
		
		
	}
}	