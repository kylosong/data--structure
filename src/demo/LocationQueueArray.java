package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class LocationQueueArray {
	private volatile static LocationQueueArray instance;
	 private List<Integer> values;
	
	 private LocationQueueArray() {
	        values = new ArrayList<Integer>();
	    };
	    
	    public static LocationQueueArray getInstance() {
	        if (instance == null) {
	            synchronized (LocationQueueArray.class) {
	                if (instance == null) {
	                    instance = new LocationQueueArray();
	                }
	            }
	        }
	        return instance;
	    }
	    
	    public void push(int ps) {
	        values.add(ps);
	        System.out.println(values);
	        if (values.size() > 2000) {
	            values = new ArrayList<>(values.subList(values.size() - 2000, values.size()));
	        }
	    }
	    
	    // 这句被执行的频率极高，随着传感器的触发而触发
	    public boolean hasNeighbor(Integer position) {
//	        ArrayList<Integer> copy = new ArrayList<>(values);
	        for (Integer p : values) {
	            if (p <= 100) {
	                return true;
	            }
	        }
	        return false;
	    }

}
