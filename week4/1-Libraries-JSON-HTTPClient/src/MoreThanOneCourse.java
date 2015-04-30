import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import javax.xml.stream.XMLStreamException;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;



public class MoreThanOneCourse {

	public static String getJson(String stringUrl) throws IOException{
		URL url = new URL(stringUrl);
	    HttpURLConnection request = (HttpURLConnection) url.openConnection();
	    request.connect();
	    InputStream is = (InputStream) request.getContent();
	    Scanner scan = new Scanner(is);
	    String content = null;
	    if(scan.hasNextLine()){
	    	content=scan.nextLine();
	    }
	    while(scan.hasNextLine()){
	    	content+=scan.nextLine();
	    }
	    return content;
	}
	public static void printPeopleWithMoreThanOneCourses(String content) throws JSONException{
		JSONArray arr = new JSONArray(content);
	    for(int i=0;i<arr.length();i++){
	    	JSONObject obj = arr.getJSONObject(i);
	    	JSONArray objArr = obj.getJSONArray("courses");
	    	if(objArr.length()>1){
	    		System.out.println(obj.get("name"));
	    	}	
	    }
	}
	public static void printPeopleWithMostVisities(String content) throws JSONException{
		Map<String,Integer> peopleVisits = new HashMap<String, Integer>();
		JSONArray arr = new JSONArray(content);
		for(int i=0;i<arr.length();i++){
	    	JSONObject obj = arr.getJSONObject(i);
	    	String studentName = (String) obj.get("student_name");
	    	if(peopleVisits.containsKey(studentName)){
	    		peopleVisits.put(studentName, peopleVisits.get(studentName)+1);
	    	}else{
	    		peopleVisits.put(studentName, 1);
	    	}
	    }
		ValueComparator bvc =  new ValueComparator(peopleVisits);
        TreeMap<String,Integer> sorted_map = new TreeMap<String,Integer>(bvc);
        sorted_map.putAll(peopleVisits);
		System.out.println(sorted_map);
	}
	public static void main(String[] args) throws IOException, JSONException, XMLStreamException {
		// TODO Auto-generated method stub
		
		//String content =getJson("https://hackbulgaria.com/api/students/");
		String visitsContent = getJson("https://hackbulgaria.com/api/checkins/");
		printPeopleWithMostVisities(visitsContent);
		//printPeopleWithMoreThanOneCourses(content);
	}

}

class ValueComparator implements Comparator<String> {

    Map<String, Integer> base;
    public ValueComparator(Map<String, Integer> base) {
        this.base = base;
    }

    public int compare(String a, String b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        } 
    }
}