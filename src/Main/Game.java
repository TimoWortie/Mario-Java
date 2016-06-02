package Main;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Enemy.Goomba;
import Enemy.Koopa;
import Enemy.Kugelwilli;
import Enemy.Monty;
import Entity.Entity;
import Entity.Luigi;
import Entity.Mario;
import Input.Key;
import Input.KeyLuigi;
import Input.Mouse;
import Item.Flower;
import Item.Pilz;
import Launcher.Launcher;
import Audio.SoundManager;
import gfx.Spritesheet;


public class Game extends Canvas implements Runnable{
	public static int breite = 270,höhe = breite/14*10,scale = 4;
	public static boolean running = false;
	public static Thread thread = new Thread();
	public static Handler handler = new Handler();
	public static Mario player = new Mario(1000,500,100,100,true,handler,Id.player);
	public static Luigi luigi = new Luigi(500,500,100,100,true,handler,Id.Luigi);
	public static Launcher launcher = new Launcher();
	
	
	public static BufferedImage image,image2,endscreenmario,endscreenluigi;
	private BufferedImage background;
	public static Spritesheet sheet;

	
	public void init(){
		handler.addEntity(player);
		sheet = new Spritesheet("/Spritesheet.png");
		handler.addEntity(luigi);
//		handler.ChangeMusic(1, 2, false);
		addMouseListener(new Mouse());
		addKeyListener(new Key());
		addKeyListener(new KeyLuigi());
		try {
			image = ImageIO.read(getClass().getResource("/level.png"));
			image2 = ImageIO.read(getClass().getResource("/level2.png"));
			background = ImageIO.read(getClass().getResource("/Background.png"));
			endscreenmario = ImageIO.read(getClass().getResource("/Mariogewinnt.png"));
			endscreenluigi = ImageIO.read(getClass().getResource("/Luigigewinnt.png"));
		} catch (IOException e) {}
		
		
	}
	
	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs==null){
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		if(launcher.launching){
			launcher.render(g);
		}else {
		g.drawImage(background, 0, 0, getWidth(),getHeight(),null);
		handler.render(g);
		}
		if(player.tot&&player.getY()>Game.getFrameHöhe()){
			g.drawImage(endscreenluigi,0,0,getWidth(),getHeight(),null);
		}
		if(luigi.tot&&luigi.getY()>Game.getFrameHöhe()){
			g.drawImage(endscreenmario,0,0,getWidth(),getHeight(),null);
		}
		g.dispose();
		bs.show();
	}
	
	public void tick(){
		if(launcher.launching){
		}else if(player.tot&&player.getY()>Game.getFrameHöhe()||luigi.tot&&luigi.getY()>Game.getFrameHöhe()){
			
		}else{
		handler.tick();
		Goomba.Goombasinit();
		Koopa.koopasinit();
		Kugelwilli.kugelwillisinit();
		Monty.Montysinit();
		Pilz.Pilzsinit();
		}
	}
	
	public synchronized void start(){
		if(running) return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized static void stop(){
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
