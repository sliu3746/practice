package jiuchangpractice.boot.algorithm.class4;

public class DivideTwoIntegers {
    /**
     * @param dividend: the dividend
     * @param divisor: the divisor
     * @return: the result
     */
    public int divide(int dividend, int divisor) {
        // write your code here
        if (divisor == 0) {
            return dividend >= 0? Integer.MAX_VALUE : Integer.MIN_VALUE;
       }
       
       if (dividend == 0) {
           return 0;
       }
       
       if (dividend == Integer.MIN_VALUE && divisor == -1) {
           return Integer.MAX_VALUE;
       }
    	
    	long r = Math.abs((long)dividend);
    	long l = Math.abs((long)divisor);

    	int result = 0;
    	while( r >= l) {
    		int shift = 0;
    		while(r>= (l << shift)) {
    			shift++;
    		}
    		System.out.println("r " + r + " l " + l  + " s  " +  shift);
            r -= l << (shift - 1);
            result += 1 << (shift - 1); 
    	}
    	if(dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
    		return -result;
    	}
    	
    	return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DivideTwoIntegers dti = new DivideTwoIntegers();
		System.out.println(dti.divide(-2147483648, 1));

	}

}
