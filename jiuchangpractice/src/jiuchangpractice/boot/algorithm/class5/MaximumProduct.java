package jiuchangpractice.boot.algorithm.class5;

public class MaximumProduct {
    /**
     * @param nums: An array of integers
     * @return: An integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
    	if(nums == null || nums.length == 0) {
    		return 0;
    	}
    	int n = nums.length;
    	long max = nums[0];
    	long[] f = new long[n];
    	
    	for(int i = 0; i < n; i++) {
    		for(int j = i; j < n; j++) {
    			if(i == j) {
    				f[j] = nums[j];
    			}else {
    				f[j] = f[j-1] * nums[j];    				
    			}
    			if(f[j] > max) {
    				max = f[j];
    			}
    		}
    	}
    	
    	return (int) max;
    }
//    public int maxProduct(int[] nums) {
//        // write your code here
//    	if(nums == null || nums.length == 0) {
//    		return 0;
//    	}
//    	int n = nums.length;
//    	long max = Long.MIN_VALUE; 
//    	long[][] f = new long[n][n];
//    	
//    	for(int i = 0; i < n; i++) {
//    		for(int j = i; j < n; j++) {
//    			if(i == j) {
//    				f[i][j] = nums[j];
//    			}else {
//    				f[i][j] = f[i][j-1] * nums[j];    				
//    			}
//    			if(f[i][j] > max) {
//    				max = f[i][j];
//    			}
//    		}
//    	}
//    	
//    	return (int) max;
//    }    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,-3,2,4};
		MaximumProduct mp = new MaximumProduct();
		mp.maxProduct(nums);		

	}

}
