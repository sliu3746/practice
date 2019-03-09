package jiuchangpractice.boot.algorithm.class4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMaximum {
	
    /**
     * @param nums: A list of integers.
     * @param k: An integer
     * @return: The maximum number inside the window at each moving.
     */
	private void InQue(Deque<Integer> deque, int i, int[] nums) {
		while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
			deque.pollLast();
		}
		deque.offer(i);
	}
	
    public List<Integer> maxSlidingWindow(int[] nums, int k) {
		List<Integer> ans = new ArrayList<>();
		if(nums == null || nums.length == 0){
		    return ans;
		}
		Deque<Integer> deque = new ArrayDeque<>();
		
		for(int i = 0; i < k - 1; i++) {
			InQue(deque, i, nums);			
		}
		
		for(int i = k - 1; i < nums.length; i++) {
			InQue(deque, i, nums);	
			ans.add(nums[deque.peekFirst()]);
			OutQueue(deque, i-k+1);
		}
		
        // write your code here
    	return ans;
    }
    
    
	private void OutQueue(Deque<Integer> deque, int i) {
		// TODO Auto-generated method stub
		if(i == deque.peekFirst()) {
			deque.pollFirst();
		}		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {8,7,7,2,1,4};//{1,2,7,7,8};
		SlidingWindowMaximum swm = new SlidingWindowMaximum();
		swm.maxSlidingWindow(nums, 3);

	}

}
