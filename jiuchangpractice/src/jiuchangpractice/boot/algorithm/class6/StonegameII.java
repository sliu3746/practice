package jiuchangpractice.boot.algorithm.class6;

public class StonegameII {
    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int stoneGame2(int[] A) {
        // write your code here
    	if(A == null || A.length <= 1) {
    		return 0;
    	}
    	int N = A.length;
    	int[] sum = new int[2*N+1];
    	sum[0] = 0;
    	for(int i = 1; i <= N; i++) {
    		sum[i] = sum[i-1] + A[i-1];
    	}
    	
		int[][] f = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			f[i][i] = 0;
			visited[i][i] = true;
		}
		int ans = dfs(f, sum, visited, 0, N - 1);

		return ans;    	
    }
    
	private int dfs(int[][] f, int[] sum, boolean[][] visited, int l, int r) {
		// TODO Auto-generated method stub
    	if(visited[l][r]) {
    		return f[l][r];
    	}
    	if(l == r) {
    		return sum[r+1]- sum[l];
    	}

    	int sum2 = sum[r+1]- sum[l];
    	f[l][r] = Integer.MAX_VALUE;
		for(int k = l+1; k <=r; k++) {
			f[l][r] = Math.min(dfs(f, sum, visited, l, k-1) + dfs(f, sum, visited, k, r) + sum2 , f[l][r]);
		}
		visited[l][r] = true;
		return f[l][r];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
