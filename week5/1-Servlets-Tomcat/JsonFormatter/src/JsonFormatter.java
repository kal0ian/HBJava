

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * Servlet implementation class JsonFormatter
 */
@WebServlet("/JsonFormatter")
public class JsonFormatter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonFormatter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String stringUrl=request.getParameter("json");
		String jsonContent = getJson(stringUrl);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(jsonContent);
		String prettyJson = gson.toJson(je);

		response.getWriter().print(prettyJson);
		
	}
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
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
