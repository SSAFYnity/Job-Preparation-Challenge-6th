import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int [][] display;
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
	static boolean [][] visited;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		display = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			String [] tmp = br.readLine().split(" ");
			int j = 0;
			for(int k = 0; k < tmp.length; k+=3) {
				int avg = (Integer.parseInt(tmp[k]) + Integer.parseInt(tmp[k+1]) + Integer.parseInt(tmp[k+2])) / 3;
				display[i][j++] = avg;
			}
		}
		
		int t = Integer.parseInt(br.readLine());
		
		// 경곗값 판단
		for(int i =0 ; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(display[i][j] >= t) display[i][j] = 255;
				else display[i][j] = 0;
			}
		}

		// 물체 인식
		int answer = 0;
		visited = new boolean[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(display[i][j] == 255 & !visited[i][j]) {
					dfs(i, j);
					answer++;
				}
			}
		}
		
		// 정답 출력
		System.out.println(answer);

	}
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int tx = x + dx[i];
			int ty = y + dy[i];
			
			if((tx >= 0 & tx < n & ty >= 0 & ty < m)) {
				if(display[tx][ty] == 255 & !visited[tx][ty]) {
					dfs(tx, ty);					
				}
			}
		}
		
		return;
	}

}
