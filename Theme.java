

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Theme {
	static String jungelFileName = "/Users/Rama/Documents/workspace/ZahpGame/TextFile : Pics/jungel.jpg";
	static String fireFileName = "/Users/Rama/Documents/workspace/ZahpGame/TextFile : Pics/fire.jpg";
	static String waterFileName = "/Users/Rama/Documents/workspace/ZahpGame/TextFile : Pics/water.jpg";
	static String airFileName = "/Users/Rama/Documents/workspace/ZahpGame/TextFile : Pics/air.jpg";
	
	BufferedImage jungelImg;
	BufferedImage fireImg;
	BufferedImage waterImg;
	BufferedImage airImg;
	
	static BufferedImage image;
	
	int width = 900;
	int height = 1400;
	
	Theme(){ // set basic theme 
		image = new BufferedImage(900, 1440, BufferedImage.TYPE_INT_ARGB);
		try {
			image=ImageIO.read(new File(jungelFileName));
		} catch (IOException e) {
			
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}
	
	public static void setTheme(String choice) throws IOException{
		image = new BufferedImage(900, 1440, BufferedImage.TYPE_INT_ARGB);
		
		if(choice.equals("Earth")){
			image=ImageIO.read(new File(jungelFileName));
		}
		if(choice.equals("Fire")){
			image=ImageIO.read(new File(fireFileName));
		}
		if(choice.equals("Water")){
			image=ImageIO.read(new File(waterFileName));
		}
		if(choice.equals("Air")){
			image=ImageIO.read(new File(airFileName));
		}
	}
	
	public static BufferedImage getTheme(){
		return image;
	}

}
