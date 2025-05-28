import java.io.*;
import java.util.*;

/*
 * (범위 확인) -> arr[i] >= 0 && arr[i] < 10^9 -> int 형 으로 선언
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
		int maxLength = -1;	// 최대 길이
		Arrays.sort(arr); 	// 오름차순 정렬
		int maxSub = arr[n-1] - arr[0];		// 길이 차이
		
		int common = 0;		// 공차
		
		while(common <= maxSub) {

			for(int i = 0; i < n-1; i++) {
				int preNum = arr[i];	// 이전 숫자
				int curLen = 1;			// 현재 공차로 진행할 경우 수열의 길이// 이전 숫자
				for(int j = i; j < n; j++) {
					if(Math.abs(preNum-arr[j]) == common) {
						preNum = arr[j];	// 이전 숫자 갱신
						curLen++;
					}
				}
				maxLength = Math.max(maxLength, curLen);
				if(maxLength == n) break;
			}
			if(maxLength == n) break;
			common++;
		}
		
		System.out.println(maxLength);

	}

}
