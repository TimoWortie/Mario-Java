package Enemy;

import java.awt.Color;
import java.awt.Graphics;

import Entity.Entity;
import Main.Handler;
import Main.Id;
import Tile.Tile;

public class Test extends Enemy{
	
	public static int framedelay,frame;
	public static boolean erscheinen=false;
	
	public Test(int x, int y, int breite, int höhe, boolean solid, Handler handler, Id id) {
		super(x, y, breite, höhe, solid, handler, id);
	}

	public void render(Graphics g){
		g.setColor(Color.green);
		g.fillRect(x, y, breite, höhe);
	}
	
	public void tick(){
		x+=velX;
		y+=velY;
		
		
		
		for(Tile t:handler.tile){
			if(t.getId()==Id.wall){	
				if(getBottom().intersects(t.getBounds())){
					setVelY(0);
					y=t.getY()-28;
					if(falling){ falling = false;}
					}else if(erscheinen){
						falling=true;
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
		
		framedelay++;
		if(framedelay>=60){
			frame++;
			framedelay=0;
			if(frame==10){
				erscheinen=true;
			}
		}
		System.out.println(frame);
	}
}
