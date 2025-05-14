import java.io.*;
import java.util.*;

/*
 * 아이디어: 구현 -> 누적합
 * 1차 : 13분 
 * */
class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		
		// 누적합 만들기
		int [][] memo = new int[S.length()][26];	// 문자열 인덱스별 - 알파벳 누적합
		memo[0][S.charAt(0) - 'a']++;	// 첫번째 문자 누적 진행
		
		for(int i = 1; i < S.length(); i++) {
			// 전처리
			for(int j = 0; j < 26; j++) {
				memo[i][j] = memo[i-1][j];	// 모든 알파벳에 대해서 누적합 진행 -> (1)현재 값 = 이전 값
			}
			// 후 처리 -> 현재 알파벳 기준으로 누적합 증가 진행
			memo[i][S.charAt(i)-'a']++;
		}
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int alpha = (st.nextToken()).charAt(0)- 'a';
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			if(l == 0) {
				sb.append(memo[r][alpha]+"\n");
			}else {
				sb.append((memo[r][alpha] - memo[l-1][alpha])+"\n");	// S[l~r]까지의 누적합 위해서 l-1 하기
			}
		}
		
		// 정답 출력
		System.out.println(sb.toString());

	}

}
