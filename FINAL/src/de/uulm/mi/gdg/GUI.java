package de.uulm.mi.gdg;

import java.util.ArrayList;

import controlP5.ControlEvent;
import controlP5.ControlP5;
import controller.Player;
import processing.core.PApplet;

public class GUI extends Equalizer {
	ControlP5 cp5;
	public Player audioPlayer;
	ArrayList<String> commands = new ArrayList<>();
	int myColor = color(160);

	public GUI(Player audioPlayer) {
		this.audioPlayer = audioPlayer;
	}

	public void settings() {
		setSize(500, 600);
	}

	public void setup() {

		cp5 = new ControlP5(this);

		// replace the default controlP5 button with an image.
		// button.setImages(defaultImage, rolloverImage, pressedImage);
		// use button.updateSize() to adjust the size of the button and
		// resize to the dimensions of the defaultImage
		cp5.addButton("start").setPosition(373, height - 125)
				.setImages(loadImage("start.png"), loadImage("startgedrückt.png"), loadImage("start.png"))
				.plugTo("start").updateSize();
		cp5.addButton("reflexion").setPosition(50, height - 125)
				.setImages(loadImage("Reflexion.png"), loadImage("Reflexion gedrückt.png"), loadImage("Reflexion.png"))
				.updateSize();
		cp5.addButton("Farbauswahl").setPosition(width / 2 - 120, 5)
				.setImages(loadImage("Farbanzeige3.png"), loadImage("Farbanzeige2.png"), loadImage("Farbanzeige1.png"))
				.updateSize();
		cp5.addButton("Schema1").setPosition(50, height / 2).setImages(loadImage("Schemaauswahl1.png"),
				loadImage("Schemaauswahl1 gedrückt.png"), loadImage("Schemaauswahl1.png")).plugTo("scheme1")
				.updateSize();
		cp5.addButton("Schema2").setPosition(210, height / 2).setImages(loadImage("Schemaauswahl2.png"),
				loadImage("Schemaauswahl2 gedrückt.png"), loadImage("Schemaauswahl2.png")).plugTo("scheme2")
				.updateSize();
		cp5.addButton("Schema3").setPosition(373, height / 2).setImages(loadImage("Schemaauswahl3.png"),
				loadImage("Schemaauswahl3 gedrückt.png"), loadImage("Schemaauswahl3.png")).plugTo("scheme3")
				.updateSize();
	}

	public void draw() {
		background(myColor);

	}
}