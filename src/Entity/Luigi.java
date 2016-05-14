package Entity;

import java.awt.Color;
import java.awt.Graphics;

import Enemy.Enemy;
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
		if(klein==false){
		if(moving==-1&&!jumping&&!falling){g.drawImage( luigi[0].getBufferedImage(), x, y, breite,höhe,null);}
		if(moving==1&&!jumping&&!falling){g.drawImage( luigi[frame].getBufferedImage(), x, y, breite,höhe,null);}
		if(moving==1&&jumping&&!falling||moving==-1&&jumping&&!falling){g.drawImage( luigi[11].getBufferedImage(), x, y, breite,höhe,null);}
		if(moving==1&&!jumping&&falling||moving==-1&&!jumping&&falling){g.drawImage( luigi[13].getBufferedImage(), x, y, breite,höhe,null);}
		
		if(moving==-2&&!jumping&&!falling){g.drawImage( luigi[5].getBufferedImage(), x, y, breite,höhe,null);}
		if(moving==2&&!jumping&&!falling){g.drawImage( luigi[frame+6].getBufferedImage(), x, y, breite,höhe,null);}
		if(moving==2&&jumping&&!falling||moving==-2&&jumping&&!falling){g.drawImage( luigi[12].getBufferedImage(), x, y, breite,höhe,null);}
		if(moving==2&&!jumping&&falling||moving==-2&&!jumping&&falling){g.drawImage( luigi[14].getBufferedImage(), x, y, breite,höhe,null);}
		}
		g.setColor(Color.white);
		g.drawRect(x+33, y+13, 38, 5);  //TOP
		g.setColor(Color.red);
		g.drawRect(getX()+33,getY()+96,34,5); //BOTTOM
		g.setColor(Color.green);
		g.drawRect(getX()+70,getY()+25,5,62); //RIGHT
		g.setColor(Color.CYAN);
		g.drawRect(getX()+26,getY()+25,5,62); //LEFT
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
					x=ene.getX()+60;
					klein=true;
					System.out.println("tot");
				}
				if(getRight().intersects(ene.getBounds())){
					setVelX(0);
					x=ene.getX()-60;
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
				
		}}
			
			
			
			if(getBottom().intersects(ene.getBounds())){
				setVelY(0);
				y=y-40;
				jumping=true;
				falling=false;
				gravity=5.0f;
				ene.setAsRemoved();
			}	
		
		
		
		
		
		
		
		
		
		}
		
		for(Entity en:handler.entity){
			if(en.getId()==Id.player){
				if(getLeft().intersects(en.getRight())){
					setVelX(0);
					x=en.getX()+50;
				}
				if(getRight().intersects(en.getLeft())){
					setVelX(0);
					x=en.getX()-50;
				}
				if(getBottom().intersects(en.getBounds())){
					setVelY(0);
					y=y-60;
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