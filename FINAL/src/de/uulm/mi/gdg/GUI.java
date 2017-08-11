package de.uulm.mi.gdg;

import controlP5.ControlP5;
import controller.Player;
import processing.core.PApplet;

public class GUI extends PApplet {
	 public Player audioPlayer;

     ControlP5 cp5;

     GUI(Player audioPlayer) {
         this.audioPlayer = audioPlayer;
     }

     /**
      * <p>
      * Overwriting settings method from PApplet in Processing. Necessary because when not using the PDE, size() can
      * only be used inside settings().
      * </p>
      *
      * @see processing.core.PApplet
      * @since 2017-07-09
      */
     public void settings() {
    	 setSize(500, 600);
     }

     /**
      * <p>
      * Overwriting setup method from PApplet in Processing. Defines framerate and initializes the control elements.
      * </p>
      *
      * @since 2017-07-09
      */
     public void setup() {
         // 30 fps was chosen to react in a timely manner to interaction with the user
         frameRate(30);

         initControls();
     }

     /**
      * <p>
      * Overwriting draw method from PApplet in Processing. The draw method is displaying the defined control elements.
      * </p>
      *
      * @see processing.core.PApplet
      * @since 2017-07-09
      */
     public void draw() {
         // gui container
         background(70);
         fill(70);

         cp5.show();
     }

     private void initControls() {
         cp5 = new ControlP5(this);

     			cp5.addButton("start").setPosition(373, height - 125)
     					.setImages(loadImage("start.png"), loadImage("startgedrückt.png"), loadImage("start.png"))
     					.updateSize();
     			cp5.addButton("reflexion").setPosition(50, height - 125).setImages(loadImage("Reflexion.png"),
     					loadImage("Reflexion gedrückt.png"), loadImage("Reflexion.png")).updateSize();
     			cp5.addButton("Farbauswahl").setPosition(width / 2 - 120, 5).setImages(loadImage("Farbanzeige3.png"),
     					loadImage("Farbanzeige2.png"), loadImage("Farbanzeige1.png")).updateSize();
     			cp5.addButton("Schema1").setPosition(50, height / 2).setImages(loadImage("Schemaauswahl1.png"),
     					loadImage("Schemaauswahl1 gedrückt.png"), loadImage("Schemaauswahl1.png")).plugTo("scheme1")
     					.updateSize();
     			cp5.addButton("Schema2").setPosition(217, height / 2).setImages(loadImage("Schemaauswahl2.png"),
     					loadImage("Schemaauswahl2 gedrückt.png"), loadImage("Schemaauswahl2.png")).plugTo("scheme2")
     					.updateSize();
     			cp5.addButton("Schema3").setPosition(373, height / 2).setImages(loadImage("Schemaauswahl3.png"),
     					loadImage("Schemaauswahl3 gedrückt.png"), loadImage("Schemaauswahl3.png")).plugTo("scheme3")
     					.updateSize();
     		}

     public void toggleReplay(int value) {
         audioPlayer.toggleReplay();
     }

     public void mousePressed() {
         if (cp5.getMouseOverList().size() > 0) return;
         System.err.println("Cueing has been disabled!");

         // int position = (int) (map(mouseX, 0, width, 0, audioPlayer.getSong().length()));
         // audioPlayer.getSong().cue(position);
     }
}