package Item;

import java.awt.Graphics;
import java.util.Random;

import Input.Mouse;
import Main.Game;
import Main.Handler;
import Main.Id;
import Tile.Tile;
import gfx.Sprite;

public class Flower extends Item{

	private Sprite flowersprite = new Sprite(Game.sheet,25,1,1,1);
	private static Random ra = new Random();
	public static Flower[] flower = new Flower[10];
	public static int f;
	private int richtung;
	
	public Flower(int x, int y, int breite, int höhe, boolean solid, Handler handler, Id id) {
		super(x, y, breite, höhe, solid, handler, id);
	}
	
	public void render(Graphics g){
		g.drawImage(flowersprite.getBufferedImage(),x,y,breite,höhe,null);
	}
	
	public void tick(){
		x+=velX;
		y+=velY;
		
		for(Tile t:handler.tile){
			if(t.getId()==Id.wall){
				if(getBottom().intersects(t.getBounds())){
					setVelY(0);
					y=t.getY()-50;
					falling = false;
					}else if(isErscheinen()){
						falling=true;
					}
			}
		
		setFramedelay2(getFramedelay2() + 1);
		if(getFramedelay2()>=10){
			setFrame2(getFrame2() + 1);
			setFramedelay2(0);
			if(getFrame2()==10){
				erscheinen=true;
			}
		}
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
	}
	
	public static void flowersinit(){
		setCounter(getCounter()+1);
		System.out.println(getCounter());
		if(getCounter()==500){
			if(f<flower.length){
				for(int i=0;i<flower.length;i++){
					setSpawnpoint(ra.nextInt(2));
					if(Mouse.map==1){
					if(getSpawnpoint()==0){
						flower[i] = new Flower(396,5,60,60,true,Game.handler,Id.flower);
						flower[i].setVelX(2);
					}
					if(getSpawnpoint()==1){
						flower[i] = new Flower(851,5,60,60,true,Game.handler,Id.flower);
						flower[i].setVelX(-2);
					}
					}
					if(Mouse.map==2){
						if(getSpawnpoint()==0){
							flower[i] = new Flower(16,155,60,60,true,Game.handler,Id.flower);
							flower[i].setVelX(2);
						}
						if(getSpawnpoint()==1){
							flower[i] = new Flower(1155,535,60,60,true,Game.handler,Id.flower);
							flower[i].setVelX(-2);
						}
						}
				}
			Game.handler.addItem(flower[f]);
			f++;
			}
			setCounter(0);
		}
	}

}
