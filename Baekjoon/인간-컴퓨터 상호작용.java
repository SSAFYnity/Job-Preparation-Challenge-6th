import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String S = br.readLine();
		int [][] map  = new int[S.length()+1][26];
		for(int i=1; i<=S.length(); i++) {
			char now = S.charAt(i-1);
			for(int j=0;j<26;j++) {
				
				if((int)now-'a'==j) {
					map[i][j]=map[i-1][j]+1;
				}else {
					map[i][j]=map[i-1][j];
				}
				
			}
		}
		
		
		
		int q = Integer.parseInt(br.readLine());
		for(int i=0; i<q; i++) {
			String [] question = br.readLine().split(" ");
			char alpha = question[0].toCharArray()[0];
			int st = Integer.parseInt(question[1])+1;//부터
			int ed = Integer.parseInt(question[2])+1;//까지
			sb.append(map[ed][(int)alpha-'a']-map[st-1][(int)alpha-'a']+"\n");
		}
		System.out.println(sb.toString());
	}
}
	
