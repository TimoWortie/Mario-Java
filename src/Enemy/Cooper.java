package Enemy;

import java.awt.Graphics;
import java.util.Random;

import Main.Game;
import Main.Handler;
import Main.Id;
import Tile.Tile;
import gfx.Sprite;

public class Cooper extends Enemy{

	public static int spawnpoint2;
	public static int counter;
	public static Random r = new Random();
	public static Sprite[] coopersprite = new Sprite[4];
	public static Cooper[] cooper = new Cooper[5];
	private int framedelay,framedelay2,frame,frame2,zufallszahl;
	private static int b;
	private boolean erscheinen=false;
	private boolean schonentschieden=false;
	
	public Cooper(int x, int y, int breite, int höhe, boolean solid, Handler handler, Id id) {
		super(x, y, breite, höhe, solid, handler, id);
	}
	
	public void render(Graphics g){
		for(int i=0;i<coopersprite.length;i++){
			coopersprite[i] = new Sprite(Game.sheet,i+21,3,1,1);
		}
		if(zufallszahl==1){g.drawImage(coopersprite[frame+2].getBufferedImage(),x,y,breite,höhe,null);}
		if(zufallszahl==0){g.drawImage(coopersprite[frame].getBufferedImage(),x,y,breite,höhe,null);}
	}
	public void tick(){
		x+=velX;
		y+=velY;
		
		
		for(Tile t:handler.tile){
			if(t.getId()==Id.wall){
				if(getBottom().intersects(t.getBounds())){
					setVelY(0);
					y=t.getY()-50;
					if(!schonentschieden){
						zufallszahl=r.nextInt(2);
						schonentschieden = true;
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
					falling = false;
					}else if(erscheinen){
						falling=true;
					}
			}
		}
		
		if(velY==1){
			zufallszahl=r.nextInt(2);
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
		
		framedelay2++;
		if(framedelay2>=10){
			frame2++;
			framedelay2=0;
			if(frame2==10){
				erscheinen=true;
			}
		}
		framedelay++;
		if(framedelay>=9){
			frame++;
			framedelay=0;
			if(frame==2){
				frame=0;
			}
		}
	}
	
	public static void Coopersinit(){
		Cooper.counter++;
		if(Cooper.counter==300){
			if(b<cooper.length){
				for(int i=0;i<cooper.length;i++){
					spawnpoint2 = r.nextInt(2);
					if(spawnpoint2==0){cooper[i] = new Cooper(1100,5,60,60,true,Game.handler,Id.enemy);}
					if(spawnpoint2==1){cooper[i] = new Cooper(150,5,60,60,true,Game.handler,Id.enemy);}
					}
			Game.handler.addEnemy(cooper[b]);
			b++;
			}
			Cooper.counter=0;
		}
	}

}
