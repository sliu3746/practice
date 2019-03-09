package jiuchangpractice.boot.algorithm.class5;

public class LongestContinuousIncreasing {
	
    /**
     * @param A: An array of Integer
     * @return: an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here
    	int max = 0;
    	if(A == null || A.length == 0) {
    		return max;
    	}
    	int tem1 = 1;
    	int tem2 = 1;
    	max = 1;
    	for(int i = 1; i < A.length; i++) {
    		if(A[i] > A[i-1]) {
    			tem1++;
    			max = Math.max(max, tem2);
    			tem2 = 1;
    		}else {
    			max = Math.max(max, tem1);
    			tem1 = 1;
    			tem2++;
    		}
    	}
    	max = Math.max(tem1, Math.max(tem2, max));
    	//System.out.println("max " + max);
    	return max;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {5, 1, 2, 3, 4};
		LongestContinuousIncreasing test = new LongestContinuousIncreasing();
		test.longestIncreasingContinuousSubsequence(A);
	}

}
