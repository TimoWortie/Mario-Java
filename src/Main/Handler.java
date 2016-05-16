package Main;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.LinkedList;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import Audio.SoundManager;
import Enemy.Enemy;
import Enemy.Goomba;
import Entity.Entity;
import Entity.Mario;
import Item.Item;
//import Item.Item;
import Tile.Block;
import Tile.Pipe;
import Tile.Pipe2;
import Tile.Pipe3;
import Tile.Tile;
import gfx.Sprite;
import gfx.Spritesheet;

public class Handler {
	
	public LinkedList <Entity> entity = new LinkedList <Entity>();
	public LinkedList <Tile> tile = new LinkedList <Tile>();
	public LinkedList <Enemy> enemy = new LinkedList <Enemy>();
	public LinkedList <Item> item = new LinkedList <Item>();
	public static int red,green,blue;
	public static SoundManager manager = new SoundManager();
	
	public void ChangeMusic(int newMusicID, int oldMusicID, boolean running){
		if(oldMusicID==0){
			manager.playSound(newMusicID);
		}else if(oldMusicID==newMusicID&&!running){
			manager.playSound(newMusicID);
		}else if(oldMusicID==newMusicID){
			
		}else{
			manager.stopSound(oldMusicID);
			manager.playSound(newMusicID);
		}
		//if(!Game.DEBUG) manager.fadeInSound(newMusicID);
	}
	
	public void render(Graphics g){
		for(Enemy ene:enemy){
			ene.render(g);
		}
		
		for(Tile ti:tile){
			ti.render(g);
		}
		
		for(Entity en:entity){
			en.render(g);
		}
		for(Item it:item){
			it.render(g);
		}
	}
	
	public void tick(){
		for(Entity en:entity){
			en.tick();
		}
		
		for(Tile ti:tile){
			ti.tick();
		}
		for(Enemy ene:enemy){
			ene.tick();
		}
		for(Item it:item){
			it.tick();
		}
		remove();
	}
	
	
	
	public void addEnemy(Enemy ene){
		enemy.add(ene);
	}
	
	public void addEntity(Entity en){
		entity.add(en);
	}
	
	public void addTile(Tile ti){
		tile.add(ti);
	}
	public void addItem(Item it){
		item.add(it);
	}
	
	public void remove() {
		for(int i = 0; i < entity.size(); i++){
			if(entity.get(i).shouldRemove()) {
				entity.remove(i);
			}
		}
		
		for(int i=0;i<enemy.size();i++){
			if(enemy.get(i).shouldRemove()){
				enemy.remove(i);
			}
		}
		for(int i = 0; i < tile.size(); i++){
			if(tile.get(i).shouldRemove()) {
				tile.remove(i);
			}
		}
		
		for(int i = 0; i < item.size(); i++){
			if(item.get(i).shouldRemove()) {
				item.remove(i);
			}
		}
	}
	
	public void createlevel(BufferedImage level){
		int breite = level.getWidth();
		int h�he = level.getHeight();
		
		for(int y=0;y<h�he;y++){
			for(int x=0;x<breite;x++){
				int pixel = level.getRGB(x, y);
				
				red = (pixel >> 16) & 0xff;
				green = (pixel >> 8) & 0xff;
				blue = (pixel) & 0xff;
				
				
				if(red==0&&green==0&&blue==1){ addTile(new Block(x*64,y*64,Spritesheet.a*60,Spritesheet.b*60,true,this,Id.wall));}
				if(red==111&&green==0&&blue==0){ addTile(new Pipe(x*64,y*64-40,Spritesheet.a*100,Spritesheet.b*100,true,this,Id.pipe));}
				if(red==112&&green==0&&blue==0){ addTile(new Pipe2(x*64-50,y*64-45,Spritesheet.a*100,Spritesheet.b*110,true,this,Id.pipe));}
				if(red==255&&green==0&&blue==0){ addTile(new Pipe3(x*64+10,y*64-45,Spritesheet.a*100,Spritesheet.b*110,true,this,Id.pipe));}
			}
		}
	}
}