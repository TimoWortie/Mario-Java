package Enemy;

import java.awt.Graphics;
import java.awt.Rectangle;

import Main.Handler;
import Main.Id;
import Tile.Tile;

public class Enemy {
	
	Handler handler;
	Id id;
	public float gravity = 0f;
	protected boolean falling = false;
	private boolean schonentschieden=false;
	private boolean erscheinen=false;
	private boolean shouldRemove = false;
	public int x,y,breite,höhe,velX,velY,framedelay,framedelay2,frame,frame2,zufallszahl;
	public static int spawnpoint,spawnpoint2;


	public void setY(int y) {
		this.y = y;
	}
	public Enemy(int x,int y,int breite,int höhe,Handler handler,Id id){
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
		Enemy.spawnpoint2 = spawnpoint2;
	}
	public static int getSpawnpoint() {
		return spawnpoint;
	}
	public static void setSpawnpoint(int spawnpoint) {
		Enemy.spawnpoint = spawnpoint;
	}
	public int getFrame() {
		return frame;
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
	public boolean isSchonentschieden() {
		return schonentschieden;
	}
	public void setSchonentschieden(boolean schonentschieden) {
		this.schonentschieden = schonentschieden;
	}
	public Id getId() {
		return id;
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
	public Rectangle getBounds(){
		return new Rectangle(getX(),getY(),breite,höhe);
	}
	public Rectangle getBottom(){
		return new Rectangle(x,y+höhe-6,breite,5);
	}
	public Rectangle getTop(){
		return new Rectangle(x+10,y,breite-20,20);
	}
	public Rectangle getRight(){
		return new Rectangle(x+breite-30,y+10,30,höhe-20);
	}
	public Rectangle getLeft(){
		return new Rectangle(x,y+10,30,höhe-20);
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