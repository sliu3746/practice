package jiuchangpractice.boot.algorithm.class5;

public class MinimumPathSum {
	/**
	 * @param grid: a list of lists of integers
	 * @return: An integer, minimizes the sum of all numbers along its path
	 */
	public int minPathSum(int[][] grid) {
		// write your code here
		int minSum = 0;
		if(grid == null || grid.length == 0 || grid[0].length == 0) {
			return minSum;
		}
		int n = grid.length;
		int m = grid[0].length;
		int oldRow = 1;
		int newRow = 0;
		int[][] f = new int[2][m];
		f[0][0] = grid[0][0];
		for(int j =1; j < m; j++) {
			f[newRow][j] = f[newRow][j - 1] + grid[newRow][j];
		}
		int count = 1;
		while(count < n) {
			for(int j = 0; j < m  && count < n; j++) {
				f[oldRow][j] = f[newRow][j];
				if(j > 0) {
					f[newRow][j] = Math.min(f[newRow][j-1], f[oldRow][j]) + grid[count][j];
					System.out.println("count " + count + " j " + j);
				}else {
					f[newRow][j] = f[oldRow][j] + grid[count][j];
				}
			}
			count++;
		}
		
		return f[newRow][m-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
		MinimumPathSum test = new MinimumPathSum();
		test.minPathSum(grid);
	}

}
