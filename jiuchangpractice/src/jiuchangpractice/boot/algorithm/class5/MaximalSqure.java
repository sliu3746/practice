package jiuchangpractice.boot.algorithm.class5;

public class MaximalSqure {

    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        // write your code here
    	if(matrix == null || matrix.length ==0 || matrix[0].length == 0) {
    		return 0;
    	}
    	int m = matrix.length;
    	int n = matrix[0].length;
    	
    	int[][] f = new int[m][n];
    	
    	int max = 0;
    	
    	for(int i = 0; i < m; i++) {
    		f[i][0] = matrix[i][0];
    		max = Math.max(max, f[i][0]);
    		for(int j = 1; j < n; j++) {
    			if(i > 0) {
                    if(matrix[i][j] > 0) {
                        f[i][j] = Math.min(f[i - 1][j],Math.min(f[i][j-1], f[i-1][j-1])) + 1;
                    } else {
                        f[i][j] = 0;
                    }
    			}else  {
    				f[i][j] = matrix[i][j];
    			}
    			if(f[i][j] > max) {
    				max = f[i][j];
    			}
    		}    		
    	}
    	System.out.println(max);
    	return max*max;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{0,1,0,1,1,0},{1,0,1,0,1,1},{1,1,1,1,1,0},{1,1,1,1,1,1},{0,0,1,1,1,0},{1,1,1,0,1,1}};
		MaximalSqure ms = new MaximalSqure();
		ms.maxSquare(matrix);

	}

}
