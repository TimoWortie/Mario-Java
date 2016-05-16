package Input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Launcher.Launcher;
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
		}
		if(x>590&&x<719&&y>403&&y<437){
			Launcher.seite=2;
		}
		if(x>125&&x<373&&y>639&&y<671){
			Launcher.seite=1;
		}
	}

	
	public void mouseReleased(MouseEvent arg0) {
		
	}

}
