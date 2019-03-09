package jiuchangpractice.boot.algorithm.class6;

public class EditDistance {
 
	/**
     * @param word1: A string
     * @param word2: A string
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // write your code here
    	char[] A = word1.toCharArray();
    	char[] B = word2.toCharArray();
    	int m = A.length;
    	int n = B.length;
    	int[][] f = new int[m+1][n+1];
    	
    	for(int i =0; i <= m; i++) {
    		f[i][0] = i;
    		for(int j = 1; j <= n; j++) {
    			if(i == 0) {
    				f[i][j] = j;
    				continue;
    			}
    			f[i][j] = Math.min(Math.min(f[i][j-1], f[i-1][j]), f[i-1][j-1]) + 1;
    			if(A[i-1] == B[j-1]) {
    				f[i][j] = f[i-1][j-1];
    			}
    		}
    	}
    	return f[m][n];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word1 = "mart";
		String word2 = "karma";
		EditDistance ed = new EditDistance();
		ed.minDistance(word1, word2);
		
	}

}
