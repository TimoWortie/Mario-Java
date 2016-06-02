package Enemy;

import java.awt.Graphics;
import Main.Game;
import Main.Handler;
import Main.Id;
import gfx.Sprite;

public class Monty extends Enemy{
	
	private Sprite[] montysprite = new Sprite[4];
	public static Monty monty;
	public static int montylosschicken,montyfacing=1;
	public static boolean montywirdlosgeschickt,montywirdlosgeschicktluigi;

	public Monty(int x, int y, int breite, int h�he, Handler handler, Id id) {
		super(x, y, breite, h�he, handler, id);
	}
	
	public void render(Graphics g){
		for(int i=0;i<montysprite.length;i++){
			montysprite[i] = new Sprite(Game.sheet,i+20,1,1,1);
		}
			if(montyfacing==1){g.drawImage(montysprite[getFrame()].getBufferedImage(),x,y,breite,h�he,null);}
			else{g.drawImage(montysprite[getFrame()+2].getBufferedImage(),x,y,breite,h�he,null);}
		
	}
	
	public void tick(){
		x+=velX;
		if(x<1263&&x>-122){
			montylosschicken=0;
			if(montyfacing==1){
				setVelX(2);
			}else{
				setVelX(-2);
			}
		}else{
			monty.setAsRemoved();
		}
		FrameDelay(9,2);
	}
	
	public static void Montysinit(){
				if(montywirdlosgeschickt){
					if(montyfacing==1){
					monty = new Monty(-121,590,121,121,Game.handler,Id.Monty);
					}else{
					monty = new Monty(1262,590,121,121,Game.handler,Id.Monty);
					}
					Game.handler.addEnemy(monty);
					montywirdlosgeschickt=false;
				}
				
	}
}
