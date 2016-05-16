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

public class Koopa extends Enemy{

	public static Random r = new Random();
	private Sprite[] koopasprite = new Sprite[4];
	public static Koopa[] koopa = new Koopa[100];
	public static int b;
	public static int spawnzeit;
	public static boolean gecountet=false;
	
	public Koopa(int x, int y, int breite, int höhe, boolean solid, Handler handler, Id id) {
		super(x, y, breite, höhe, solid, handler, id);
	}
	
	public void render(Graphics g){
		for(int i=0;i<koopasprite.length;i++){
			koopasprite[i] = new Sprite(Game.sheet,i+21,3,1,1);
		}
		if(getZufallszahl()==1){g.drawImage(koopasprite[getFrame()+2].getBufferedImage(),x-10,y-20,breite+20,höhe+20,null);}
		if(getZufallszahl()==0){g.drawImage(koopasprite[getFrame()].getBufferedImage(),x-10,y-20,breite+20,höhe+20,null);}
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
		
		setFramedelay2(getFramedelay2() + 1);
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
	
	public static void koopasinit(){
		setCounter2(getCounter2()+1);
		if(!gecountet){
			spawnzeit = r.nextInt(10)+5;
			gecountet=true;
		}
		if(getCounter2()/60==spawnzeit){
			if(b<koopa.length){
				for(int i=0;i<koopa.length;i++){
					setSpawnpoint2(r.nextInt(2));
					if(Mouse.map==1){
						if(getSpawnpoint2()==0){koopa[i] = new Koopa(396,5,60,60,true,Game.handler,Id.enemy);}
						if(getSpawnpoint2()==1){koopa[i] = new Koopa(851,5,60,60,true,Game.handler,Id.enemy);}
					}
					if(Mouse.map==2){
						if(getSpawnpoint2()==0){koopa[i] = new Koopa(16,155,60,60,true,Game.handler,Id.enemy);}
						if(getSpawnpoint2()==1){koopa[i] = new Koopa(1155,535,60,60,true,Game.handler,Id.enemy);}
					}
					gecountet=false;
					}
			Game.handler.addEnemy(koopa[b]);
			b++;
			}
			setCounter2(0);
		}
	}
}
