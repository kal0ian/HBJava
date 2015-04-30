import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import com.nitido.utils.toaster.Toaster;


public class JToaster {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		Toaster toasterManager = new Toaster();
		toasterManager.setToasterHeight(150);
		toasterManager.setToasterWidth(300);
		BufferedImage img = ImageIO.read(new File("/home/kal0ian/Downloads/rsz_backg.jpg"));
		toasterManager.setMessageColor(new Color(250250250));
		toasterManager.setToasterColor(new Color(000)); 
		Thread.sleep(5000);
		toasterManager.showToaster(new ImageIcon(img), "Get a little rest, will you?");
	}

}
