package Input;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Entity.Entity;
import Entity.Luigi;
import Main.Game;
import Main.Handler;
import Main.Id;

public class KeyLuigi implements KeyListener{

	public boolean sprung = false;
	public static boolean run = false,d=false,shift=false,a=false;
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for(Entity en:Game.handler.entity){
			if(en.tot==false){
		if(key==e.VK_RIGHT){
			d = true;
		}
		if(key==e.VK_LEFT){
			a=true;
		}
		if(key==e.VK_UP&&en.getId()==Id.Luigi&&Game.luigi.getStunned()==false){
			if(!en.jumping&&!en.falling){
				Game.handler.ChangeMusic(4, 1, false);
				en.jumping=true;
				en.gravity=15.0f;
			}
			
		 }
		if(key==e.VK_CONTROL){
			 shift = true;
		}
	   }}
	}
	
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for(Entity en:Game.handler.entity){
		if(key==e.VK_RIGHT){
			Game.luigi.setVelX(0);
			Luigi.moving=-1;
			d=false;
		}
		if(key==e.VK_LEFT){
			Game.luigi.setVelX(0);
			Luigi.moving=-2;
			a=false;
		}
		if(key==e.VK_CONTROL){
			shift = false;
		}
	  }
	}
	
	
	public void keyTyped(KeyEvent arg0) {
		
	}

}
