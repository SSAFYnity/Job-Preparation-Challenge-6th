import java.io.*;
import java.util.*;

/*
 * (범위 확인) -> arr[i] >= 0 && arr[i] < 10^9 -> int 형 으로 선언
 * 아이디어 : dp + map
 * 개선 : dp + 이분탐색
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
		int [] arr = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr); 	// 오름차순 정렬
		int [][] dp = new int[n+1][n+1];	// dp[i][j] -> 수열의 마지막이 dp[i], dp[j]로 끝나는 등차수열 길이의 최댓값
		
		int maxLength = 1;	// 최대 길이 초기화 (n의 최솟값 1)
		
		for(int i = 1; i < n; i++) {
			for(int j = i+1; j <= n; j++) {
				dp[i][j] = 2;		// arr[i], arr[j] 두 개 존재
				int preNum = 2*arr[i] - arr[j];		// (a, b, c가 등차수열일때, 2*b = a+c니까)
				
				// preNum 존재하는지 찾기
				int left = 1;		// arr는 1부터 시작
				int right = i-1;	// 현재 마지막에서 두번재 원소가 arr[i]니까, 이것보다 1 작은수까지가 limit
				while(left < right) {
					int mid = (left + right)/2;
					
					if(arr[mid] < preNum) left = mid + 1;
					else if(arr[mid] == preNum && arr[right] == preNum)left = mid + 1;
					else right = mid;
				}

				if(arr[right] == preNum) {
					dp[i][j] = Math.max(dp[i][j], dp[right][i]+1);
				}
				maxLength = Math.max(maxLength, dp[i][j]);
			}
		}
		
		System.out.println(maxLength);

	}

}
