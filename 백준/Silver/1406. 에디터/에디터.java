import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	String str = br.readLine();
	LinkedList<Character> lst = new LinkedList<>();
	for(int i=0; i<str.length(); i++) lst.add(str.charAt(i));
	ListIterator<Character> it = lst.listIterator();
	while(it.hasNext()) {
		it.next();
	}
	
	int M = Integer.parseInt(br.readLine());
	for(int i=0; i<M; i++)
	{
		StringTokenizer st = new StringTokenizer(br.readLine());
		char ord = st.nextToken().charAt(0);

		if(ord == 'P') {
			char addChar = st.nextToken().charAt(0);
			it.add(addChar);
		}
		else if(ord == 'L') {
			if(it.hasPrevious())
				it.previous();
		}
		else if(ord == 'D') {
			if(it.hasNext())
				it.next();
		}
		else if(ord == 'B') {
			if(it.hasPrevious()) {
				it.previous();
				it.remove();
			}
		}
	}
	
	while(!lst.isEmpty()) bw.write(lst.poll());
	
	bw.flush();
	bw.close();
	br.close();
	}
}