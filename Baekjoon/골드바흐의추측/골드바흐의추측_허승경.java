import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		boolean [] prime = new boolean[10001];
		Arrays.fill(prime,  true);
		prime[0] = false;
		prime[1] = false;
		
		for(int i = 2; i*i < prime.length; i++) {
			if(prime[i] == false) continue;
			
			for(int j = i*i; j < prime.length; j += i) {
				prime[j] = false;		// 배수는 소수X
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			// 소수 차이가 작은 값 구하기
			for(int i = n/2; i >= 2; i--) {
				if(prime[i] && prime[n-i]) {
					sb.append(i + " "+(n-i)+"\n");
					break;
				}
			}
		}
		
		// 결과 출력
		System.out.println(sb.toString());

	}

}
