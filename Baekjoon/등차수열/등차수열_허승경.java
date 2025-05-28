import java.io.*;
import java.util.*;

/*
 * (범위 확인) -> arr[i] >= 0 && arr[i] < 10^9 -> int 형 으로 선언
 * 아이디어 : arr[i]를 끝원소로 하는 등차수열  
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
		Set<Integer> set = new HashSet<>();
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			set.add(arr[i]);
		}
		
		Arrays.sort(arr); 	// 오름차순 정렬
		int maxLength = 1;	// 최대 길이 초기화 (n의 최솟값 1)
		
		for(int i = 0; i < n-1; i++) {
			for(int j = i+1; j < n; j++) {
				int diff = arr[j]-arr[i];		// 앞-뒤 원소의 차
				int curLength = 2;					// 원소의 길이(현재 2)
				int nextNum = arr[j]+diff;		// 다음 원소 값
				
				while(set.contains(nextNum)) {
					curLength++;
					nextNum += diff;
				}
				
				maxLength = Math.max(maxLength, curLength);
			}
		}
		
		System.out.println(maxLength);

	}

}
