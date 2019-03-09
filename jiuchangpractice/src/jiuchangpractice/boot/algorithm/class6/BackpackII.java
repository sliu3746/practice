package jiuchangpractice.boot.algorithm.class6;

public class BackpackII {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int[] V) {
        // write your code here
    	if(A == null || A.length == 0) {
    		return 0;
    	}
    	if(V == null || V.length == 0) {
    		return 0;
    	}
    	int N = A.length;
    	int[][] f = new int[2][m+1];
    	
    	int or = 1;
    	int nr = 0;
    	for(int i = 0; i <= N; i++) {
    		or = nr;
    		nr = 1 - or;
    		//System.out.println (or + " " + nr);
    		for(int k = 0; k <= m; k++) {
    			if(i == 0 && k == 0) {
    				f[or][k] = 0;
    				continue;
    			}
    			if(i == 0) {
    				f[or][k] = -1;
    				continue;
    			}
    			f[nr][k] = f[or][k];
    			if(k >= A[i-1] && f[or][k-A[i-1]] != -1){
    				f[nr][k] = Math.max(f[nr][k], f[or][k-A[i-1]]+ V[i-1]);
    			}
    		}
    	}
    	int ans = -1;
    	for(int j = m; j >=0; j--) {
    		if(f[nr][j] != -1) {
    			ans= f[nr][j];
    			break;
    		}
    	}
    	return ans;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2, 3, 5, 7};
		int[] V = {1, 5, 2, 4};
		BackpackII bp2 = new BackpackII();
		bp2.backPackII(10, A, V);

	}

}
