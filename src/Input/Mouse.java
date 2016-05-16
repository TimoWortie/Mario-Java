package Input;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Entity.Mario;
import Main.Game;

public class Mouse implements MouseListener{
	
     
	public void mouseClicked(MouseEvent e) {
		int xmouse =e.getX();
		int ymouse =e.getY();
		
	}

	
	public void mouseEntered(MouseEvent arg0) {
		
	}

	
	public void mouseExited(MouseEvent arg0) {
		
	}

	
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		System.out.println(x+" "+y);
		if(x>555&&x<759&&y>349&&y<381){
			Game.launcher.launching=false;
		}
		if(x>178&&x<451&&y>516&&y<559){
			Game.running=false;
			System.out.println("Beendet");
		}
	}

	
	public void mouseReleased(MouseEvent arg0) {
		
	}

}
