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

class LinkThread extends Thread {
    String currUrl;
    String needle;

    LinkThread(String otherUrl, String otherNeedle) {
        currUrl = otherUrl;
        needle = otherNeedle;

    }

    @Override
    public void run() {

        try {
            while (!WebCrawler.urlToVisit.isEmpty()) {
                currUrl = "http://sportal.bg/" + WebCrawler.urlToVisit.poll();

                
                if (WebCrawler.getSourceCode(currUrl).contains(needle)) {
                    System.out.println(currUrl);
                    System.exit(1);
                }
                List<String> links = WebCrawler.getAllLinks(WebCrawler.getSourceCode(currUrl));
                links = WebCrawler.uniqueLinks(links);
                WebCrawler.urlToVisit.addAll(links);
                LinkThread currLink = new LinkThread("http://sportal.bg/" + WebCrawler.urlToVisit.poll(), needle);
                currLink.start();
            }
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

public class WebCrawler {
    static Queue<String> urlToVisit = new LinkedList<String>();
    static List<String> visited = new ArrayList<String>();

    static List<String> getAllLinks(String content) {
        ArrayList<String> resultList = new ArrayList<String>();
        String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            resultList.add(matcher.group(1));
        }
        return resultList;
    }

    public static String getSourceCode(String url) throws IOException {
        URL oracle = new URL(url);
        BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));

        String inputLine, content = "";
        while ((inputLine = in.readLine()) != null)
            content += inputLine;
        in.close();
        return content;
    }

    public static List<String> uniqueLinks(List<String> links) {
        Set<String> set = new HashSet<String>();
        for (String i : links) {
            if (!i.contains("..") && !i.contains("http")) {
                set.add(i);
            }
        }
        List<String> newLinks = new ArrayList<String>();
        newLinks.addAll(set);

        return newLinks;
    }

    public static void craw(String url, String needle) throws IOException {

        String bufUrl = null;

        urlToVisit.add("");
        LinkThread currLink = new LinkThread(bufUrl, needle);
        currLink.start();

    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        String url = "http://sportal.bg/";
        String needle = "Боб Хюит";
        craw(url, needle);

    }
}