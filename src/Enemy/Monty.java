package Enemy;

import java.awt.Graphics;

import Input.Mouse;
import Main.Game;
import Main.Handler;
import Main.Id;
import gfx.Sprite;

public class Monty extends Enemy{
	
	private Sprite[] montysprite = new Sprite[4];
	
	public static int montylosschicken,montyfacing=1;
	public static boolean montywirdlosgeschickt,montywirdlosgeschicktluigi;

	public Monty(int x, int y, int breite, int höhe, Handler handler, Id id) {
		super(x, y, breite, höhe, handler, id);
	}
	
	public void render(Graphics g){
		for(int i=0;i<montysprite.length;i++){
			montysprite[i] = new Sprite(Game.sheet,i+20,1,1,1);
		}
			if(montyfacing==1){g.drawImage(montysprite[getFrame()].getBufferedImage(),x,y,breite,höhe,null);}
			else{g.drawImage(montysprite[getFrame()+2].getBufferedImage(),x,y,breite,höhe,null);}
		
	}
	
	public void tick(){
		x+=velX;
		y+=velY;
		if(x<1263&&x>-122){
			montylosschicken=0;
			if(montyfacing==1){
				setVelX(2);
			}else{
				setVelX(-2);
			}
		}else{
			Game.monty.setAsRemoved();
		}
		if(Mouse.map==2){
			montyfacing=2;
			if(x+breite<200){
				falling=true;
			}
		}
		if(falling){
			falling();
		}
		FrameDelay(9,2);
	}
	
	public static void Montysinit(){
		if(montywirdlosgeschickt){

			if(Mouse.map==1){
				if(montyfacing==1){
					Game.monty = new Monty(-121,590,121,121,Game.handler,Id.Monty);
				}
				if(montyfacing==2){
					Game.monty = new Monty(1262,590,121,121,Game.handler,Id.Monty);
				}
			}
			if(Mouse.map==2){
				Game.monty = new Monty(1262,590,121,121,Game.handler,Id.Monty);

			}
			Game.handler.addEnemy(Game.monty);
			montywirdlosgeschickt=false;
		}
				
	}
}