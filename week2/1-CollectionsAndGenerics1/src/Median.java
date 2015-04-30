import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import sun.org.mozilla.javascript.tools.debugger.downloaded.JTreeTable.ListToTreeSelectionModelWrapper;


public class Median implements Statistics{
	public List<Integer> list = new ArrayList<Integer>();
	public Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	public double sum=0;

	@Override
	public double getMean() {
		// TODO Auto-generated method stub
		double result =sum/list.size();
		return result;
	}
	public void add(int number){
		sum+=number;
		list.add(number);
		if(map.containsKey(number)){
			map.put(number, map.get(number) + 1);
		}else{
			map.put(number,1);
		}
	}
	@Override
	public double getMedian() {
		// TODO Auto-generated method stub
		List<Integer> list2= new ArrayList(list);
		Collections.sort(list2);
		if(list.size()%2==1){
			return list2.get(list2.size()/2);
		}
		return (double)(list2.get(list2.size()/2-1)+ list2.get(list2.size()/2)) / 2;
	}
	@Override
	public List<Integer> getMode() {
		// TODO Auto-generated method stub
		int maxValue =Collections.max(map.values()),i=0;
		List<Integer> mode=new ArrayList<Integer>() ;
		for (Entry<Integer, Integer> entry : map.entrySet()) {  
	           if (entry.getValue()==maxValue) {
	               mode.add(entry.getKey());
	               i++;
	           }       
	    }
		 return mode;
	}
	@Override
	public int getRange() {
		// TODO Auto-generated method stub
		List<Integer> list2= new ArrayList(list);
		Collections.sort(list2);
		return list2.get(list2.size()-1)-list2.get(0);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Median obj = new Median();
		obj.add(1);
		obj.add(2);
		obj.add(7);
		obj.add(4);
	
		System.out.println("Median: "+obj.getMedian());
		System.out.println("Mean: "+obj.getMean());
		System.out.println("Range: "+obj.getRange());
		System.out.println("Mode: "+obj.getMode());
	}
}
