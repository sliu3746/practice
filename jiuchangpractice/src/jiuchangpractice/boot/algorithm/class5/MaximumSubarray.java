package jiuchangpractice.boot.algorithm.class5;

public class MaximumSubarray {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code here
    	if(nums == null || nums.length == 0) {
    		return 0;
    	}
    	int N = nums.length;
    	int max = Integer.MIN_VALUE;
    	int sum = 0;
    	for(int i = 0; i < N; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }
    	
    	return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-2,2,-3,4,-1,2,1,-5,3};
		MaximumSubarray ms = new MaximumSubarray();
		ms.maxSubArray(nums);
	}

}
