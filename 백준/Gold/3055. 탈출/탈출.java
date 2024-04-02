import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int R, C, ax, ay;
	static char[][] board;
	static String input;
	static int[] tmp;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Queue<int[]> water = new LinkedList<int[]>(); // 물의 위치 후보
	static Queue<int[]> beaver = new LinkedList<int[]>(); // 고슴도치의 위치 후보
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R+2][C+2]; // 맵 바깥으로 벗어나는 경우를 배제하기 위해 테두리를 두름
		for (int i = 1; i <= R; i++) {
			input = br.readLine();
			for (int j = 0; j < C; j++) {
				if(input.charAt(j) == '*') water.add(new int[] {i,j+1});
				if(input.charAt(j) == 'S') beaver.add(new int[] {i,j+1});
				board[i][j+1] = input.charAt(j);
			}
		}
        
        // 테두리 두르기
		Arrays.fill(board[0], 'X');
		Arrays.fill(board[R+1], 'X');
		for (int i = 1; i < R+1; i++) {
			board[i][0] = 'X';
			board[i][C+1] = 'X';
		}
        
        
		int day = 0; // 탈출에 걸리는 일수 
		while(true) {
			day ++;
			int size = water.size(); // 물이 차오르는 좌표들의 길이만큼 반복
			for (int i = 0; i < size; i++) {
				tmp = water.poll(); 
				for (int j = 0; j < 4; j++) { // 상, 하, 좌, 우에 '.'이 있다면 물이 차올라야 하므로 다시 QUEUE에 넣음
					ax = tmp[0] + dx[j];
					ay = tmp[1] + dy[j];
					if(board[ax][ay] != '.') continue;
					board[ax][ay] = '*';
					water.add(new int[] {ax, ay});
				}
			}
			
			// 고슴도치 좌표의 후보들만큼 반복
			size = beaver.size();
			if(size == 0) { // 만약 고슴도치가 더이상 이동할 수 없다면 종료
				System.out.println("KAKTUS");
				return;
			}
            
       
			for (int i = 0; i < size; i++) {
				tmp = beaver.poll();
				for (int j = 0; j < 4; j++) {
					ax = tmp[0] + dx[j];
					ay = tmp[1] + dy[j];
					if (board[ax][ay] == 'D') { // 만약 비버 굴에 도착했을 경우 종료
						System.out.println(day);
						return;
					}
					if(board[ax][ay] != '.') continue; // 물이 차올랐거나 돌로 막혀있는 경우 진행 불가
					board[ax][ay] = 'S'; // 아닐 경우 고슴도치가 갈 수 있는 땅으로 만들고 
					beaver.add(new int[] {ax, ay}); // 고슴도치 이동 좌표 후보에 넣음
				}
			}
			
		}
		
		
	}
	
}