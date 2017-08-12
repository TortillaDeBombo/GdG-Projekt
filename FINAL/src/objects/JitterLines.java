package objects;

import controller.Player;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class JitterLines {
	public PApplet parent;
	public Minim minim;
	public AudioPlayer audio;
	
	public JitterLines(PApplet parent, Minim minim, AudioPlayer audio) {
		this.parent = parent;
		this.minim = minim;
		this.audio = audio;
	}
	
	public void display() {
		parent.pushMatrix();
        parent.stroke(200,100);
        parent.strokeWeight(0.5f);
       for (int i = 0; i < audio.bufferSize() - 1; i++) {
    float x1 = PApplet.map(i, 0, audio.bufferSize(), 0, parent.width);
    float x2 = PApplet.map(i + 1, 0, audio.bufferSize(), 0, parent.width);
    parent.line(x1, 260 + audio.left.get(i) * 9, x2, 260 + audio.left.get(i + 1) * 9);
    parent.line(x1, 310 + audio.right.get(i) * 9, x2, 310 + audio.right.get(i + 1) * 9);
    parent.line(x1, 360 + audio.left.get(i) * 9, x2, 360 + audio.left.get(i + 1) * 9);
    parent.line(x1, 410 + audio.right.get(i) * 9, x2, 410 + audio.right.get(i + 1) * 9);
    parent.line(x1, 460 + audio.left.get(i) * 9, x2, 460 + audio.left.get(i + 1) * 9);
    
  }
  parent.popMatrix();
  
  parent.pushMatrix();
  parent.stroke(80,100);
  for (int i = 0; i < audio.bufferSize() - 1; i++) {
    float x1 = PApplet.map(i, 0, audio.bufferSize(), 0, parent.width);
    float x2 = PApplet.map(i + 1, 0, audio.bufferSize(), 0, parent.width);
    parent.line(x1, 160 + audio.left.get(i) * 5, x2, 160 + audio.left.get(i + 1) * 5);
    parent.line(x1, 210 + audio.right.get(i) * 5, x2, 210 + audio.right.get(i + 1) * 5);
    parent.line(x1, 510 + audio.left.get(i) * 5, x2, 510 + audio.left.get(i + 1) * 5);
    
  }
  parent.popMatrix();
	}

}
