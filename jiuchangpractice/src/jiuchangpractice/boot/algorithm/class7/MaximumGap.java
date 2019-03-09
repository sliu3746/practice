package jiuchangpractice.boot.algorithm.class7;

import java.util.ArrayList;
import java.util.List;

public class MaximumGap {

	/**
     * @param nums: an array of integers
     * @return: the maximun difference
     */
    public int maximumGap(int[] nums) {
        // write your code here
    	int maxGap = 0;
    	if(nums == null || nums.length < 2) {
    		return maxGap;
    	}
    	int max = Integer.MIN_VALUE;
    	int min = Integer.MAX_VALUE;
    	
    	for(int val : nums) {
    		if(val > max) {
    			max = val;
    		}
    		if(val < min) {
    			min = val;
    		}
    	}
    	int N = nums.length;
    	
    	int bSize = (max- min)/N;
    	
    	List<Bucket> list = new ArrayList<>();
    	int tem = min;
    	while(tem <= max) {
    		int temMax = bSize + tem;
    		Bucket temBucket = new Bucket(temMax, tem); // reverse for init
    		list.add(temBucket);
    		tem = temMax + 1;    		
    	}
    	
    	for(int val : nums) {
    		int bIndex = (val - min)/ (bSize + 1);
    		int bMin = list.get(bIndex).minVal;
    		int bMax = list.get(bIndex).maxVal;
    		if(val > bMax) {
    			list.get(bIndex).setMaxVal(val);
    		}
    		if(val < bMin) {
    			list.get(bIndex).setMinVal(val);
    		}    		
    	}  
    	List<Bucket> list2 = new ArrayList<>();
    	for(int i = 0; i < list.size(); i++) {
    		if(list.get(i).maxVal >= list.get(i).minVal) {
    			list2.add(list.get(i));
    		}    		
    	}
    	for(int i = 1; i < list2.size(); i++) {
     		int temVal = list2.get(i).minVal - list2.get(i-1).maxVal;
    		if(temVal > maxGap) {
    			maxGap = temVal;
    		}
    	}
    	
    	return maxGap;
    }
    
	class Bucket {
		int maxVal;

		public int getMaxVal() {
			return maxVal;
		}

		public void setMaxVal(int maxVal) {
			this.maxVal = maxVal;
		}

		public int getMinVal() {
			return minVal;
		}

		public void setMinVal(int minVal) {
			this.minVal = minVal;
		}

		int minVal;

		public Bucket(int min, int max) {
			minVal = min;
			maxVal = max;
		}

	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2147483647,0}; //3,2,1,4,3};
		MaximumGap mg = new MaximumGap();
		mg.maximumGap(nums);
	}

}
