import java.io.*;
import java.util.*;

/*
 * 아이디어 : 두 수의 최대 공약수의 약수
 * */

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		
		int gcd = getGcd(Math.max(r, g), Math.min(r, g));	// 최대 공약수 구하기
		
		// 최대 공약수의 약수 구하기
		List<Integer> list = new ArrayList<>();
		for(int i = 1; i <= Math.sqrt(gcd); i++) {
			if(gcd%i == 0) {
				list.add(i);
				
				if(gcd/i != i) list.add(gcd/i);
			}
		}
		
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for(int n : list) {
			sb.append(n+" "+(r/n)+" "+(g/n)+"\n");
		}
		
		System.out.println(sb.toString());

	}
	
	static int getGcd(int a, int b) {
		if(b == 0) return a;
		else return getGcd(b, a%b);
	}

}
