package Entity;

import java.awt.Color;
import java.awt.Graphics;

import Input.KeyLuigi;
import Input.Mouse;
import Main.Game;
import Main.Handler;
import Main.Id;
import Tile.Tile;
import gfx.Sprite;

public class Luigi extends Entity{
	int frame,framedelay;
	public static int moving=-1;
	public static Sprite[] luigi = new Sprite[31];
	
	public Luigi(int x, int y, int breite, int höhe, boolean solid, Handler handler, Id id) {
		super(x, y, breite, höhe, solid, handler, id);
	}
	
	public void render(Graphics g){
		for(int i=0;i<luigi.length;i++){
			luigi[i] =  new Sprite(Game.sheet,i+1,3,1,1);
			}
		
		if(moving==-1&&!jumping&&!falling){g.drawImage( luigi[0].getBufferedImage(), x, y, breite,höhe,null);}
		if(moving==1&&!jumping&&!falling){g.drawImage( luigi[frame].getBufferedImage(), x, y, breite,höhe,null);}
		if(moving==1&&jumping&&!falling){g.drawImage( luigi[26].getBufferedImage(), x, y, breite,höhe,null);}
		if(moving==1&&!jumping&&falling){g.drawImage( luigi[28].getBufferedImage(), x, y, breite,höhe,null);}
		if(moving==-1&&jumping&&!falling){g.drawImage( luigi[26].getBufferedImage(), x, y, breite,höhe,null);}
		if(moving==-1&&!jumping&&falling){g.drawImage( luigi[28].getBufferedImage(), x, y, breite,höhe,null);}
		
		if(moving==-2&&!jumping&&!falling){g.drawImage( luigi[13].getBufferedImage(), x, y, breite,höhe,null);}
		if(moving==2&&!jumping&&!falling){g.drawImage( luigi[frame+14].getBufferedImage(), x, y, breite,höhe,null);}
		if(moving==2&&jumping&&!falling){g.drawImage( luigi[27].getBufferedImage(), x, y, breite,höhe,null);}
		if(moving==2&&!jumping&&falling){g.drawImage( luigi[29].getBufferedImage(), x, y, breite,höhe,null);}
		if(moving==-2&&jumping&&!falling){g.drawImage( luigi[27].getBufferedImage(), x, y, breite,höhe,null);}
		if(moving==-2&&!jumping&&falling){g.drawImage( luigi[29].getBufferedImage(), x, y, breite,höhe,null);}
	}
	
	public void tick(){	
		x+=velX;
		y+=velY;
		
		for(Tile t:handler.tile){
			if(t.getId()==Id.wall){
				if(getTop().intersects(t.getBounds())){
					setVelY(0);
					y=t.getY()+47;
					jumping=false;
					falling=true;
					gravity=0;	
				}
				
				if(getBottom().intersects(t.getBounds())){
					setVelY(0);
					y=t.getY()-100;
					if(falling){ falling = false;}
					}else if(!jumping){
						falling=true;
						}
				
				if(getLeft().intersects(t.getBounds())){
					setVelX(0);
					x=t.getX()+40;
				}
				if(getRight().intersects(t.getBounds())){
					setVelX(0);
					x=t.getX()-75;
				}
			  }
			}
		
		if(jumping){
			gravity-=0.5f;
			setVelY((int)-gravity);
			if(gravity<=0.0f){
				falling=true;
				jumping=false;
			}
		}
		if(falling){
			gravity+=0.5f;
			for(Tile t:handler.tile){
				if(t.getId()==Id.wall){
					if(getBottom().intersects(t.getBounds())){
						gravity = 0f;
						jumping = false;
						falling = false;
					}
				}
			}
			setVelY((int)gravity);
		}
		framedelay++;
		if(KeyLuigi.d&&KeyLuigi.shift||KeyLuigi.a&&KeyLuigi.shift){
			if(framedelay>=5){
				frame++;
				if(frame>=5){
					frame=0;
				}
				framedelay=0;
			}
		}else if(framedelay>=6){
			frame++;
			if(frame>=5){
				frame=0;
			}
			framedelay=0;
		}
		
		if(KeyLuigi.d&&KeyLuigi.shift){
			setVelX(8);
			Luigi.moving=1;
		}else if(KeyLuigi.d&&!KeyLuigi.shift){
			setVelX(5);
			Luigi.moving=1;
		}
		
		if(KeyLuigi.a&&KeyLuigi.shift){
			setVelX(-8);
			Luigi.moving=2;
		}else if(KeyLuigi.a&&!KeyLuigi.shift){
			setVelX(-5);
			Luigi.moving=2;
		}
	  }
	}