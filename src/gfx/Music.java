package gfx;
import java.io.File;

import javax.sound.*;
import javax.sound.sampled.*;

public class Music {

	public void play() { try { File file = new File("C:/Users/Timo/Documents/Game/res/APPLAUS8.WAV"); 
	 Clip clip = AudioSystem.getClip();
	 clip.open(AudioSystem.getAudioInputStream(file));
	 clip.start();
	 Thread.sleep(clip.getMicrosecondLength());
	 } 
	 catch (Exception e) {
		 
		 System.err.println(e.getMessage());
		 }} 
	

}
