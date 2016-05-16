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

	public Monty(int x, int y, int breite, int höhe, boolean solid, Handler handler, Id id) {
		super(x, y, breite, höhe, solid, handler, id);
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
		setFramedelay(getFramedelay() + 1);
		if(getFramedelay()>=9){
			setFrame(getFrame() + 1);
			setFramedelay(0);
			if(getFrame()==2){
				setFrame(0);
			}
		}
	}
	
	public static void Montysinit(){
				if(montywirdlosgeschickt){
					if(montyfacing==1){
					monty = new Monty(-121,590,121,121,true,Game.handler,Id.enemy);
					}else{
					monty = new Monty(1262,590,121,121,true,Game.handler,Id.enemy);
					}
					Game.handler.addEnemy(monty);
					montywirdlosgeschickt=false;
				}
				
	}

}
