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
		
		int T = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(3);
		loop: for(int i=4; i<=10000;i++) {
			for(int j=2; j<=(int)Math.sqrt(i);j++) {
				if(i%j==0) {
					continue loop;
				}
			}
			list.add(i);//소수 리스트 생성
		}
		for(int t=0;t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			int min = Integer.MAX_VALUE;
			int small = 0;
			int large = 0;
			for(int num: list) {
				if(num>N/2) { break;}
				int sub = N-num;
				if(!list.contains(sub)) continue;
				int tmp = sub-num;
				min = Math.min(min, tmp);
				if(min == tmp) {
					small = num;
					large = sub;
				}
				
			}
			sb.append(small+" "+large+"\n");
		}
		System.out.println(sb.toString());
	}
}
	
