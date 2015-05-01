import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

import javax.imageio.ImageIO;


public class ASCIIArtImageViewer {
	static int width;
	static int height;
	public static void convertToAscii(BufferedImage image) throws FileNotFoundException{
		char[][] asciiImage = new char[width+1][height+1];
		for(int x=0;x<height;x++){
			for(int y=0;y<width;y++){
				int rgb = image.getRGB(y, x);
				int intensity = getIntensity(rgb);
				char symbol = getChar(intensity);
				asciiImage[y][x]=symbol;
				System.out.print(symbol);
			}
			System.out.println();
		}
		//saveToTxtFile(asciiImage,new File("/home/kal0ian/Downloads/car.txt"));
	}
	public static void saveToTxtFile(char[][] asciiImage,File outputFile) throws FileNotFoundException{
		PrintStream write = new PrintStream(outputFile);
		for(int x=0;x<height;x++){
			for(int y=0;y<width;y++){
				write.append(asciiImage[y][x]);
			}
			write.append('\n');
		}
		write.close();
	}
	public static char getChar(int intensity) {
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
	public static int getIntensity(int rgb){
		Color color = new Color(rgb);
		int intensity = (color.getRed()+color.getBlue()+color.getGreen())/3;
		return intensity;
	}
	public static BufferedImage loadImage(File file) throws IOException{
		BufferedImage image = null;
		image = ImageIO.read(file);
		width = image.getWidth()-1;
		height = image.getHeight()-1;
		System.out.print(width+" "+height);
		return image;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String imageUrl= "/home/kal0ian/Downloads/car.png";
		File image = new File(imageUrl);
		convertToAscii(loadImage(image));
		
	}

}
