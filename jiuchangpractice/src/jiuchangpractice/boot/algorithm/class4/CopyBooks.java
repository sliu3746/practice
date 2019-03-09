package jiuchangpractice.boot.algorithm.class4;

import java.util.Arrays;

public class CopyBooks {
    /**
     * @param pages: an array of integers
     * @param k: An integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
    	if(pages == null || pages.length == 0) {
    		return 0;
    	}
    	int right = Integer.MAX_VALUE;//Arrays.stream(pages).max().getAsInt();
    	int left = 0;//Arrays.stream(pages).min().getAsInt();
    	int tGuess = left + (right-left)/2;
    	while(left + 1 < right) {
    		if(getNeeded(pages, tGuess, k)) {
    			right = tGuess;
    		}else {
    			left = tGuess;
    		}
    		tGuess = left + (right-left)/2;
    	}
    	if(getNeeded(pages, left, k)) {
    		//System.out.println("left " + left);
    		return left;
    	}
    	//System.out.println(right);
    	return right;
    }
    
	private boolean getNeeded(int[] pages, int tGuess, int k) {
		// TODO Auto-generated method stub
		int kGuess = 0;
		int tem = 0;
		for(int item : pages) {
			if(item > tGuess) {
				return false;
			}
	        if(item > tem) {
	        	kGuess++;
	            tem = tGuess;
	        }
	        tem -= item;
	    }		

		return kGuess <= k;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CopyBooks cb = new CopyBooks();
		int[] pages = {1,2};//{3,2,4};
		cb.copyBooks(pages, 5);
		

	}

}
