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
	private boolean playsound;
	
	
	public Pilz(int x, int y, int breite, int höhe, boolean solid, Handler handler, Id id) {
		super(x, y, breite, höhe, solid, handler, id);
	}

	public void render(Graphics g){
		Pilzsprite=new Sprite(Game.sheet,24 , 1, 1, 1);
		g.drawImage(Pilzsprite.getBufferedImage(),x,y,breite,höhe,null);
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
			falling();
		}
		
		FrameDelay2(10,10);
		FrameDelay(9,2);
	}

	public static void Pilzsinit(){
		setCounter2(getCounter2()+1);
		if(getCounter2()==5000){
			if(j<Game.pilz.length){
				for(int i=0;i<Game.pilz.length;i++){
					setSpawnpoint(r.nextInt(2));
					System.out.println("test");
					if(Mouse.map==1){
					if(getSpawnpoint()==0){
						Game.pilz[i] = new Pilz(396,5,60,60,true,Game.handler,Id.pilz);
						}
					}
					if(getSpawnpoint()==1){Game.pilz[i] = new Pilz(851,5,60,60,true,Game.handler,Id.pilz);}
					
					if(Mouse.map==2){
						if(getSpawnpoint()==0){Game.pilz[i] = new Pilz(16,155,60,60,true,Game.handler,Id.pilz);}
						if(getSpawnpoint()==1){Game.pilz[i] = 
								Game.pilz[i]=new Pilz(1155,535,60,60,true,Game.handler,Id.pilz);}
						}
					
				}
			Game.handler.addItem(Game.pilz[j]);
			
			
			j++;
			}
			setCounter(0);
		}
	}
}
