package jiuchangpractice.boot.algorithm.class4;

public class MaximumAverageSubarrayII {
    /**
     * @param nums: an array with positive and negative numbers
     * @param k: an integer
     * @return: the maximum average
     */
    public double maxAverage(int[] nums, int k) {
        // write your code here
    	if(nums == null || nums.length == 0) {
    		return 0;
    	}
    	
    	double max = nums[0];
    	double min = nums[0];
    	for(int val : nums) {
    		max = Math.max(max, val);
    		min = Math.min(min, val);
    	}
    	while(min + 1.e-5 < max ) {
    		double mid = min + (max-min)/2;
    		if(check(nums, k, mid)) {
    			max = mid;
    		}else {
    			min = mid;
    		}
    	}
    	return min;
    }
    
	private boolean check(int[] nums, int k, double mid) {
		// TODO Auto-generated method stub
		double rightSum = 0;
		double leftSum = 0;
		double minLeftSum = 0;
		for(int i = 0; i < k; i++) {
			rightSum += nums[i] - mid;
		}
		
		for(int i = k; i <= nums.length; i++) {
			if(rightSum - minLeftSum >=0) {
				return true;
			}
			if(i < nums.length) {
				rightSum += nums[i] - mid;
				leftSum += nums[i-k] - mid;
				minLeftSum = Math.min(minLeftSum, leftSum);
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1,0,1};
		int k = 		3;
		MaximumAverageSubarrayII mas2 = new MaximumAverageSubarrayII();
		mas2.maxAverage(nums, k);

	}

}
