package jiuchangpractice.boot.algorithm.class6;

public class LongestCommonSubsequence {
    /**
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
    	char[] AA = A.toCharArray();
    	char[] BB = B.toCharArray();
    	int m = AA.length;
    	int n = BB.length;
    	int[][] f = new int[m+1][n+1];
    	for(int i = 0; i <=m; i++) {
    		f[i][0] = 0;
    		for(int j = 1; j <= n; j++) {
    			if(i==0) {
    				f[i][j] = 0;
    				continue;
    			}
    			f[i][j] = Math.max(f[i-1][j], f[i][j-1]);
    			if(AA[i-1] == BB[j-1]) {
    				f[i][j] = Math.max(f[i][j], f[i-1][j-1] +1);
    			}
    		}
    	}
    	return f[m][n];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "ABCD";
		String B =  "EACB";
		
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		lcs.longestCommonSubsequence(A, B);
	}

}
