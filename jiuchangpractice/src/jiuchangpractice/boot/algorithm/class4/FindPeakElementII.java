package jiuchangpractice.boot.algorithm.class4;

import java.util.ArrayList;
import java.util.List;

public class FindPeakElementII {

	/*
     * @param A: An integer matrix
     * @return: The index of the peak
     */
    public List<Integer> findPeakII(int[][] A) {
        // write your code here
    	List<Integer> retList = new ArrayList<>();
    	if(A == null || A.length == 0 || A[0].length ==0) {
    		return retList;
    	}
    	
    	int[] dx = {1, 0};
    	int[] dy = {0,1};
    	int n = A.length;
    	int m = A[0].length;
    	int left = 0;
    	int right = (n-1) * n + m - 1;
    	int mid = left + (right - left)/2;
 
    	while(left <= right) {
    		
    		int x = mid/n;
    		int y = mid%n;
    		int x1 = x + dx[0];
    		int y1 = y + dx[1];
    		int x2 = x + dy[0];
    		int y2 = y + dy[1];
    		if(isValid(n, m, x1, y1) && A[x][y] > A[x1][y1] && isValid(n, m, x2, y2) && A[x][y] > A[x2][y2]){
    			retList.add(x);
    			retList.add(y);
    			return retList;
    		}else if(isValid(n, m, x1, y1) && A[x][y] > A[x1][y1]) {
    			mid += n;
    			continue;
    		}else if(isValid(n, m, x2, y2) && A[x][y] > A[x2][y2]) {
    			mid += 1;
    			continue;
    		}else {
    			left = mid;
    		}
    		mid = left + (right - left)/2;
    	}
    	
    	return retList;
    }
    
    private boolean isValid(int n, int m, int x, int y) {
    	return x >=0 && y >= 0 && x < n && y < m;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = { { 1, 2, 3, 4, 5 }, { 16, 41, 23, 22, 6 }, { 15, 17, 24, 21, 7 }, { 14, 18, 19, 20, 8 },
				{ 13, 12, 11, 10, 9 } };
		FindPeakElementII fpe2 = new FindPeakElementII();
		fpe2.findPeakII(A);
	}

}
