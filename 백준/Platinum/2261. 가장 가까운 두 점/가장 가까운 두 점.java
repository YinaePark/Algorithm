
import java.io.*;
import java.util.*;

public class Main {
	/* 
	 * 참고: https://st-lab.tistory.com/256
	 * 1. 점의 (x,y)를 x좌표순으로 정렬
	 *    함수 : l 부터 r까지 점 중, 제일 가까운 두 점 사이 거리 반환
	 * 2. basecase : 
	 * 	  3개이하로 남으면 그냥 거리구하기
	 * 3. 반으로 나누고, 양쪽에서 재귀호출해서, 둘 중 작은 거리를 minDist에 저장.
	 * 4. 근데문제 : l, r 구간 내에서의 최솟값(아까 저장한 ret)보다, l과 r 사이의 최솟값이 더 작을수도
	 *            mid를 중심으로 minDist보다 가까운 쪽에 있는 candidate들만  비교해주기 
	 *            candidate를 비교할때에는 y축기준 정렬 후, 브루트포스(조합)으로 선택, 
	 *            y좌표 간 차이가 또 minDist보다 가까우면 거리계산해서 min과 비교
	 * 분할정복 : n log n 인데 y축정렬때문에 O(Nlog^2N)
	 * 
	 * */

	static int N;
	static int[][] points;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		points = new int[N][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			points[i][0] = Integer.parseInt(st.nextToken());
			points[i][1] = Integer.parseInt(st.nextToken());
		}
		
		
		Arrays.sort(points, (a,b)->(a[0]-b[0]));
		long result = getMinDist(0, N-1);
		System.out.println(result);
		
		
	} 
	
	
	static long getMinDist(int l, int r) {
		if((r-l+1)==2) {
			return calDist(points[l], points[l+1]);
		}
		
		if((r-l+1)==3) {
			long tmp1 = calDist(points[l], points[l+1]); 
			long tmp2 = calDist(points[l+2], points[l+1]);
			long tmp3 = calDist(points[l], points[l+2]);
			return Math.min(Math.min(tmp1, tmp2), tmp3);
		}
		
		// 두개로 쪼개서 재귀호출
		int mid = (l+r)/2;
		long result = Math.min(getMinDist(l, mid), getMinDist(mid+1, r));
		
		// mid를 중심으로, 거리가 recur 내에 있는 가운데 점들 비교하기
	    List<int[]> candidates = new ArrayList<>();
	    for(int i=l; i<=r; i++) {
	    	int xDiff= points[i][0] - points[mid][0];
	        if(xDiff * xDiff < result) {
	            candidates.add(points[i]);
	        }
	    }
		
		// y기준 정렬
		Collections.sort(candidates, (a,b)->(a[1] - b[1]));
		int candidateNums = candidates.size();
		// candidates 의 모든 2개씩고르는 조합에 대해, y간 차이가 minDist보다 작으면 비교해보기
		for(int i=0; i<candidateNums; i++) {
			for(int j=i+1; j<candidateNums && j<=i+7; j++) {
				int[] c1 = candidates.get(j);
				int[] c2 = candidates.get(i);
				int ydist = c1[1] - c2[1];
				if(ydist * ydist < result) {
					result = Math.min(calDist(c1, c2), result);
				}else {
					break;
				}
			}
		}
		
		return result;
		
	}
	
	static long calDist(int[] p1, int[] p2) {
		int x1 = p1[0];
		int x2 = p2[0]; 
		int y1 = p1[1];
		int y2 = p2[1];
		return (long)Math.pow(Math.abs(x1-x2),2) + (long)Math.pow(Math.abs(y1-y2),2);
	}


}
