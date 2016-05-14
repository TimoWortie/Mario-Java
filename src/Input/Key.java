package Input;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Entity.Entity;
import Entity.Mario;
import Main.Game;
import Main.Handler;
import Main.Id;

public class Key implements KeyListener{

	public boolean sprung = false;
	public static boolean run = false,d=false,shift=false,a=false;
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for(Entity en:Game.handler.entity){
		if(key==e.VK_D){
			d = true;
		}
		if(key==e.VK_A){
			a=true;
		}
		if(key==e.VK_W){

			if(!en.jumping&&!en.falling&&en.getId()!=Id.Luigi){

			if(en.getId()!=Id.Luigi){
			if(!en.jumping&&!en.falling){

				en.jumping=true;
				en.gravity=15.0f;
			}
		 }}}
		if(key==e.VK_SHIFT){
			 shift = true;
		}
		}	
	}
	
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for(Entity en:Game.handler.entity){
		if(key==e.VK_D){
			Game.player.setVelX(0);
			Mario.moving=-1;
			d=false;
		}
		if(key==e.VK_A){
			Game.player.setVelX(0);
			Mario.moving=-2;
			a=false;
		}
		if(key==e.VK_SHIFT){
			shift = false;
		}
	  }
	}
	
	
	public void keyTyped(KeyEvent arg0) {
		
	}

}
