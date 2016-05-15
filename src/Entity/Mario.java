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
	private Sprite[] mario2 = new Sprite[15];
	private int y2,y3;
	
	public Mario(int x, int y, int breite, int höhe, boolean solid, Handler handler, Id id) {
		super(x, y, breite, höhe, solid, handler, id);
	}
	
	public void render(Graphics g){
		for(int i=0;i<mario.length;i++){
			mario[i] =  new Sprite(Game.sheet,i+1,1,1,1);
			}
		for(int i=0;i<mario2.length;i++){
		mario2[i]=new Sprite(Game.sheet,i+15,2,1,1);
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
		}else{
			if(moving==-1&&!jumping&&!falling){g.drawImage( mario2[0].getBufferedImage(), x, y, breite,höhe,null);}
			if(moving==1&&!jumping&&!falling){g.drawImage( mario2[frame].getBufferedImage(), x, y, breite,höhe,null);}
			if(moving==1&&jumping&&!falling||moving==-1&&jumping&&!falling){g.drawImage( mario2[11].getBufferedImage(), x, y, breite,höhe,null);}
			if(moving==1&&!jumping&&falling||moving==-1&&!jumping&&falling){g.drawImage( mario2[13].getBufferedImage(), x, y, breite,höhe,null);}
			
			if(moving==-2&&!jumping&&!falling){g.drawImage( mario2[5].getBufferedImage(), x, y, breite,höhe,null);}
			if(moving==2&&!jumping&&!falling){g.drawImage( mario2[frame+6].getBufferedImage(), x, y, breite,höhe,null);}
			if(moving==2&&jumping&&!falling||moving==-2&&jumping&&!falling){g.drawImage( mario2[12].getBufferedImage(), x, y, breite,höhe,null);}
			if(moving==2&&!jumping&&falling||moving==-2&&!jumping&&falling){g.drawImage( mario2[14].getBufferedImage(), x, y, breite,höhe,null);}
			g.setColor(Color.white);
			g.drawRect(x+33, y+33, 38, 5);
			g.setColor(Color.red);
			g.drawRect(getX()+33,getY()+96,34,5);
			g.setColor(Color.green);
			g.drawRect(getX()+70,getY()+45,5,42);
			g.setColor(Color.CYAN);
			g.drawRect(getX()+26,getY()+45,5,42);
			g.setColor(Color.MAGENTA);
			g.drawRect(getX()+26,getY()+30,49,höhe-30);
		
		
		

		}
		if(hit==true){
			g.setColor(Color.MAGENTA);
			g.fillRect(getX()+26,getY()+30,49,höhe-30);
		}
		
	}
	
	public void tick(){	
		x+=velX;
		y+=velY;
		for(Enemy ene:handler.enemy){
			if(hit==false){
				if(this.klein==false){
					if(getLeft().intersects(ene.getRight())){
						setVelX(0);
						x=ene.getX()+61;
						klein=true;
						hit=true;
					}
					if(getRight().intersects(ene.getLeft())){
						setVelX(0);
						x=ene.getX()-50;
						klein=true;
						hit=true;
					}
					if(getBottom().intersects(ene.getTop())){
						setVelY(0);
						y=y-40;
						jumping=true;
						falling=false;
						gravity=5.0f;
						ene.setAsRemoved();
					}
			}else{
				
					if(getLeft().intersects(ene.getRight())){
						setVelX(0);
						x=ene.getX()+61;
						
					}
					if(getRight().intersects(ene.getLeft())){
						setVelX(0);
						x=ene.getX()-50;
						
					}
					if(getBottom().intersects(ene.getTop())){
						setVelY(0);
						y=y-40;
						jumping=true;
						falling=false;
						gravity=5.0f;
						ene.setAsRemoved();
					
			}}
				
				}else{ if(timer<300){
					
					timer+=1;
				}else{
				hit=false;
				}
				}}
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
					y=t.getY()+50;
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