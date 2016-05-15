package Entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import Main.Handler;
import Main.Id;

public class Entity {
	
	int x,y,breite,höhe,velX,velY,timer,timer2;
	boolean solid;
	boolean shouldRemove = false;
	Handler handler;
	Id id;
	public float gravity = 0f;
	public boolean jumping = false;
	public boolean falling = true;
	public boolean klein=false;
	public boolean hit=false;

	
	public Entity(int x,int y,int breite,int höhe,boolean solid,Handler handler,Id id){
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
		if(klein==false){
			return new Rectangle(getX()+26,getY()+10,49,höhe-10);
		}else{
			return new Rectangle(getX()+26,getY()+30,49,höhe-30);	
		}
	}
	
	public Rectangle getTop(){
		if(klein==false){
			return new Rectangle(x+33, y+13, 38, 5);
		}else{
			return new Rectangle(x+33, y+33, 38, 5);
		}
	}
	
	public Rectangle getBottom(){
		
			return new Rectangle(getX()+33,getY()+96,34,5);
		
	}
	
	public Rectangle getRight(){
		if(klein==false){
			return new Rectangle(getX()+70,getY()+25,5,62);
		}else{
			return new Rectangle(getX()+70,getY()+45,5,42);
		}
	}
	
	public Rectangle getLeft(){
		if(klein==false){
			return new Rectangle(getX()+26,getY()+25,5,62);
		}else{
			return new Rectangle(getX()+26,getY()+45,5,42);
		}
	}
	
	public boolean shouldRemove() {
		return shouldRemove;
	}

	public void setAsRemoved() {
		this.shouldRemove = true;
	}
	
	
	public void pause(int time){
        try{
            Thread.sleep(time);
        }
        catch(InterruptedException e){
        	e.printStackTrace();
     }}                  


}
