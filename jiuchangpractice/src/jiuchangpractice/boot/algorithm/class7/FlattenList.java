package jiuchangpractice.boot.algorithm.class7;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FlattenList {

	// @param nestedList a list of NestedInteger
    // @return a list of integer
	public List<Integer> flatten(List<NestedInteger> nestedList) {
		// Write your code here
		List<Integer> retList = new ArrayList<>();
		if (nestedList == null || nestedList.size() == 0) {
			return retList;
		}
		Stack<NestedInteger> s = new Stack<>();
		for (int i = nestedList.size() - 1; i >= 0; i--) {
			s.push(nestedList.get(i));
		}
		NestedInteger nest = null;
		while (!s.isEmpty()) {
			nest = s.pop();
			if (nest.isInteger()) {
				retList.add(nest.getInteger());
			} else {
				List<NestedInteger> temList = nest.getList();
				for (int i = temList.size() - 1; i >= 0; i--) {
					s.push(temList.get(i));
				}
			}
		}

		return retList;
	}

	public interface NestedInteger {

		// @return true if this NestedInteger holds a single integer,
		// rather than a nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds,
		// if it holds a single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// @return the nested list that this NestedInteger holds,
		// if it holds a nested list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}   
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
