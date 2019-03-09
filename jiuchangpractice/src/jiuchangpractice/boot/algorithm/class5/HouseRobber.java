package jiuchangpractice.boot.algorithm.class5;

public class HouseRobber {
    /**
     * @param A: An array of non-negative integers
     * @return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        // write your code here
    	if(A == null || A.length ==0) {
    		return 0;
    	}
    	long[] f = new long[A.length];
    	f[0] = A[0];
    	if(A.length > 1) {
    		f[1] = Math.max(A[0], A[1]);
    	}
    	for(int i = 2; i < A.length; i++) {
    		f[i] = Math.max(A[i] + f[i-2], f[i-1]);
    	}
    	return f[A.length - 1];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3, 8, 4};
		HouseRobber hr = new HouseRobber();
		hr.houseRobber(A);
	}

}
