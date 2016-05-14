package Input;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Entity.Mario;
import Main.Game;

public class Mouse implements MouseListener{

	public static boolean playergetroffen = false;
     
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
	}

	
	public void mouseReleased(MouseEvent arg0) {
		
	}

}
