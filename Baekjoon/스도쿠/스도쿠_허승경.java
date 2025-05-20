import java.io.*;
import java.util.*;

/*
 * 아이디어: 구현, 백트래킹..?
 * 1. 3*3 시작 -> 행, 열 맞추기 -> 실패
 * -> 3*3이 아니라 전체 map에서 비어있는 곳 기준으로 탐색하기
 * */
public class Main {
	static int [][] map;
	static List<int[]> list = new ArrayList<>();
	static int n;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = 9;
		map = new int[n][n];
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j) - '0';
				if(map[i][j] == 0) list.add(new int [] {i, j});	// 비어있는 위치 저장
			}
		}
		
		// 스토쿠 풀기
		boolean flag = goSudoku(0);
		
		// 정답 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static boolean goSudoku(int idx) {
		// 비어 있는 곳 전체 탐색
		if(idx == list.size()) {
			return true;
		}
		
		int curX = list.get(idx)[0];
		int curY = list.get(idx)[1];
		
		for(int k = 1; k <= n; k++) {
			if(isValid(curX, curY, k)) {
				map[curX][curY] = k;
				if(goSudoku(idx+1)) return true;	// 정답 찾음 -> 더이상 진행 X
				map[curX][curY] = 0;	// 다시 초기화
			}
		}
		
		return false;
	}
	
	static boolean isValid(int x, int y, int target) {
		if(checkMiniMap(x, y, target) &&
				checkRow(x, y, target) &&
				checkColumn(x, y, target)) return true;
		
		return false;	
	}
	
	static boolean checkMiniMap(int x, int y, int target) {
		//x, y가 포함된 3*3의 숫자 정보 확인하기
		int row = x/3*3;	// 0, 3, 6, 9 단위로 시작하니까
		int col = y/3*3;
		
		for(int i = row; i < row+3; i++) {
			for(int j = col; j < col+3; j++) {
				if(map[i][j] == target) return false;	// 이미 존재
			}
		}
		
		return true;
	}
	
	static boolean checkRow(int x, int y, int target) {
		for(int j = 0; j < n; j++) {
			if(map[x][j] == target) return false;		// 같은 행에 target이 이미 존재
		}
		
		return true;
	}

	static boolean checkColumn(int x, int y, int target) {
		for(int i = 0; i < n; i++) {
			if(map[i][y] == target) return false;		// 같은 열에 target이 이미 존재
		}
		
		return true;
	}
}
