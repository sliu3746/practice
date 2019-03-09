package jiuchangpractice.boot.algorithm.class3;

import java.util.Stack;

public class MaximalRectangle {
    /**
     * @param matrix: a boolean 2D matrix
     * @return: an integer
     */
    public int maximalRectangle(boolean[][] matrix) {
        // write your code here
    	int maxArea = 0;
    	if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
    		return maxArea;
    	}
        int[][] height = new int[matrix.length][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (! matrix[i][j]) {
                    height[i][j] = 0;
                } else {
                    height[i][j] = i == 0 ? 1 : height[i - 1][j] + 1;
                }
            }
        }
    	//int[] height = new int[matrix[0].length];
    	for(int row = 0; row < matrix.length; row++) {
    		//height = this.getheights(matrix, row);
    		maxArea = Math.max(maxArea, this.getMaxArea(height[row]));
    	}
    	
    	return maxArea;
    }
    
    private int getMaxArea(int[] A) {
    	Stack<Integer> monotonousS = new Stack<>();
    	int maxArea = 0;
    	int height = 0;
    	int w = 0;
    	int cur = 0;
    	for(int i =0; i <= A.length; i++) {
    		cur = (i == A.length)? -1:A[i];
    		while(!monotonousS.isEmpty() && cur <= A[monotonousS.peek()]) {
    			height = A[monotonousS.pop()];
    			w = monotonousS.isEmpty() ? 1 : i - monotonousS.peek() - 1;
    			maxArea = Math.max(maxArea, height * w);
    		}
    		monotonousS.push(i);
    	}
    	
    	return maxArea;
    }
    
//    private int[] getheights(boolean[][] matrix, int row) {
//    	int length = matrix[0].length;
//    	int[] height = new int[length];
//    	
//    	for(int i = row; i >=0 ; i--) {
//    		for(int j =0; j < length; j++) {
//    			if(height[j] == (row- i) && matrix[i][j]) {
//    				height[j]++;
//    			}
//    		}
//    	}
//    	
//    	return height;
//    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
