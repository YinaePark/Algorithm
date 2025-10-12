
import java.io.*;
import java.util.*;

public class Main {
	/* 
	 * 1. x,y로 바꾸기
	 * 2. 이동
	 * 3. 다시 숫자로 바꾸기
	 * 
	 * */

	static int d;
	static int[] num;
	static long x, y;
	
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		d = Integer.parseInt(st.nextToken());
		num = new int[d];
		char[] tmp = st.nextToken().toCharArray();
		for(int i=0; i<d; i++) {
			num[i] = tmp[i] - '0';
		}
		
		st = new StringTokenizer(br.readLine());
		x = Long.parseLong(st.nextToken());
		y = Long.parseLong(st.nextToken());
		
		// 좌표로 바꾸기
		long[] answer = toCoord(0,0,0);
		
		// 이동
		// 이때, 오른쪽이 +x, 위가 +y이므로
		long nx = answer[0] + x;
		long ny = answer[1] - y;
		
		long u = 1L<<d;
		if(nx < 0 || ny < 0 || nx >= u || ny >= u) {
			System.out.println(-1);
			return;
		}
		
		// 다시 바꾸기
		System.out.println(toNumber(nx, ny, 0, new StringBuilder()));
		
	} 
	
	static String toNumber(long x, long y, int depth, StringBuilder sb) {
		long unit = (1L<<(d-depth))/2; 
		
		long nx = x;
		long ny = y;
		if(x < unit) {
			if(y < unit) {
				sb.append("2");
			}else {
				sb.append("3");
				ny -= unit;
			}
		}else {
			if(y<unit) {
				sb.append("1");
				nx -= unit;
			}else {
				sb.append("4");
				nx -= unit;
				ny -= unit;
				
			}
		}
		
		if(depth ==  d-1) {
			return sb.toString();
		}
		
		return toNumber(nx, ny, depth+1, sb);
		
		
		
	}
	
	// 위치를 {x, y}로 바꾸기
	static long[] toCoord(long sx, long sy, int depth) {
		// 총 한변은 1<<d 임
		long unit = (1L<<(d-depth))/2; 
		
		long nx = sx;
		long ny = sy;
		if(num[depth] == 1) {
			nx += unit;
		}else if(num[depth] == 3) {
			ny += unit;
		}else if(num[depth] == 4) {
			nx += unit;
			ny += unit;
		}
		
		if(depth == d-1) {
			return new long[] {nx, ny};
		}
		
		return toCoord(nx, ny, depth+1);
		
	}
	
	
	
	

}
