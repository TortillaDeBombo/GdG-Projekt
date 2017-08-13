package de.uulm.mi.gdg;



import processing.core.PApplet;
import objects.Spectrum;
import processing.core.PConstants;
import processing.core.PVector;
import objects.Circle;
import java.util.ArrayList;
import controller.Player;
import de.looksgood.ani.Ani;
import ddf.minim.analysis.FFT;
import controller.Blinker;
import controller.Spawner;

public class Equalizer extends PApplet{
	
	private Circle circles;
	private ArrayList<Spectrum> spectra;
	private Blinker blinker;
	private static Spawner particleSystem;
    private static Player player;
    private static FFT fft;
    private float background = 0;
	
	public void setup(){
		
		
		
		
		player = new Player(this, "./data/03Atlantis.mp3");
		fft = player.getFFT();
		
		
		
		spectra = new ArrayList<>();
		for(int i =1 ; i < 7; i++){
			float radius = i * 50;
			float weight = 2;
			int color = color(0,128,64,100);
			int side = i % 2 == 0 ? 1 : -1;
			PVector orientation = new PVector(side * PConstants.HALF_PI, side);
			PVector position = new PVector(this.width / 2, this.height / 2);
			spectra.add(new Spectrum(this, position, radius, weight, color, fft.specSize(), orientation));
		}
		
		Ani.init(this);
		blinker = new Blinker(this);
		particleSystem = new Spawner(this);
		circles = new Circle(this);
	}
	
	public void draw(){
		
		background(background);
		
		fft.forward(player.getSong().mix);
		float jitter = fft.getBand(1);
		
		
		
		
		
		float val;
		for( int i = 0; i < fft.specSize(); i++){
			val = player.getSong().left.get(i);
			for(int j = 1; j < spectra.size(); j += 2){
				spectra.get(j).update(i, val * 40);
			}
		
		
		
			val = player.getSong().right.get(i);
			for(int j = 0; j < spectra.size(); j += 2){
				spectra.get(j).update(i, val * 40);
			}
		}
		
		for(Spectrum s : spectra){
		s.display();
	}
		
		//blinker.update(player.getSong().position());
		//blinker.display();
		//particleSystem.update(player.getSong().position());
		//particleSystem.display();
		circles.update(player.getSong().position());
		circles.display();
		
		
		
	}
	
	public void keyPressed(){
		if (key == 'P' || key == 'p'){
			player.TogglePlaying();
			blinker.startAnimation();
			//particleSystem.startAnimation();
			circles.startAnimation();
		}
	}
	
	public void settings(){
		
		setSize(1240, 720);
	}
	
	
	public static void main (String [] args){
		
		PApplet.main(new String[] {Equalizer.class.getName()});
		
		
		
		
		
		
	}
	
	
}
