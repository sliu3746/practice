package jiuchangpractice.boot.algorithm.class4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NumberofAirplanesintheSky {
    /**
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
    	int ans = 0;
    	List<Event> list = new ArrayList<>();
    	for(int i = 0; i < airplanes.size(); i++) {
    		Interval inteval = airplanes.get(i);    		
    		list.add(new Event(inteval.start, 1));
    		list.add(new Event(inteval.end, 0));
    	}
    	Collections.sort(list,
    			new Comparator<Event>() {
    	    @Override
    	    public int compare(Event s1, Event s2) {
    	    	if(s1.time == s2.time) {
    	    		return s1.state - s2.state;
    	    	}
    	        return s1.time - s2.time;
    	    }
    	});
    	int count = 0;
    	for(Event e: list) {
    		if(e.state == 1) {
    			count++;
    			if(count > ans) {
    				ans = count;
    			}
    		}else {
    			count--;
    		}
    	}
    			
    	return ans;
    }
    
    class Event{
    	int time;
    	int state; // start true, end false;
    	Event(int time, int state){
    		this.time = time;
    		this.state = state;
    	}
    }
    
	class Interval
	{
    	      int start; int end;

    	      Interval(int start, int end) {
    	          this.start = start;
    	          this.end = end;
    	      }

	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
