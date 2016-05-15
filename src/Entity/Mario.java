package Entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import Enemy.Enemy;
import Input.Key;
import Input.Mouse;
import Main.Game;
import Main.Handler;
import Main.Id;
import Tile.Tile;
import gfx.Sprite;

public class Mario extends Entity{
	int frame,framedelay;
	public static int moving=-1;
	private Sprite[] mario = new Sprite[15];
	private int y2,y3;
	
	public Mario(int x, int y, int breite, int höhe, boolean solid, Handler handler, Id id) {
		super(x, y, breite, höhe, solid, handler, id);
	}
	
	public void render(Graphics g){
		for(int i=0;i<mario.length;i++){
			mario[i] =  new Sprite(Game.sheet,i+1,1,1,1);
			}
		if(klein==false){
		if(moving==-1&&!jumping&&!falling){g.drawImage( mario[0].getBufferedImage(), x, y, breite,höhe,null);}
		if(moving==1&&!jumping&&!falling){g.drawImage( mario[frame].getBufferedImage(), x, y, breite,höhe,null);}
		if(moving==1&&jumping&&!falling||moving==-1&&jumping&&!falling){g.drawImage( mario[11].getBufferedImage(), x, y, breite,höhe,null);}
		if(moving==1&&!jumping&&falling||moving==-1&&!jumping&&falling){g.drawImage( mario[13].getBufferedImage(), x, y, breite,höhe,null);}
		
		if(moving==-2&&!jumping&&!falling){g.drawImage( mario[5].getBufferedImage(), x, y, breite,höhe,null);}
		if(moving==2&&!jumping&&!falling){g.drawImage( mario[frame+6].getBufferedImage(), x, y, breite,höhe,null);}
		if(moving==2&&jumping&&!falling||moving==-2&&jumping&&!falling){g.drawImage( mario[12].getBufferedImage(), x, y, breite,höhe,null);}
		if(moving==2&&!jumping&&falling||moving==-2&&!jumping&&falling){g.drawImage( mario[14].getBufferedImage(), x, y, breite,höhe,null);}
		}
		
		g.setColor(Color.white);
		g.drawRect(x+33, y+13, 38, 5);
		g.setColor(Color.red);
		g.drawRect(getX()+33,getY()+96,34,5);
		g.setColor(Color.green);
		g.drawRect(getX()+70,getY()+25,5,62);
		g.setColor(Color.CYAN);
		g.drawRect(getX()+26,getY()+25,5,62);
		g.setColor(Color.MAGENTA);
		g.drawRect(getX()+26,getY()+10,49,höhe-10);
	}
	
	public void tick(){	
		x+=velX;
		y+=velY;
		for(Enemy ene:handler.enemy){
			if(this.klein==false){
				if(getLeft().intersects(ene.getBounds())){
					setVelX(0);
					x=ene.getX()+70;
					klein=true;
					System.out.println("tot");
				}
				if(getRight().intersects(ene.getBounds())){
					setVelX(0);
					x=ene.getX()-70;
					klein=true;
					System.out.println("tot");
				}
				if(getBottom().intersects(ene.getBounds())){
					setVelY(0);
					y=y-40;
					jumping=true;
					falling=false;
					gravity=5.0f;
					ene.setAsRemoved();
				}
		}else{
			
				if(getLeft().intersects(ene.getBounds())){
					setVelX(0);
					x=ene.getX()+70;
					
				}
				if(getRight().intersects(ene.getBounds())){
					setVelX(0);
					x=ene.getX()-70;
					
				}
				if(getBottom().intersects(ene.getBounds())){
					setVelY(0);
					y=y-40;
					jumping=true;
					falling=false;
					gravity=5.0f;
					ene.setAsRemoved();
				
		}}}
		for(Entity en:handler.entity){
			if(en.getId()==Id.Luigi){
				if(getLeft().intersects(en.getRight())){
					setVelX(0);
					x=en.getX()+60;
					x=en.getX()+50;
				}
				if(getRight().intersects(en.getLeft())){
					setVelX(0);
					x=en.getX()-60;
					x=en.getX()-50;
				}
				
				if(getBottom().intersects(en.getBounds())){
					setVelY(0);
					y=y-40;
					jumping=true;
					falling=false;
					gravity=5.0f;
				}
		}}
		
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
		if(Key.d&&Key.shift||Key.a&&Key.shift){
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
		
		if(Key.d&&Key.shift){
			setVelX(8);
			Mario.moving=1;
		}else if(Key.d&&!Key.shift){
			setVelX(5);
			Mario.moving=1;
		}
		
		if(Key.a&&Key.shift){
			setVelX(-8);
			Mario.moving=2;
		}else if(Key.a&&!Key.shift){
			setVelX(-5);
			Mario.moving=2;
		}
		
		if(x<10&&x>0){
			y3=y;
		}
		if(x+breite<2){
			x=Game.getFrameBreite()+120;
			y=y3;
		}
		
		if(x<Game.getFrameBreite()+70&&x>Game.getFrameBreite()+60){
			y2=y;
		}
		if(x>Game.getFrameBreite()+130){
			x=-3;
			y=y2;
		}
	  }
	}