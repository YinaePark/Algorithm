
import java.io.*;
import java.util.*;

public class Main {
	/* 전위:preorder: 루,왼,오
	 * 중위:inorder:왼루오
	 * 후위:postorder:왼오루
	 * 
	 * * */

	static int N, M;

	// l, r 저장
	static int[] left;
	static int[] right;
	static StringBuilder pre = new StringBuilder();
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		left = new int[N];
		right = new int[N];
		Arrays.fill(left, -1);
		Arrays.fill(right, -1);
		
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			int v = st.nextToken().charAt(0) - 'A';
			int l = st.nextToken().charAt(0) -'A';
			int r = st.nextToken().charAt(0)-'A';
			
			if(l != '.'-'A')
				left[v] = l;
			if(r != '.'-'A')
				right[v] = r;
			
		}
		
		// 루트노드:A
		
		preOrder(0);
		pre.append("\n");
		inOrder(0);
		pre.append("\n");
		postOrder(0);
		
		System.out.println(pre.toString());
		
		
	}
	
	static void preOrder(int now) {
		if(now == -1)
			return;
		pre.append((char)(now+'A'));
		preOrder(left[now]);
		preOrder(right[now]);
	}
	
	static void inOrder(int now) {
		if(now == -1)
			return;
		inOrder(left[now]);
		pre.append((char)(now+'A'));
		inOrder(right[now]);

		
	}
	
	static void postOrder(int now) {
		if(now == -1)
			return;
		postOrder(left[now]);
		postOrder(right[now]);
		
		pre.append((char)(now+'A'));


		
	}
	
	
	
}
