import java.io.*;
import java.util.*;

/*
 * (범위 확인) -> arr[i] >= 0 && arr[i] < 10^9 -> int 형 으로 선언
 * 아이디어 : dp
 * -> 
 * ---
 * 초기 아이디어: 이분탐색 -> 아닌듯 => 선형탐색? -> 시간초과 발생
 * 1. 배열에 저장 후, 오름차순 정렬하기
 * 2. 제일 작은 값과 큰 값의 차 구하기
 * 3. left = 0, right = 1로 해서 이분탐색하면서, right <= (2)번 값 될때까지 찾기
 * */
public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int [] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr); 	// 오름차순 정렬
		int maxLength = 1;	// 최대 길이 초기화 (n의 최솟값 1)
		
		Map<Integer, Integer> [] dp = new HashMap[n]; 	// key:공차, value: 등차수열 길이
		for(int i = 0; i < n; i++) {
			dp[i] = new HashMap<>();	// 초기화 / dp[i] -> arr[i]를 수열의 끝 원소로 하는 등차수열의미 
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < i; j++) {
				int diff = arr[i] - arr[j];		// 공차
				int preLength = dp[j].getOrDefault(diff, 1);	// 최소 길이는 2부터 시작 / 이전값은 dp[j]
				int curLength = preLength + 1;	// 현재 등차 수열 길이
				
				dp[i].put(diff, Math.max(dp[i].getOrDefault(diff, 0), curLength));
				maxLength = Math.max(maxLength, curLength);
			}
		}
		
		System.out.println(maxLength);

	}

}
