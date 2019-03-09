package jiuchangpractice.boot.algorithm.class3;

import java.util.Stack;

public class LargestRectangleinHistogram {

	/**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
    	int maxArea = 0;
    	if(height == null || height.length == 0) {
    		return maxArea;
    	}
    	
    	int N = height.length;
    	Stack<Integer> left = new Stack<>();
    	int h = 0;
    	int w = 0;
    	int cur = 0;
    	for(int i = 0; i <= N; i++) {
    		if(i == N) {
    			cur = -1;
    		}else {
    			cur = height[i];
    		}
    		while(!left.isEmpty() && cur <= height[left.peek()]) {
    			h = height[left.pop()];
    			w = left.isEmpty()? i : i-left.peek() - 1;
    			maxArea = Math.max(maxArea, h * w);
    		}
    		left.push(i);
    	}
    	
    	return maxArea;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = {2,1,5,6,2,3};
		LargestRectangleinHistogram lrh = new LargestRectangleinHistogram();
		System.out.println(lrh.largestRectangleArea(height));

	}

}
