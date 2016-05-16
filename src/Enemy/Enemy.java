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
	public boolean schonentschieden=false;
	public boolean erscheinen=false;
	private int framedelay,framedelay2,frame,frame2,zufallszahl;
	public static int spawnpoint,spawnpoint2;
	public static int counter,counter2;


	public void setY(int y) {
		this.y = y;
	}
	public Enemy(int x,int y,int breite,int höhe,boolean solid,Handler handler,Id id){
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
	public static int getCounter2() {
		return counter2;
	}
	public static void setCounter2(int counter2) {
		Enemy.counter2 = counter2;
	}
	
	public static int getSpawnpoint() {
		return spawnpoint;
	}

	public static void setSpawnpoint(int spawnpoint) {
		Enemy.spawnpoint = spawnpoint;
	}

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Enemy.counter = counter;
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
}