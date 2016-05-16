package Item;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import Input.Mouse;
import Main.Game;
import Main.Handler;
import Main.Id;
import Tile.Tile;
import gfx.Sprite;

public class Pilz extends Item{
	
	public static Random r = new Random();
	public static int j;
	private Sprite Pilzsprite;
	public static Pilz[] pilz = new Pilz[10];
	private boolean playsound;
	
	
	public Pilz(int x, int y, int breite, int h�he, boolean solid, Handler handler, Id id) {
		super(x, y, breite, h�he, solid, handler, id);
	}

	public void render(Graphics g){
		Pilzsprite=new Sprite(Game.sheet,24 , 1, 1, 1);
		g.drawImage(Pilzsprite.getBufferedImage(),x,y,breite,h�he,null);
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
						if(playsound==false){
							Game.handler.ChangeMusic(9, 1, false);
							playsound=true;
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
		if(getFramedelay()>=9)
			setFrame(getFrame() + 1);
			setFramedelay(0);
			if(getFrame()==2){
				setFrame(0);
			}
		}
	

	public static void Pilzsinit(){
		setCounter2(getCounter2()+1);
		if(getCounter2()==5000){
			if(j<pilz.length){
				for(int i=0;i<pilz.length;i++){
					setSpawnpoint(r.nextInt(2));
					System.out.println("test");
					if(Mouse.map==1){
					if(getSpawnpoint()==0){
						pilz[i] = new Pilz(396,5,60,60,true,Game.handler,Id.pilz);
						}
					}
					if(getSpawnpoint()==1){pilz[i] = new Pilz(851,5,60,60,true,Game.handler,Id.pilz);}
					
					if(Mouse.map==2){
						if(getSpawnpoint()==0){pilz[i] = new Pilz(16,155,60,60,true,Game.handler,Id.pilz);}
						if(getSpawnpoint()==1){pilz[i] = 
						pilz[i]=new Pilz(1155,535,60,60,true,Game.handler,Id.pilz);}
						}
					
				}
			Game.handler.addItem(pilz[j]);
			
			
			j++;
			}
			setCounter(0);
		}
	}
}
