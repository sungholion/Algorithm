import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		while(true) {
			if(t==0)
				break;
			
			String[] hotel = br.readLine().split(" ");
			int h = Integer.parseInt(hotel[0]);
			int w = Integer.parseInt(hotel[1]);
			int n = Integer.parseInt(hotel[2]);
			
			int[] room = new int[h*w];
			int room_num = 101;
			room[0] = room_num;
			
			for(int i=1; i<h*w; i++) {
				if(h==1) {
					room_num++;
					room[i] = room_num;
				}
				
				else {
					room_num += 100;
					room[i] = room_num;
					if(room_num/100 >= h) {
						room_num -= h*100;
						room_num++;
					}
				}
				
				
			}
			
			System.out.println(room[n-1]);
			t--;
		}
	}
}


/*
 * h = 1
 * ->
 * h > 1 ( h+100)
 
 * */
