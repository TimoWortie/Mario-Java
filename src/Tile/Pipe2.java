package Tile;

import java.awt.Graphics;

import Main.Game;
import Main.Handler;
import Main.Id;

public class Pipe2 extends Tile{

	public Pipe2(int x, int y, int breite, int h�he, boolean solid, Handler handler, Id id) {
		super(x, y, breite, h�he, solid, handler, id);
	}

	public void render(Graphics g){
		g.drawImage(Game.pipe2.getBufferedImage(), x, y,breite,h�he, null);
	}
}
