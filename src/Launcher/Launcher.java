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
	
	public Launcher(){
		
	}
	
	public void render(Graphics g){
		try {
			hintergrund = ImageIO.read(getClass().getResource("/startscreen.png"));
		} catch (IOException e) {}
		g.drawImage(hintergrund, 0, 0, 1280,760,null);
	}

}
