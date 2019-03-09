package jiuchangpractice.boot.algorithm.class5;

public class CoinsII {

    /**
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
    	if(values == null || values.length ==0) {
    		return true;
    	}
    	int N = values.length;
    	int[] f = new int[N+1];
    	f[N] = 0;
    	f[N-1] = values[N-1];
    	for(int i = N - 2; i>= 0; i--) {
    		f[i] = Math.max(values[i] - f[i+1], values[i] + values[i+1] - f[i+2]);
    	}
    	
    	return f[0] >= 0;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
