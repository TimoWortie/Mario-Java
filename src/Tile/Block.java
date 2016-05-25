package Tile;

import java.awt.Color;
import java.awt.Graphics;

import Main.Game;
import Main.Handler;
import Main.Id;
import gfx.Sprite;

public class Block extends Tile{

	public static Sprite block = new Sprite(Game.sheet,3,2,1,1);
	
	public Block(int x, int y, int breite, int höhe, boolean solid,Handler handler, Id id) {
		super(x, y, breite, höhe, solid,handler, id);
	}
	
	public void render(Graphics g){
		g.drawImage(block.getBufferedImage(),x,y,breite,höhe,null);
		g.setColor(Color.white);
		g.drawRect(x,y,breite,höhe);
		g.setColor(Color.red);
		g.drawRect(x+breite-15,y+5,15,höhe-10);
		g.setColor(Color.green);
		g.drawRect(x,y+5,15,höhe-10);
		g.setColor(Color.CYAN);
		g.drawRect(x,y+höhe-15,breite,15);
	}
	
	
	
}
