package Main;

import javax.swing.JFrame;

import Launcher.Launcher;
import Audio.SoundManager;

public class Main {

	public static void main(String[] args){
		
		
		
		Game game = new Game();
		JFrame frame = new JFrame();
		frame.add(game);
		frame.pack();
		frame.setBounds(0,0,1280,790);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		game.start();
	}

}
