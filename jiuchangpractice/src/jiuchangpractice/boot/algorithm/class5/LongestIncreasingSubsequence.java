package jiuchangpractice.boot.algorithm.class5;

public class LongestIncreasingSubsequence {

    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
    	if(nums == null || nums.length == 0) {
    		return 0;
    	}
    	int N = nums.length;
    	int[] f = new int[N];
    	int max = 0;
    	for(int i = 0; i < N ; i++) {
    		f[i] = 1;
    	}
    	
    	for(int i = N-2; i>=0; i--) {
    		int val = nums[i];
    		int maxj = 0;
    		for(int j = i+1; j< N; j++ ) {
    			if(nums[j] > val && maxj < f[j]) {
    				maxj = f[j];
    			}
    		}
    		f[i] += maxj;
    		//System.out.println("i " + i + " j " );
    		if(f[i] > max) {
    			max = f[i];
    		}
    	}
    	//System.out.println(max);
    	return max;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 7, 3};
		LongestIncreasingSubsequence test = new LongestIncreasingSubsequence();
		test.longestIncreasingSubsequence(nums);

	}

}
