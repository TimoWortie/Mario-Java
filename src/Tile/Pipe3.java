package Tile;

import java.awt.Color;
import java.awt.Graphics;

import Main.Game;
import Main.Handler;
import Main.Id;
import gfx.Sprite;

public class Pipe3 extends Tile{

	public static Sprite pipe3 = new Sprite(Game.sheet,4,2,1,1);
	
	public Pipe3(int x, int y, int breite, int h�he, boolean solid, Handler handler, Id id) {
		super(x, y, breite, h�he, solid, handler, id);
	}
	
	public void render(Graphics g){
		g.drawImage(pipe3.getBufferedImage(),x,y-10,breite,h�he,null);
		g.setColor(Color.red);
		g.drawRect(x,y,breite,h�he);
		g.setColor(Color.green);
		g.drawRect(x,y+h�he-15,breite,15);
	}

}
