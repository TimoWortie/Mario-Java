package Entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import Main.Handler;
import Main.Id;
import Tile.Tile;

public class Entity {

	protected int x, y, breite, h�he, velX, velY, timer3, timer2, timertot, timerstunned;

	boolean shouldRemove = false;
	Handler handler;
	Id id;
	public float gravity = 0f;
	public boolean jumping = false,falling = true,klein = false,hit = false,tot = false;
	protected boolean tot1 = false;

	protected boolean klein2=false;
	
	public Entity(int x, int y, int breite, int h�he, Handler handler, Id id) {
		this.x = x;
		this.y = y;
		this.breite = breite;
		this.h�he = h�he;
		this.handler = handler;
		this.id = id;
	}
	
	public boolean isJumping() {
		return jumping;
	}
	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}
	public void setGravity(float gravity) {
		this.gravity = gravity;
	}
	public void setFalling(boolean falling) {
		this.falling = falling;
	}
	public Id getId() {
		return id;
	}
	public void render(Graphics g) {
	}

	public void tick() {
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

	public int getTimerstunned() {
		return timerstunned;
	}

	public void setTimerstunned(int timerstunned) {
		this.timerstunned = timerstunned;
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

	public Rectangle getBounds() {
		if (klein == false) {
			if(klein2==true){
				return new Rectangle(getX() + 26, getY() + 10, 49, h�he - 10);
			}else{
				return new Rectangle(getX() + 26, getY() + 30, 49, h�he - 30);
			}
			
		} else {
			return new Rectangle(getX() + 26, getY() + 30, 49, h�he - 30);
		}
	}

	public Rectangle getTop() {
		if (klein == false) {
			if(klein2==true){
				return new Rectangle(x + 33, y + 13, 38, 25);
			}else{
				return new Rectangle(x + 33, y + 33, 38, 25);
			}
		} else {
			return new Rectangle(x + 33, y + 33, 38, 5);
		}
	}
	public Rectangle getTopEn() {
		if (klein == false) {
			if(klein2==true){
				return new Rectangle(x + 33, y + 13, 38, 25);
			}else{
				return new Rectangle(x + 33, y + 33, 38, 25);
			}
		} else {
			return new Rectangle(x + 33, y + 33, 38, 25);
		}
	}

	public Rectangle getBottom() {

		return new Rectangle(getX() + 33, getY() + 96, 34, 5);

	}

	public Rectangle getRight() {
		if (klein == false) {
			if(klein2==true){
			return new Rectangle(getX() + 70, getY() + 25, 5, 62);
			}else{
				return new Rectangle(getX() + 70, getY() + 45, 5, 42);
			}
		} else {
			return new Rectangle(getX() + 70, getY() + 45, 5, 42);
		}
	}

	public Rectangle getLeft() {
		if (klein == false) {
			if(klein2==true){
				return new Rectangle(getX() + 26, getY() + 25, 5, 62);
			}else{
				return new Rectangle(getX() + 26, getY() + 45, 5, 42);
			}

		} else {
			return new Rectangle(getX() + 26, getY() + 45, 5, 42);
		}
	}

	public boolean shouldRemove() {
		return shouldRemove;
	}

	public void setAsRemoved() {
		this.shouldRemove = true;
	}



	public void jumping(float grav){
		gravity -= grav;
		setVelY((int) -gravity);
		if (gravity <= 0.0f) {
			falling = true;
			jumping = false;
		}
	}
	
	public void falling(){
		if (falling) {
			gravity += 0.5f;
			for (Tile t : handler.tile) {
				if (t.getId() == Id.wall) {
					if (getBottom().intersects(t.getBounds())) {
						gravity = 0f;
						jumping = false;
						falling = false;
					} 
				}
			}
			setVelY((int) gravity);
		}
	}

}
