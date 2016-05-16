package Tile;

import java.awt.Color;
import java.awt.Graphics;

import Main.Game;
import Main.Handler;
import Main.Id;
import gfx.Sprite;

public class Pipe3 extends Tile{

	public static Sprite pipe3 = new Sprite(Game.sheet,4,2,1,1);
	
	public Pipe3(int x, int y, int breite, int höhe, boolean solid, Handler handler, Id id) {
		super(x, y, breite, höhe, solid, handler, id);
	}
	
	public void render(Graphics g){
		g.drawImage(pipe3.getBufferedImage(),x,y,breite,höhe,null);
		g.setColor(Color.white);
		g.drawRect(x, y, breite, höhe);
	}

}
