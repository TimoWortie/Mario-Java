package Enemy;

import java.awt.Graphics;

import Main.Game;
import Main.Handler;
import Main.Id;
import gfx.Sprite;

public class Williblaster extends Enemy{

	private Sprite williblastersprite = new Sprite(Game.sheet,31,3,1,1);
	
	public Williblaster(int x, int y, int breite, int h�he, boolean solid, Handler handler, Id id) {
		super(x, y, breite, h�he, solid, handler, id);
	}
	
	public void render(Graphics g){
		g.drawImage(williblastersprite.getBufferedImage(),x,y,breite,h�he,null);
	}
	
	public void tick(){
		
	}

}
