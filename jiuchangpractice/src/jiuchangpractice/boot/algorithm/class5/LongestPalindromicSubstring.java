package jiuchangpractice.boot.algorithm.class5;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        // write your code here
    	if(s == null || s.length() == 0) {
    		return s;
    	}
 
    	char[] chars = s.toCharArray();
    	int N = chars.length;
    	int max = 1;
    	int[] tem = {0,0};//new int[2];
    	for(int i = 1; i < N; i++) { //odd
    		int l = 1;
    		while(i-l >= 0 && i+l < N && chars[i-l] == chars[i+l]) {
    			l++;
    		}
    		int dif = 2 * (l-1) + 1;
    		if(dif > max) {
    			max = dif;
    			tem[0] = i-l+1;
    			tem[1] = i+l-1;
    		}
    	}
    	for(int i = 1; i< N; i++) {//even
    		if(chars[i - 1] == chars[i]) {
    			int l = 1;
        		while(i-1 - l >= 0 && i+l < N && chars[i- 1 - l] == chars[i+l]) {
        			l++;
        		}
        		int dif = 2 * (l-1) + 2;
        		if(dif > max) {
        			max = dif;
        			tem[0] = i- l;
        			tem[1] = i+l-1;
        		}
    			
    		}
    	}
    	
    	return s.substring(tem[0],tem[1]+1);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aa";
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		System.out.println(lps.longestPalindrome(s));
	}

}
