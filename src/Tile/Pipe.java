package Tile;

import java.awt.Color;
import java.awt.Graphics;

import Main.Game;
import Main.Handler;
import Main.Id;
import gfx.Sprite;

public class Pipe extends Tile{

	public static Sprite pipe = new Sprite(Game.sheet,1,2,1,1);
	
	public Pipe(int x, int y, int breite, int höhe, boolean solid, Handler handler, Id id) {
		super(x, y, breite, höhe, solid, handler, id);
	}

	public void render(Graphics g){
		g.drawImage(pipe.getBufferedImage(), x, y,breite,höhe, null);
//		g.setColor(Color.red);
//		g.drawRect(x,y,breite,höhe);
//		g.setColor(Color.green);
//		g.drawRect(x,y+höhe-15,breite,15);
	}
}
