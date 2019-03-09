package jiuchangpractice.boot.algorithm.class5;

public class LongestContinuousIncreasingSubsequenceII {
    /**
     * @param matrix: A 2D-array of integers
     * @return: an integer
     */
	int[][] f;
    public int longestContinuousIncreasingSubsequence2(int[][] matrix) {
        // write your code here
    	if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
    		return 0;
    	}
    	int m = matrix.length;
    	int n = matrix[0].length;
    	
    	f = new int[m][n];
    	for(int i = 0; i < m; i++) {
    		for(int j=0; j <n; j++) {
    			f[i][j] = -1;
    		}
    	}
    	int max = 0;
    	
    	for(int i = 0; i < m; i++) {
    		for(int j=0; j <n; j++) {
    			dsf(matrix, i, j);
    			max = Math.max(max, f[i][j]);
    		}
    	}
    	return max;
    }
    
	private void dsf(int[][] matrix,  int i, int j) {
		// TODO Auto-generated method stub
		if(f[i][j]  != -1) {
			return;
		}
		//System.out.println("i " + i + " j " + j + " " + f[i][j]);
    	int[] dx = {1,0,0,-1};
    	int[] dy = {0,1,-1,0};
    	int x, y;
    	f[i][j] = 1;
		for(int k = 0; k< dx.length; k++) {
			x = i+ dx[k];
			y = j +dy[k];
			//System.out.println("x " + x + " y " + y );
			if(isValid(matrix.length, matrix[0].length, x, y) && matrix[x][y] > matrix[i][j]) {
				dsf(matrix, x, y);
				f[i][j] = Math.max(f[i][j], f[x][y] + 1);
			}
		}				
	}

	private boolean isValid(int m, int n, int x, int y) {
		// TODO Auto-generated method stub
		return x >= 0 && x < m && y >=0 && y <n;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,2},{4,3}};
		LongestContinuousIncreasingSubsequenceII test = new LongestContinuousIncreasingSubsequenceII();
		test.longestContinuousIncreasingSubsequence2(matrix);

	}

}
