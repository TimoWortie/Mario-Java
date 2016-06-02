package Enemy;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import Input.Mouse;
import Main.Game;
import Main.Handler;
import Main.Id;
import Tile.Tile;
import gfx.Sprite;

public class Goomba extends Enemy{
	
	public static Random r = new Random();
	public static int j,countergoomba;
	private Sprite[] goombasprite = new Sprite[4];
	public static Goomba[] goomba = new Goomba[100];
	
	
	public Goomba(int x, int y, int breite, int h�he, Handler handler, Id id) {
		super(x, y, breite, h�he, handler, id);
	}

	public void render(Graphics g){
		for(int i=0;i<goombasprite.length;i++){
			goombasprite[i] = new Sprite(Game.sheet,i+17,3,1,1);
		}
		if(getZufallszahl()==1){g.drawImage(goombasprite[getFrame()].getBufferedImage(),x,y,breite,h�he,null);}
		if(getZufallszahl()==0){g.drawImage(goombasprite[getFrame()+2].getBufferedImage(),x,y,breite,h�he,null);}
	}
	
	public void tick(){
		x+=velX;
		y+=velY;
		
		for(Tile t:handler.tile){
			if(t.getId()==Id.wall){
				if(getBottom().intersects(t.getBounds())){
					setVelY(0);
					y=t.getY()-50;
					if(!isSchonentschieden()){
						setZufallszahl(r.nextInt(2));
						setSchonentschieden(true);
						}
					if(getZufallszahl()==0){
						setVelX(1);
					}
					if(getZufallszahl()==1){
						setVelX(-1);
					}
					if(x+breite>=1263&&y<520){
						setZufallszahl(1);
					}
					if(x<=0&&y<520){
						setZufallszahl(0);
					}
					falling = false;
					}else if(isErscheinen()){
						falling=true;
					}
			}
			if(Mouse.map==2&&t.getId()==Id.pipe){
				if(getBounds().intersects(t.getBounds())){
					falling=false;
					if(x>=1155){
						setZufallszahl(1);
						setVelX(-1);
					}
					if(x<=16){
						setVelX(1);
					}
				}
			}
		}
		
		if(velY==1){
			setZufallszahl(r.nextInt(2));
			setSchonentschieden(true);
		}
		
		if(x+breite<0||x>1262){
			setAsRemoved();
			}
		
		FrameDelay2(10,10);
		FrameDelay(9,2);
		if(falling){
			falling();
		}
	}

	public static void Goombasinit(){
		countergoomba++;
		if(countergoomba==500){
			if(j<goomba.length){
				for(int i=0;i<goomba.length;i++){
					setSpawnpoint(r.nextInt(2));
					if(Mouse.map==1){
					if(getSpawnpoint()==0){goomba[i] = new Goomba(396,5,60,60,Game.handler,Id.enemy);}
					if(getSpawnpoint()==1){goomba[i] = new Goomba(851,5,60,60,Game.handler,Id.enemy);}
					}
					if(Mouse.map==2){
						if(getSpawnpoint()==0){goomba[i] = new Goomba(16,155,60,60,Game.handler,Id.enemy);}
						if(getSpawnpoint()==1){goomba[i] = new Goomba(1155,535,60,60,Game.handler,Id.enemy);}
						}
				}
			Game.handler.addEnemy(goomba[j]);
			j++;
			}
			countergoomba=0;
		}
	}
}
