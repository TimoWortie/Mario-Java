package Tile;

import java.awt.Color;
import java.awt.Graphics;

import Main.Game;
import Main.Handler;
import Main.Id;
import gfx.Sprite;

public class Pipe2 extends Tile{

	public static Sprite pipe2 = new Sprite(Game.sheet,2,2,1,1);
	
	public Pipe2(int x, int y, int breite, int höhe, boolean solid, Handler handler, Id id) {
		super(x, y, breite, höhe, solid, handler, id);
	}

	public void render(Graphics g){
		g.drawImage(pipe2.getBufferedImage(), x, y,breite,höhe, null);
	}
}
