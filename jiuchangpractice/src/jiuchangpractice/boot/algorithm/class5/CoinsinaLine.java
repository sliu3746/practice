package jiuchangpractice.boot.algorithm.class5;

public class CoinsinaLine {
    /**
     * @param n: An integer
     * @return: A boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        // write your code here    	
    	boolean f0 = false;
    	if( n == 0) {
    		return f0;
    	}
    	if( n == 1 || n == 2) {
    		return true;
    	}
    	boolean f1 = true;
    	boolean f2 = true;
    	for(int i = 3; i <= n; i++) {
    		f0 = f1;
    		f1 = f2;    		
    		f2 = f1 == false || f0 == false;
    		//System.out.println(" n " + i + " " + f2);
    	}
    	return f2;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoinsinaLine test = new CoinsinaLine();
		test.firstWillWin(9);

	}

}
