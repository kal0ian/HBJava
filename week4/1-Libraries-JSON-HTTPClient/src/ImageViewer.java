import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;

import javax.imageio.ImageIO;


public class ImageViewer {
	
	public static void readImage(File file) throws FileNotFoundException{
		BufferedImage image = null;	
	    try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    int height = image.getHeight();
	    int width  = image.getWidth();
	    
	    char[][] asciiImage= new char[height+1][width+1];
	    int rgb=0;
	    for(int x=0;x<height;x++){
	    	for(int y=0;y<width;y++){
	    		rgb = image.getRGB(y,x);
	    		int intensity = getIntensityOfPixel(rgb);
	    		asciiImage[x][y]=getSymbol(intensity);
	    	}
	    }
	    
	    File outputFile=new File("/home/kal0ian/Downloads/car.txt");
	    saveImageToTxtFile(outputFile, asciiImage,height,width);
	}
	public static int getIntensityOfPixel(int rgb){
		Color colour = new Color(rgb);
		int intensity= (colour.getRed() +colour.getGreen()+colour.getBlue())/3;
		return intensity;
	}
	public static void saveImageToTxtFile(File file,char[][] asciiImage,int height,int width) throws FileNotFoundException{
		PrintStream write = new PrintStream(file);
	    for(int x=0;x<height;x++){
	    	for(int y=0;y<width;y++){
	    		write.append(asciiImage[x][y]);
	    	}
	    	write.append('\n');
	    }
	    write.close();
	}
	private static  char getSymbol(int intensity) {
		// TODO Auto-generated method stub
		char result = ' ';
		if (intensity > 240) {
            result = ' ';
        } else if (intensity > 200) {
            result = '.';
        } else if (intensity > 160) {
            result = '*';
        } else if (intensity > 120) {
            result = '+';
        } else if (intensity > 80) {
            result = '=';
        } else if (intensity > 40) {
            result = 'x';
        } else if (intensity > 0) {
            result = '#';
        }
        return result;
		
	}
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File img = new File("/home/kal0ian/Downloads/car.png");
		readImage(img);
	}

}
