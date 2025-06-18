
import java.util.*;
import java.io.*;

class Main
{
	
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int h, w;
		h = sc.nextInt();
		w = sc.nextInt();
		int[] block = new int[w];
		for(int i=0; i<w; i++) {
			block[i] = sc.nextInt();
		}
		
		int leftMax = 0;
		int l = 0;
		int rightMax = w-1;
		int r = w-1;
		int water = 0;
		// 투포인터로 양쪽에서 접근
		while(l<r) {
			// 왼쪽벽이 더 낮을 경우 왼쪽이 확정됨
			if(block[l] < block[r]) {
				l++;
				leftMax = block[leftMax] > block[l] ? leftMax : l;
				water += block[leftMax] - block[l];
			}
			else {
				r--;
				rightMax = block[rightMax] > block[r] ? rightMax : r;
				water += block[rightMax] - block[r];
			}
		}
		
		System.out.println(water);
	}
	

}
