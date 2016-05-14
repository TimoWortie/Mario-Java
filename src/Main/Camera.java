package Main;

import Entity.Entity;
import Entity.Mario;

public class Camera {

	public int x,y;
	
	public void tick(Entity player){
		setX(-Game.player.getX()+Game.getFrameBreite()/3);
		if(Mario.moving==1){
			setX(-Game.player.getX()+Game.getFrameBreite()/3);
		}
		if(Mario.moving==2){
			setX(-Game.player.getX()+Game.getFrameBreite()/3);
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
