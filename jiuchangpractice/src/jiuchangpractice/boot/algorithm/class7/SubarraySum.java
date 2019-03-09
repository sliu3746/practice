package jiuchangpractice.boot.algorithm.class7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubarraySum {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum(int[] nums) {
        // write your code here
    	if(nums == null || nums.length == 0) {
    		return new ArrayList<>();
    	}
    	int N = nums.length;
    	int[] sum = new int[N];
    	sum[0] = nums[0];
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int i = 1; i < N; i++) {
    		sum[i] = sum[i-1] + nums[i];    		
    	}
    	List<Integer> list = new ArrayList<>();
    	for(int i = 0; i < N; i++) {
    		if(map.containsKey(sum[i])) {
    			list.add(map.get(sum[i]) + 1);
    			list.add(i);
    			break;
    		}else if(sum[i] == 0) {
    			list.add(0);
    			list.add(i);
    		}
    		map.put(sum[i], i);
    	}
    	
    	return list;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
