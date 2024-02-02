import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Solution {
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int tc=1; tc<=10; tc++) {
			int l = Integer.parseInt(br.readLine());
			String str = br.readLine();
			char[] arr = str.toCharArray();
			Stack<Character> s = new Stack<>();
			
			ans = 1;
			for(int i=0; i<arr.length; i++) {
				if(arr[i] == '(' || arr[i] == '[' || arr[i] == '{' || arr[i] == '<') {
					s.add(arr[i]);
				}
				else {
					char com = s.pop();
					if(arr[i] == ')') {
						if(com != '(') {
							ans = 0;
							break;
						}
					}
					else if(arr[i] == ']') {
						if(com != '[') {
							ans = 0;
							break;
						}
					}
					else if(arr[i] == '}') {
						if(com != '{') {
							ans = 0;
							break;
						}
					}
					else if(arr[i] == '>') {
						if(com != '<') {
							ans = 0;
							break;
						}
					}
				}
			}
			
			System.out.println("#" + tc + " " + ans);
			
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}