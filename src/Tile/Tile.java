package Tile;

import java.awt.Graphics;
import java.awt.Rectangle;

import Main.Handler;
import Main.Id;

public class Tile {
	int x,y,breite,h�he;
	boolean solid;
	boolean shouldRemove = false;

	Id id;
	Handler handler;
	public Tile(int x,int y,int breite,int h�he,boolean solid,Handler handler,Id id){
		this.x=x;
		this.y=y;
		this.breite=breite;
		this.h�he=h�he;
		this.id=id;
		this.handler=handler;
	}

	public Id getId() {
		return id;
	}
	public Rectangle getBoundsJoschiM�nze(){
		return new Rectangle(x+13,y+2,getBreite()-28,getH�he()-5);
	}
	public Rectangle getBoundsM�nze(){
		return new Rectangle(x+13,y+2,getBreite()-28,getH�he()-5);
	}

	public void setId(Id id) {
		this.id = id;
	}

	public void render(Graphics g){}

	public void tick(){}
	
	
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

	public boolean isSolid() {
		return solid;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x,y,breite,h�he);
	}
	
	public boolean shouldRemove() {
		return shouldRemove;
	}

	public void setAsRemoved() {
		this.shouldRemove = true;
	}
}

