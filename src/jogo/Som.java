package jogo;

import java.applet.Applet;
import java.applet.AudioClip;

public class Som {
	
	private AudioClip som;
	
	public Som(String som2){
		som = Applet.newAudioClip(getClass().getClassLoader().getResource(som2));
	}

	public AudioClip getSom() {
		return som;
	}

}