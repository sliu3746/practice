package jiuchangpractice.boot.algorithm.class5;

public class BurstBalloons {
	
    /**
     * @param nums: A list of integer
     * @return: An integer, maximum coins
     */
    public int maxCoins(int[] nums) {
        // write your code here
		int ans = 0;
		if (nums == null || nums.length == 0) {
			return ans;
		}
		int N = nums.length;
		int[] A = new int[N+2];
		A[0] = A[N+1] = 1;
		for(int i = 1; i < N + 1; i++) {
			A[i] = nums[i-1];
		}
		int[][] f = new int[N + 2][N + 2];
		int [][] visit = new int[N+2][N+2];
		
		ans = dfs(A, f, visit, 1, N);

		return ans;
	}
    
	private int dfs(int[] a, int[][] f, int[][] visit, int left, int right) {
		// TODO Auto-generated method stub
		if(visit[left][right] == 1) {
			return f[left][right];
		}
		int ans = 0;
		for(int k = left; k <= right; k++) {
			int val = a[left - 1] * a[k] * a[right+1];
			int val1 = dfs(a, f, visit, left, k - 1);
			int val2 = dfs(a, f, visit, k + 1, right );
			ans = Math.max(ans, val1 + val2 + val);
		}
		visit[left][right] = 1;
		f[left][right] = ans;
		
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4, 1, 5, 10};
		BurstBalloons bb = new BurstBalloons();
		bb.maxCoins(nums);

	}

}
