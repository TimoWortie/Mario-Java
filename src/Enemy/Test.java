package Enemy;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import Main.Game;
import Main.Handler;
import Main.Id;
import Tile.Tile;

public class Test extends Enemy{
	
	private int framedelay,frame,zufallszahl;
	private Random r = new Random();
	private boolean erscheinen=false,schonentschieden=false;
	
	
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
					if(!schonentschieden){
						zufallszahl = r.nextInt(2);
						System.out.println(zufallszahl);
						schonentschieden=true;
						}
					if(zufallszahl==0){
						setVelX(1);
					}
					if(zufallszahl==1){
						setVelX(-1);
					}
					if(x+breite>=Game.getFrameBreite()&&y<520){
						zufallszahl=1;
					}
					if(x<=0&&y<520){
						zufallszahl=0;
					}
					if(falling){ falling = false;}
					}else if(erscheinen){
						falling=true;
					}
			}
		}
		
		if(velY>0){
			zufallszahl = r.nextInt(2);
			System.out.println(zufallszahl);
			schonentschieden=true;
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
		if(framedelay>=10){
			frame++;
			framedelay=0;
			if(frame==10){
				erscheinen=true;
			}
		}
	}
}
