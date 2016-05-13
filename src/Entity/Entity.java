package Entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import Main.Handler;
import Main.Id;

public class Entity {
	
	int x,y,breite,h�he,velX,velY;
	boolean solid;
	boolean shouldRemove = false;
	Handler handler;
	Id id;
	public float gravity = 0f;
	public boolean jumping = false;
	public boolean falling = true;

	
	public Entity(int x,int y,int breite,int h�he,boolean solid,Handler handler,Id id){
		this.x=x;
		this.y=y;
		this.breite=breite;
		this.h�he=h�he;
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

	public int getH�he() {
		return h�he;
		
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
		return new Rectangle(getX(),getY(),breite,h�he);
	}
	
	public Rectangle getTop(){
		return new Rectangle(x+33, y+13, 38, 5);
	}
	
	public Rectangle getBottom(){
		return new Rectangle(getX()+33,getY()+96,34,5);
	}
	
	public Rectangle getRight(){
		return new Rectangle(getX()+70,getY()+15,5,82);
	}
	
	public Rectangle getLeft(){
		return new Rectangle(getX()+26,getY()+15,5,82);
	}
	
	public boolean shouldRemove() {
		return shouldRemove;
	}

	public void setAsRemoved() {
		this.shouldRemove = true;
	}
}
