package jiuchangpractice.boot.algorithm.class6;

public class CoinsinaLineIII {

    /**
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
    	if(values == null || values.length == 0) {
    		return true;
    	}
    	int N = values.length;
    	int[][] f = new int[N][N];
    	// f[i][j] = max(values[i]-f[i+1][j],values[j]-f[i][j-1]
    	for(int i = 0; i< N; i++) {
    		f[i][i] = values[i];
    	}
    	int length = 1; 
    	while(length < N) {
			for (int i = 0; i < N - length; i++) {
				int j = i + length;
				f[i][j] = Math.max(values[i] - f[i + 1][j], values[j] - f[i][j - 1]);
			}
			length++;
    	}
    	return f[0][N-1] >= 0;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] values = {3,2,2};
		CoinsinaLineIII test = new CoinsinaLineIII();
		test.firstWillWin(values);
	}

}
