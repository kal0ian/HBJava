import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WebCrawler {
	
	private static List<String> getAllLinks(String content) {
        ArrayList<String> resultList = new ArrayList<>();
        String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            resultList.add(matcher.group(1));
        }
        return resultList;
    }
	public static String getSourceCode(String url) throws IOException{
		URL oracle = new URL(url);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine,content="";
        while ((inputLine = in.readLine()) != null)
            content+=inputLine;
        in.close();
        return content;
	}
	public static List<String> uniqueLinks(List<String> links){
		Set<String> set = new HashSet<String>();
		for(String i:links){
			if(!i.contains("..") && !i.contains("http")){
				set.add(i);
			}
		}
		List<String> newLinks = new ArrayList<String>();
		newLinks.addAll(set);
		
		return newLinks;
	}
	public static void craw(String url,String needle) throws IOException{
		Queue<String> urlToVisit = new LinkedList<String>();
		List<String> visited = new ArrayList<String>();
		String bufUrl = null;
		
		urlToVisit.add("");
		while(!urlToVisit.isEmpty()){
			 bufUrl = url + urlToVisit.poll();
			 if(visited.contains(bufUrl)){
				 continue;
			 }
			if(getSourceCode(bufUrl).contains(needle)){
				System.out.println(bufUrl);
				break;
			}
			List<String> links = getAllLinks(getSourceCode(bufUrl));
			links=uniqueLinks(links);
			urlToVisit.addAll(links);
			visited.add(bufUrl);	
	
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String url = "http://ebusiness.free.bg/";
		String needle = "Револвиращ";
		craw(url,needle);
	
	}
}
