package Main;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

import Enemy.Test;
import Entity.Entity;
import Entity.Player;
import Input.Key;
import Input.Mouse;
import gfx.ImageLoader;
import gfx.Sprite;
import gfx.Spritesheet;




public class Game extends Canvas implements Runnable{
	public static int breite = 270,höhe = breite/14*10,scale = 4;
	public boolean running = false;
	public Thread thread = new Thread();
	public static Handler handler = new Handler();
	public static Player player = new Player(1000,500,100,100,true,handler,Id.player);
	public static Camera cam;
	
	private BufferedImage image,background;
	public static Spritesheet sheet;
	public static Sprite[] mario = new Sprite[31];
	public static Sprite grass,pipe,pipe2,pipe3,block;
	public static Test test;
	
	public void init(){
		handler.addEntity(player);
		sheet = new Spritesheet("/Spritesheet.png");
		cam = new Camera();
		for(int i=0;i<mario.length;i++){
		mario[i] =  new Sprite(sheet,i+1,1,1,1);
		}
		block = new Sprite(sheet,3,2,1,1);
		pipe = new Sprite(sheet,1,2,1,1);
		pipe2 = new Sprite(sheet,2,2,1,1);
		pipe3 = new Sprite(sheet,4,2,1,1);
		test = new Test(29,408,30,30,true,handler,Id.enemy);

		handler.addEnemy(test);
		addMouseListener(new Mouse());
		addKeyListener(new Key());
		try {
			image = ImageIO.read(getClass().getResource("/level.png"));
			background = ImageIO.read(getClass().getResource("/Background1.png"));
		} catch (IOException e) {}
		handler.createlevel(image);
	}
	
	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs==null){
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.drawImage(background, 0, 0, getWidth(),getHeight(),null);
//		g.translate(cam.getX(), cam.getY()+220);
		g.drawString("jannik ist cool", 250,250);
		
		handler.render(g);
		g.dispose();
		bs.show();
	}
	
	public void tick(){
		handler.tick();
		
		for(Entity e:handler.entity){
			if(e.getId()==Id.player){
				cam.tick(e);
			}
		}
		
		
	}
	
	public synchronized void start(){
		if(running) return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running) return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {}
	}
	
	 
	public void run(){
		
		init();
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double delta = 0.0;
		double nanosecounds = 1000000000.0/60.0;
		int frames = 0;
		int ticks = 0;
		while(running){
			long now = System.nanoTime();
			delta+=(now-lastTime)/nanosecounds;
			lastTime = now;
			while(delta>=1){
				tick();
				ticks++;
				delta--;
			}
			render();
			frames++;
			if(System.currentTimeMillis()-timer>1000){
				timer+=1000;
				frames = 0;
				ticks = 0;
			}
		}
		stop();
	}
	
	public Game(){
		Dimension size = new Dimension(breite*scale,höhe*scale);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
	}
	
	public static int getFrameBreite(){
		return breite*scale;
	}
	
	public static int getFrameHöhe(){
		return höhe*scale;
	}
	
	
}
