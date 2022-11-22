package demo;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.management.loading.PrivateClassLoader;

public class LocationQueue {
	
	private volatile static LocationQueue instance;
	 private List<Integer> values;
	
	 private LocationQueue() {
	        values = new CopyOnWriteArrayList<Integer>();
	    };
	    
	    public static LocationQueue getInstance() {
	        if (instance == null) {
	            synchronized (LocationQueue.class) {
	                if (instance == null) {
	                    instance = new LocationQueue();
	                }
	            }
	        }
	        return instance;
	    }
	    
	    public void push(int ps) {
	        values.add(ps);
	        System.out.println(values);
//	        if (values.size() > 2000) {
//	            values = new CopyOnWriteArrayList<>(values.subList(values.size() - 2000, values.size()));
//	        }
	    }
	    
	    // 这句被执行的频率极高，随着传感器的触发而触发
	    public boolean hasNeighbor(Integer position) {
//	        ArrayList<Integer> copy = new ArrayList<>(values);
	        for (Integer p : values) {
	            if (p <= 90) {
	                return true;
	            }
	        }
	        return false;
	    }

		
	    
	    
	

}
