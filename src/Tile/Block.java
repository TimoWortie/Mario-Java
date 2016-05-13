package Tile;

import java.awt.Graphics;

import Main.Game;
import Main.Handler;
import Main.Id;

public class Block extends Tile{

	public Block(int x, int y, int breite, int h�he, boolean solid,Handler handler, Id id) {
		super(x, y, breite, h�he, solid,handler, id);
	}
	
	public void render(Graphics g){
		g.drawImage(Game.block.getBufferedImage(),x,y,breite,h�he,null);
	}
}
