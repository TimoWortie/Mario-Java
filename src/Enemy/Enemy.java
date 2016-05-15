package Enemy;

import java.awt.Graphics;
import java.awt.Rectangle;

import Main.Handler;
import Main.Id;

public class Enemy {
	
	int x,y,breite,höhe,velX,velY;
	boolean solid;
	boolean shouldRemove = false;
	Handler handler;
	Id id;
	public float gravity = 0f;
	public boolean falling = false;
	
	

	
	public Enemy(int x,int y,int breite,int höhe,boolean solid,Handler handler,Id id){
		this.x=x;
		this.y=y;
		this.breite=breite;
		this.höhe=höhe;
		this.handler=handler;
		this.id=id;
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
	
	public Rectangle getTop(){
		return new Rectangle(x+10,y,breite-20,20);
	}
	public Rectangle getRight(){
		return new Rectangle(x+breite-10,y+10,10,höhe-20);
	}
	public Rectangle getLeft(){
		return new Rectangle(x,y+10,10,höhe-20);
	}
	
	public boolean shouldRemove() {
		return shouldRemove;
	}

	public void setAsRemoved() {
		this.shouldRemove = true;
	}
}