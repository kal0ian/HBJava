import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;


public class DownloadFile {
	public static void saveImage(String imageUrl, String destinationFile) throws IOException {
		URL url = new URL(imageUrl);
		InputStream is = url.openStream();
		OutputStream os = new FileOutputStream(destinationFile);

		byte[] b = new byte[1024];
		int length;

		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}

		is.close();
		os.close();
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String url = "http://d3dsacqprgcsqh.cloudfront.net/photo/aozrdx0_700b.jpg";
		String dest = "/home/kal0ian/Downloads/pesho.jpg";
		DownloadFile.saveImage(url,dest);
	}

}
