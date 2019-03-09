package jiuchangpractice.boot.algorithm.class4;

public class CopyBooksII {
    /**
     * @param n: An integer
     * @param times: an array of integers
     * @return: an integer
     */
    public int copyBooksII(int n, int[] times) {
        // write your code here
    	int right = Integer.MAX_VALUE;
    	int left = 1;
    	
    	
    	while((left + 1) < right) {
    		int m = left + (right-left)/2;
    		if(check(times, m, n)) {
    			left = m;
    		}else {
    			right = m;
    		}  		
    	}    	
    	return right;
    }
    
	private boolean check(int[] times, int m, int n) {
		// TODO Auto-generated method stub
		int count = 0;
		for(int item: times) {
			count = count + m/item;
		}
		return count < n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] times = {3,2,4};
		CopyBooksII cb2 = new CopyBooksII();
		cb2.copyBooksII(4, times);		

	}

}
