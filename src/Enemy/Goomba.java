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
	public static int j;
	private Sprite[] goombasprite = new Sprite[4];
	public static Goomba[] goomba = new Goomba[10];
	
	
	public Goomba(int x, int y, int breite, int h�he, boolean solid, Handler handler, Id id) {
		super(x, y, breite, h�he, solid, handler, id);
	}

	public void render(Graphics g){
		for(int i=0;i<goombasprite.length;i++){
			goombasprite[i] = new Sprite(Game.sheet,i+17,3,1,1);
		}
		if(getZufallszahl()==1){g.drawImage(goombasprite[getFrame()].getBufferedImage(),x,y,breite,h�he,null);}
		if(getZufallszahl()==0){g.drawImage(goombasprite[getFrame()+2].getBufferedImage(),x,y,breite,h�he,null);}
		g.setColor(Color.red);
		g.drawRect(getX(),getY(),breite,h�he);
		g.setColor(Color.green);
		g.drawRect(x,y+h�he-6,breite,5);
		g.setColor(Color.magenta);
		g.drawRect(x+10,y,breite-20,20);
		g.setColor(Color.white);
		g.drawRect(x+breite-30,y+10,30,h�he-20);
		g.setColor(Color.CYAN);
		g.drawRect(x,y+10,30,h�he-20);
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
					if(x+breite>=Game.getFrameBreite()&&y<520){
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
			if(Mouse.map==1&&t.getId()==Id.pipe){
				if(getBounds().intersects(t.getBounds())){
					falling=false;
					if(x<=1155){
						setVelX(-1);
					}
					if(x>=16){
						setVelX(1);
					}
				}
			}
		}
		
		if(velY==1){
			setZufallszahl(r.nextInt(2));
			setSchonentschieden(true);
		}
		
		
		if(falling){
			gravity+=0.5f;
			for(Tile t:handler.tile){
				if(t.getId()==Id.wall){
					if(getBottom().intersects(t.getBounds())){
						gravity = 0f;
						falling = false;
					}
				}
			}
			setVelY((int)gravity);
		}
		
		setFramedelay2(getFramedelay2()+1);
		if(getFramedelay2()>=10){
			setFrame2(getFrame2() + 1);
			setFramedelay2(0);
			if(getFrame2()==10){
				erscheinen=true;
			}
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
	public static void Goombasinit(){
		setCounter(getCounter()+1);
		if(getCounter()==500){
			if(j<goomba.length){
				for(int i=0;i<goomba.length;i++){
					setSpawnpoint(r.nextInt(2));
					if(Mouse.map==1){
					if(getSpawnpoint()==0){goomba[i] = new Goomba(396,5,60,60,true,Game.handler,Id.enemy);}
					if(getSpawnpoint()==1){goomba[i] = new Goomba(851,5,60,60,true,Game.handler,Id.enemy);}
					}
					if(Mouse.map==2){
						if(getSpawnpoint()==0){goomba[i] = new Goomba(16,213,60,60,true,Game.handler,Id.enemy);}
						if(getSpawnpoint()==1){goomba[i] = new Goomba(1155,610,60,60,true,Game.handler,Id.enemy);}
						}
				}
			Game.handler.addEnemy(goomba[j]);
			j++;
			}
			setCounter(0);
		}
	}
}
