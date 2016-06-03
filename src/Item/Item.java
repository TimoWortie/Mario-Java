package Item;

import java.awt.Graphics;
import java.awt.Rectangle;

import Main.Handler;
import Main.Id;
import Tile.Tile;

public class Item {
	
	int x,y,breite,höhe,velX,velY;
	boolean solid,shouldRemove = false;
	Handler handler;
	Id id;
	public float gravity = 0f;
	public boolean schonentschieden=false,erscheinen=false,falling = false;
	private int framedelay,framedelay2,frame,frame2,zufallszahl;
	public static int spawnpoint,spawnpoint2,counter,counter2;


	public Item(int x,int y,int breite,int höhe,boolean solid,Handler handler,Id id){
		this.x=x;
		this.y=y;
		this.breite=breite;
		this.höhe=höhe;
		this.handler=handler;
		this.id=id;
	}
	public static int getSpawnpoint2() {
		return spawnpoint2;
	}
	public static void setSpawnpoint2(int spawnpoint2) {
		Item.spawnpoint2 = spawnpoint2;
	}
	public static int getCounter2() {
		return counter2;
	}
	public static void setCounter2(int counter2) {
		Item.counter2 = counter2;
	}
	
	public static int getSpawnpoint() {
		return spawnpoint;
	}

	public static void setSpawnpoint(int spawnpoint) {
		Item.spawnpoint = spawnpoint;
	}

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Item.counter = counter;
	}
	
	public int getFramedelay() {
		return framedelay;
	}

	public void setFramedelay(int framedelay) {
		this.framedelay = framedelay;
	}

	public int getFramedelay2() {
		return framedelay2;
	}

	public void setFramedelay2(int framedelay2) {
		this.framedelay2 = framedelay2;
	}

	public int getFrame() {
		return frame;
	}

	public void setFrame(int frame) {
		this.frame = frame;
	}

	public int getFrame2() {
		return frame2;
	}

	public void setFrame2(int frame2) {
		this.frame2 = frame2;
	}

	public int getZufallszahl() {
		return zufallszahl;
	}

	public void setZufallszahl(int zufallszahl) {
		this.zufallszahl = zufallszahl;
	}

	public boolean isErscheinen() {
		return erscheinen;
	}

	public void setErscheinen(boolean erscheinen) {
		this.erscheinen = erscheinen;
	}
	
	public boolean isSchonentschieden() {
		return schonentschieden;
	}

	public void setSchonentschieden(boolean schonentschieden) {
		this.schonentschieden = schonentschieden;
	}

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	public  void render(Graphics g){	
	}
	
	public void tick(){
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getBreite() {
		return breite;
	}

	public int getHöhe() {
		return höhe;
		
	}
	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public boolean isSolid() {
		return solid;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(getX(),getY(),breite,höhe);
	}
	
	public Rectangle getBottom(){
		return new Rectangle(x,y+höhe-6,breite,5);
	}
	
	public boolean shouldRemove() {
		return shouldRemove;
	}

	public void setAsRemoved() {
		this.shouldRemove = true;
	}
	public void falling(){
		falling=true;
			gravity+=0.5f;
			for(Tile t:handler.tile){
				if(t.getId()==Id.wall){
					if(getBottom().intersects(t.getBounds())){
						gravity = 0f;
						falling = false;
					}
			}
			setVelY((int)gravity);
		}
	}
	public void FrameDelay2(int größergleich,int frames){
		framedelay2++;
		if(framedelay2>=größergleich){
			frame2++;
			framedelay2=0;
			if(frame2==frames){
				erscheinen=true;
			}
		}
	}
	public void FrameDelay(int größergleich,int frames){
		framedelay++;
		if(framedelay>=größergleich){
			frame++;
			framedelay=0;
			if(frame==frames){
				frame=0;
			}
		}

	}
}