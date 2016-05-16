package Main;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import Audio.SoundManager;
import Enemy.Enemy;
import Entity.Entity;
import Item.Item;
import Tile.Block;
import Tile.Bodenblock;
import Tile.Pipe;
import Tile.Pipe2;
import Tile.Pipe3;
import Tile.Tile;
import Tile.Williblaster;
import gfx.Spritesheet;

public class Handler {
	
	public LinkedList <Entity> entity = new LinkedList <Entity>();
	public LinkedList <Tile> tile = new LinkedList <Tile>();
	public LinkedList <Enemy> enemy = new LinkedList <Enemy>();

//	public LinkedList <Item> item = new LinkedList <Item>();
	private int red,green,blue;

	public LinkedList <Item> item = new LinkedList <Item>();
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
		for(Item it:item){
			it.render(g);
		}
		
		for(Tile ti:tile){
			ti.render(g);
		}
		
		for(Entity en:entity){
			en.render(g);
		}
		
	}
	
	public void tick(){
		Game.player.tick();
		Game.luigi.tick();
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
		int höhe = level.getHeight();
		
		for(int y=0;y<höhe;y++){
			for(int x=0;x<breite;x++){
				int pixel = level.getRGB(x, y);
				
				red = (pixel >> 16) & 0xff;
				green = (pixel >> 8) & 0xff;
				blue = (pixel) & 0xff;
				
				
				if(red==0&&green==0&&blue==1){ addTile(new Block(x*64,y*64,68,64,true,this,Id.wall));}
				if(red==111&&green==11&&blue==11){ addTile(new Bodenblock(x*64,y*64,Spritesheet.a*100,Spritesheet.b*100,true,this,Id.wall));}
				if(red==111&&green==0&&blue==0){ addTile(new Pipe(x*64-10,y*64-77,Spritesheet.a*150,Spritesheet.b*120,true,this,Id.pipe));}
				if(red==112&&green==0&&blue==0){ addTile(new Pipe2(x*64-100,y*64-77,Spritesheet.a*160,Spritesheet.b*120,true,this,Id.pipe));}
				if(red==255&&green==0&&blue==0){ addTile(new Pipe3(x*64-80,y*64,Spritesheet.a*100,Spritesheet.b*110,true,this,Id.pipe));}
				if(red==255&&green==255&&blue==1){ addTile(new Williblaster(x*64-80,y*64+30,Spritesheet.a*100,Spritesheet.b*100,true,this,Id.wall));}
			}
		}
	}
}