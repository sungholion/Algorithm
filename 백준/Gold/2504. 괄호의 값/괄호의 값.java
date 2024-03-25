import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		Stack<Character> s = new Stack<>();	// 괄호 담을 스택
		
		int tmp = 1;	// 임시 계산
		int ans = 0;	// 최종 계산
		char x = 0;		// 문자 확인
		for(int i=0; i<str.length(); i++) 
		{
			x = str.charAt(i);		// 문자를 확인해서
			// 여는 괄호
			if(x == '(')			// 여는 괄호이면 
			{
				s.push(x);			// 괄호를 스택에 넣고
				tmp*=2;				// tmp에 곱하기 (2 or 3)
			}
			else if(x == '[') 
			{
				s.push(x);
				tmp*=3;
			}
			
			// 닫는 괄호
			else if(x == ')') 			// 닫는 괄호이면
			{
				// 스택이 비어있거나, 괄호쌍이 안맞으면 옳지 않은 괄호열
				if(s.isEmpty() || s.peek() != '(') 	
				{
					ans = 0;
					break;
				}
				
				else if(str.charAt(i-1) == '(') 		// 현재 괄호와 쌍이 맞으면
				{
					ans += tmp;
				}
				s.pop();
				tmp /= 2;
				
			}
			else if(x == ']') 
			{
				if(s.isEmpty() || s.peek() != '[') 
				{
					ans = 0;
					break;
				}
				
				else if(str.charAt(i-1) == '[') 
				{
					ans += tmp;
				}
				s.pop();
				tmp /=3;
			}
		}
		if(!s.isEmpty()) 
			ans = 0;
		bw.write(ans + "");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
