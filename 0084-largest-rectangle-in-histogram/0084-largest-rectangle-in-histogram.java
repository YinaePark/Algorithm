class Solution {

 public static int largestRectangleArea(int[] heights) {
    	int n = heights.length + 1;
    	int[] extendedHeights = new int[n];
    	for(int i=0; i<n-1; i++) {
    		extendedHeights[i] = heights[i];
    	}

    	int maxArea = 0;
        
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int idx=0; idx<n; idx++) {

        	// 스택에 요소가 있으면
        	if(!stack.isEmpty()) {
        		// 오름차순 깨지면
        		if(extendedHeights[stack.peek()] > extendedHeights[idx]) {
        			
        			while(!stack.isEmpty() && extendedHeights[stack.peek()] > extendedHeights[idx]) {
        				int prev = stack.pop();
        			    int width = stack.isEmpty() ? idx : idx - stack.peek() - 1;
        				int rectangle = extendedHeights[prev] * width;
    					// System.out.println("idx : " + idx);
    					// System.out.println("지금?? : " + prev);
    					// System.out.println("idx값 : " + rectangle);
        				if(maxArea<rectangle) {

        					maxArea = rectangle;
        				}
        				
        			}
                    stack.push(idx);
                    continue;
        		}
        		// 오름차순일 경우
        		else {
        			stack.push(idx);
        			continue;
        		}
        	} else {
        		stack.push(idx);
        	}
        }
        
        if(!stack.isEmpty()) {
            while(!stack.isEmpty()){
                int prev = stack.pop();
                int rectangle= extendedHeights[prev] * (n-1);
                // System.out.println("밖, idx : " + prev);
                // System.out.println("idx값 : " + rectangle);
                if(maxArea<rectangle) {
                    maxArea = rectangle;
                }
            }
        	
        }
        return maxArea;
    }
}