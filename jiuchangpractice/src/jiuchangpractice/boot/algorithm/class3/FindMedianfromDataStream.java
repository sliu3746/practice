package jiuchangpractice.boot.algorithm.class3;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianfromDataStream {
	
    /**
     * @param nums: A list of integers
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
    	if(nums == null) {
    		return nums;
    	}
    	int size = nums.length;
    	PriorityQueue<Integer> qMin = new PriorityQueue<>();
    	PriorityQueue<Integer> qMax = new PriorityQueue<>(Collections.reverseOrder());
    	int[] retInts = new int[size];
    	
    	for(int i = 0; i < size; i++) {
    		if(qMax.isEmpty() || nums[i] <= qMax.peek()) {
    			qMax.offer(nums[i]);
    		}else {
    			qMin.add(nums[i]);
    		}
    		adjust(qMin, qMax);
    		retInts[i] = qMax.peek();
    	}
    	
    	return retInts;
    }
    
	private void adjust(PriorityQueue<Integer> qMin, PriorityQueue<Integer> qMax) {
		// TODO Auto-generated method stub
		if(qMax.size() < qMin.size()) {
			qMax.offer(qMin.poll());
		}
		
		if(qMax.size() > (qMin.size() + 1)) {
			qMin.offer(qMax.poll());
		}		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 3, 4, 5};
		FindMedianfromDataStream fmfds = new FindMedianfromDataStream();
		fmfds.medianII(nums);

	}

}
