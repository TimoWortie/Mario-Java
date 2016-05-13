package Tile;

import java.awt.Graphics;
import java.awt.Rectangle;

import Main.Handler;
import Main.Id;

public class Tile {
	int x,y,breite,höhe;
	boolean solid;
	boolean shouldRemove = false;

	Id id;
	Handler handler;
	public Tile(int x,int y,int breite,int höhe,boolean solid,Handler handler,Id id){
		this.x=x;
		this.y=y;
		this.breite=breite;
		this.höhe=höhe;
		this.id=id;
		this.handler=handler;
	}

	public Id getId() {
		return id;
	}
	public Rectangle getBoundsJoschiMünze(){
		return new Rectangle(x+13,y+2,getBreite()-28,getHöhe()-5);
	}
	public Rectangle getBoundsMünze(){
		return new Rectangle(x+13,y+2,getBreite()-28,getHöhe()-5);
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

	public int getHöhe() {
		return höhe;
	}

	public boolean isSolid() {
		return solid;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x,y,breite,höhe);
	}
	
	public boolean shouldRemove() {
		return shouldRemove;
	}

	public void setAsRemoved() {
		this.shouldRemove = true;
	}
}

