package jiuchangpractice.boot.algorithm.class5;

import java.util.HashMap;

public class ScrambleString {
    /**
     * @param s1: A string
     * @param s2: Another string
     * @return: whether s2 is a scrambled string of s1
     */
	HashMap<String, Boolean> map = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        // write your code here
    	if(s1.length() != s2.length()) {
    		return false;
    	}
    	int N = s1.length();
    	if(map.containsKey(s1+"#"+s2)) {
    		return map.get(s1+"#"+s2);
    	}
    	if(N == 1) {
    		return s1.charAt(0) == s2.charAt(0);
    	}
    	
    	for(int k = 1; k < N; k++) {
    		if(isScramble(s1.substring(0,k), s2.substring(0,k)) && isScramble(s1.substring(k,N), s2.substring(k,N)) 
    				|| isScramble(s1.substring(0,k), s2.substring(N-k,N)) && isScramble(s1.substring(k,N), s2.substring(0,N-k)) ) {
    			map.put(s1+"#"+s2, true);
    			return true;
    		}
    	}
    	map.put(s1+"#"+s2, false);
    	return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "great";
		String s2 = "rgtae";
		ScrambleString ss = new ScrambleString();
		ss.isScramble(s1, s2);
	}

}
