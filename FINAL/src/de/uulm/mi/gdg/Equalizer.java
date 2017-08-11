package de.uulm.mi.gdg;

import processing.core.PApplet;
import objects.Spectrum;
import processing.core.PConstants;
import processing.core.PShape;
import processing.core.PVector;
import objects.Circle;
import java.util.ArrayList;

import controlP5.ControlEvent;
import controlP5.ControlP5;
import controller.Player;
import de.looksgood.ani.Ani;
import ddf.minim.analysis.FFT;
import controller.Blinker;
import controller.Spawner;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;

public class Equalizer extends PApplet {
	GUI gui;
	private Circle circles;
	private ArrayList<Spectrum> spectra;
	private Blinker blinker;
	private static Spawner particleSystem;
	private static Player player;
	private static FFT fft;
	private float background = 17;
	private static Minim minim;
        private static AudioPlayer player2;
        private String Farbe;
	

	public void settings() {

		setSize(1200, 750);

	}

	public void setup() {
		minim = new Minim(this);
		player2 = minim.loadFile("./data/03Atlantis.mp3");
		gui = new GUI(this, new Player(this, "./data/03Atlantis.mp3"));
                player = new Player(this, "./data/03Atlantis.mp3");
		fft = gui.audioPlayer.getFFT();

		spectra = new ArrayList<>();
		for (int i = 1; i < 3; i++) {
			float radius = 0;
			float weight = 0;
			int color = color(0, 60, 128, 0);
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

	public void draw() {

		background(background);

		fft.forward(player.getSong().mix);
		float jitter = fft.getBand(1);
		
		
		pushMatrix();
	          stroke(200);
	         for (int i = 0; i < player2.bufferSize() - 1; i++) {
	      float x1 = PApplet.map(i, 0, player2.bufferSize(), 0, width);
	      float x2 = PApplet.map(i + 1, 0, player2.bufferSize(), 0, width);
	      line(x1, 260 + player2.left.get(i) * 25, x2, 260 + player2.left.get(i + 1) * 25);
	      line(x1, 310 + player2.right.get(i) * 25, x2, 310 + player2.right.get(i + 1) * 25);
	      line(x1, 360 + player2.left.get(i) * 25, x2, 360 + player2.left.get(i + 1) * 25);
	      line(x1, 410 + player2.right.get(i) * 25, x2, 410 + player2.right.get(i + 1) * 25);
	      line(x1, 460 + player2.left.get(i) * 25, x2, 460 + player2.left.get(i + 1) * 25);
	      
	    }
	    popMatrix();
	    
	    pushMatrix();
	    stroke(80);
	    for (int i = 0; i < player2.bufferSize() - 1; i++) {
	      float x1 = PApplet.map(i, 0, player2.bufferSize(), 0, width);
	      float x2 = PApplet.map(i + 1, 0, player2.bufferSize(), 0, width);
	      line(x1, 160 + player2.left.get(i) * 25, x2, 160 + player2.left.get(i + 1) * 25);
	      line(x1, 210 + player2.right.get(i) * 25, x2, 210 + player2.right.get(i + 1) * 25);
	      line(x1, 510 + player2.left.get(i) * 25, x2, 510 + player2.left.get(i + 1) * 25);
	      
	    }
	    popMatrix();
		
		float val;
		for (int i = 0; i < fft.specSize(); i++) {
			val = gui.audioPlayer.getSong().left.get(i);
			for (int j = 1; j < spectra.size(); j += 2) {
				spectra.get(j).update(i, val * 40);
			}

			val = gui.audioPlayer.getSong().right.get(i);
			for (int j = 0; j < spectra.size(); j += 2) {
				spectra.get(j).update(i, val * 40);
			}
		}

		for (Spectrum s : spectra) {
			//s.display();
		}
		
		circles.update(gui.audioPlayer.getSong().position());
		circles.display();

	}
	public void controlEvent(ControlEvent theEvent) {
		if(theEvent.getController().getName().equalsIgnoreCase("start")) {
			if(theEvent.getController().getName().equalsIgnoreCase("Schema1")){
				circles.startAnimation("Schema1");
			}
			if(theEvent.getController().getName().equalsIgnoreCase("Schema2")){
				circles.startAnimation("Schema2");
			}else{
				circles.startAnimation("Schema3");
			}
			blinker.startAnimation();
			gui.audioPlayer.togglePlaying();
			gui.cp5.hide();
			
		}
	}


	public static void main(String[] args) {

		PApplet.main("de.uulm.mi.gdg.Equalizer");

	}

	public class GUI  {
		private Player audioPlayer;
		private Equalizer canvas;

		ControlP5 cp5;

		public GUI(Equalizer canvas, Player audioPlayer) {
			this.audioPlayer = audioPlayer;
			this.canvas = canvas;
			cp5 = new ControlP5(canvas);

			cp5.addButton("start").setPosition(width/2+125, height - 175)
					.setImages(loadImage("start.png"), loadImage("startgedrückt.png"), loadImage("start.png"))
					.updateSize();
			cp5.addButton("reflexion").setPosition(width/2-200, height - 175).setImages(loadImage("Reflexion.png"),
					loadImage("Reflexion gedrückt.png"), loadImage("Reflexion.png")).updateSize();
			cp5.addButton("Farbauswahl").setPosition(width / 2 - 120, 90).setImages(loadImage("Farbanzeige3.png"),
					loadImage("Farbanzeige2.png"), loadImage("Farbanzeige1.png")).updateSize();
			cp5.addButton("Schema1").setPosition(width/2-200, height / 2).setImages(loadImage("Schemaauswahl1.png"),
					loadImage("Schemaauswahl1 gedrückt.png"), loadImage("Schemaauswahl1.png")).plugTo("scheme1")
					.updateSize();
			cp5.addButton("Schema2").setPosition(((width/2+125)+width/2-200)/2, height / 2).setImages(loadImage("Schemaauswahl2.png"),
					loadImage("Schemaauswahl2 gedrückt.png"), loadImage("Schemaauswahl2.png")).plugTo("scheme2")
					.updateSize();
			cp5.addButton("Schema3").setPosition(width/2+125, height / 2).setImages(loadImage("Schemaauswahl3.png"),
					loadImage("Schemaauswahl3 gedrückt.png"), loadImage("Schemaauswahl3.png")).plugTo("scheme3")
					.updateSize();
			
		}
	}
}
