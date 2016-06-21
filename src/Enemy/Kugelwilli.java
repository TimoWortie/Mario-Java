package Enemy;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import Input.Mouse;
import Main.Game;
import Main.Handler;
import Main.Id;
import gfx.Sprite;

public class Kugelwilli extends Enemy{
	public static Random r = new Random();
	public static int j,counterkugelwilli;
	private static boolean losgeschickt;
	private Sprite kugel;
	
	

	public Kugelwilli(int x, int y, int breite, int höhe, Handler handler, Id id) {
		super(x, y, breite, höhe, handler, id);
	}
	public void render(Graphics g){
		if(Mouse.map==2){
		kugel =new Sprite(Game.sheet,1,1,1,1);
		g.drawImage(kugel.getBufferedImage(), x, y, höhe, breite, null);
		g.setColor(Color.red);
		g.drawRect(getX(),getY(),breite,höhe);
		g.setColor(Color.green);
		g.drawRect(x,y+höhe-6,breite,5);
		g.setColor(Color.magenta);
		g.drawRect(x+10,y,breite-20,20);
		g.setColor(Color.white);
		g.drawRect(x+breite-30,y+10,30,höhe-20);
		g.setColor(Color.CYAN);
		g.drawRect(x,y+10,30,höhe-20);
		}}
	
	
	public void tick(){
		if(losgeschickt==true){
			velX=-3;
		}
		x+=velX;
		
	}
	public static void kugelwillisinit(){
		counterkugelwilli++;
		if(counterkugelwilli==800){
			if(j<Game.kugelwilli.length){
				for(int i=0;i<Game.kugelwilli.length;i++){
					losgeschickt=true;
	
					if(Mouse.map==2){
						
						Game.kugelwilli[i] = new Kugelwilli(1155,360,60,60,Game.handler,Id.enemy);
						}
					
						if(Mouse.map==1){
						
							Game.kugelwilli[i] = new Kugelwilli(1155,1360,60,60,Game.handler,Id.enemy);
						}
				}
			Game.handler.addEnemy(Game.kugelwilli[j]);
			j++;
			}
			counterkugelwilli=0;
		}
	}
	
	
	

}
