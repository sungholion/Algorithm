import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;	

public class Solution {
	static char[][] map;
	static int H, W;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int cur_y;
	static int cur_x;
	static char cur_dir;
	static char cur_ord;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
		
			for(int i=0; i<H; i++) {
				String input = br.readLine();
				for(int j=0; j<W; j++) {
					char data = input.charAt(j);
					if(data == '^' || data == 'v' || data == '<' || data == '>') {
						cur_y = i;
						cur_x = j;
						cur_dir = data;
					}
					map[i][j] = data;
				}
			}
			
			
			int N = Integer.parseInt(br.readLine());
			String ord = br.readLine();
			
			for(int i=0; i<ord.length(); i++) {
				cur_ord = ord.charAt(i);
				
				if(cur_ord == 'U') {
					cur_dir = '^';
					if(rangeCheck()) {
						map[cur_y][cur_x] = '.';
						cur_y--;
					
					}
					map[cur_y][cur_x] = cur_dir;
				}
				else if(cur_ord == 'D') {
					cur_dir = 'v';
					if(rangeCheck()) {
						map[cur_y][cur_x] = '.';
						cur_y++;
					}
					map[cur_y][cur_x] = cur_dir;
				}
				else if(cur_ord == 'L') {
					cur_dir = '<';
					if(rangeCheck()) {
						map[cur_y][cur_x] = '.';
						cur_x--;
					}
					map[cur_y][cur_x] = cur_dir;
				}
				else if(cur_ord == 'R') {
					cur_dir = '>';
					if(rangeCheck()) {
						map[cur_y][cur_x] = '.';
						cur_x++;
					}
					map[cur_y][cur_x] = cur_dir;
				}
				else if(cur_ord == 'S') {
					if(cur_dir == '^') {
						for(int ny=cur_y; ny >= 0 ;ny--) {
							if(map[ny][cur_x] == '*') {
								map[ny][cur_x] = '.';
								break;
							}
							else if(map[ny][cur_x] == '#') break;
							else continue;
						}
					}
					else if(cur_dir == 'v') {
						for(int ny=cur_y; ny < H ;ny++) {
							if(map[ny][cur_x] == '*') {
								map[ny][cur_x] = '.';
								break;
							}
							else if(map[ny][cur_x] == '#') break;
							else continue;
						}
					}
					else if(cur_dir == '<') {
						for(int nx=cur_x; nx >= 0 ;nx--) {
							if(map[cur_y][nx] == '*') {
								map[cur_y][nx] = '.';
								break;
							}
							else if(map[cur_y][nx] == '#') break;
							else continue;
						}					
					}
					else if(cur_dir == '>') {
						for(int nx=cur_x; nx < W ; nx++) {
							if(map[cur_y][nx] == '*') {
								map[cur_y][nx] = '.';
								break;
							}
							else if(map[cur_y][nx] == '#') break;
							else continue;
						}
					}
				}
				
//				System.out.println(i + ". cur_ord : " + cur_ord);
//				for(int j=0; j<H; j++) {
//					for(int k=0; k<W; k++) {
//						System.out.print(map[j][k]);
//					}
//					System.out.println();
//				}
//				System.out.println();
			}
			
			System.out.print("#" + (tc+1) + " ");
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			
		}
		
	}
	static boolean rangeCheck() {
		int ny = 0, nx = 0;
		
		if(cur_dir == '^') {
			ny = cur_y + dy[0];
			nx = cur_x + dx[0];
			if(ny >= 0 && ny < H && nx >= 0 && nx < W && map[ny][nx] == '.') {
				return true;
			}
			else 
				return false;
		}
		else if(cur_dir == 'v'){
			ny = cur_y + dy[1];
			nx = cur_x + dx[1];
			if(ny >= 0 && ny < H && nx >= 0 && nx < W && map[ny][nx] == '.') {
				return true;
			}
			else 
				return false;
		}
		else if(cur_dir == '<'){
			ny = cur_y + dy[2];
			nx = cur_x + dx[2];
			if(ny >= 0 && ny < H && nx >= 0 && nx < W && map[ny][nx] == '.') {
				return true;
			}
			else 
				return false;
		}
		else if(cur_dir == '>'){
			ny = cur_y + dy[3];
			nx = cur_x + dx[3];
			if(ny >= 0 && ny < H && nx >= 0 && nx < W && map[ny][nx] == '.') {
				return true;
			}
			else 
				return false;
		}
		
		return false;
	}
}