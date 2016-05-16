package Launcher;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Launcher extends Canvas{
	
	public static boolean launching = true;
	private BufferedImage hintergrund;
	public static int seite=1;
	
	public Launcher(){
		
	}
	
	public void render(Graphics g){
		try {
			if(seite==1){hintergrund = ImageIO.read(getClass().getResource("/startscreen.png"));
			g.drawImage(hintergrund, 0, 0, 1280,760,null);
			}
			if(seite==2){hintergrund = ImageIO.read(getClass().getResource("/startscreen2.png"));
			g.drawImage(hintergrund, 0, 0, 1280,760,null);
			}
		} catch (IOException e) {}
	}
}
