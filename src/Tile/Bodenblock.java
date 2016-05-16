package Tile;

import java.awt.Graphics;

import Main.Game;
import Main.Handler;
import Main.Id;
import gfx.Sprite;

public class Bodenblock extends Tile{

	private Sprite bodenblock = new Sprite(Game.sheet,25,3,1,1);
	
	public Bodenblock(int x, int y, int breite, int höhe, boolean solid, Handler handler, Id id) {
		super(x, y, breite, höhe, solid, handler, id);
	}
	
	public void render(Graphics g){
		g.drawImage(bodenblock.getBufferedImage(),x,y,breite,höhe,null);
	}

}
