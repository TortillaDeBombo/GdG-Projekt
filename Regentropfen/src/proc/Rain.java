package proc;

import processing.core.PApplet;
import java.util.ArrayList;
import proc.ExpandingCircle;
import ref.RotatingRect;

public class Rain extends PApplet {
	ArrayList<ExpandingCircle> circles = new ArrayList<ExpandingCircle>();

	public static void main(String[] args) {                            //Main PApplet used to display Animation
		PApplet.main("proc.Rain");
	}

	public void settings() {
		setSize(1280, 720);
	}

	public void setup() {                  
		smooth();
		background(0);
		rectMode(CENTER);
		
	}

	public void draw() {
		background(0);
		
		strokeWeight(20);                                               //Borders on top/bottom of the format.
		stroke(70);
		line(0,0,1280,0);
		line(0,720,1280,720);

		pushMatrix();                                                   //Reflection inside of rotating rectangle.
		  RotatingRect r = new RotatingRect(this);
		  r.rotate();
		  popMatrix();
		for (int i = 0; i < circles.size(); i++) {                      //Adding circles that are to be displayed.
			ExpandingCircle ec = (ExpandingCircle) circles.get(i);
			ec.update();
			ec.display();
		}
		
	}

	public void mousePressed() {                                        //(To be changed) creates circles on left mouse-click
		if (mouseButton == LEFT) {
			circles.add(new ExpandingCircle(this, width / 2, mouseY, false));
			circles.add(new ExpandingCircle(this, width / 2, mouseY, false));
			circles.add(new ExpandingCircle(this, width / 2, mouseY, false));
		}
	}

	public void keyPressed() {                                          //Clears all circles when pressing space
		if (key == ' ') {
			circles.clear();
		}
	}
	public void rotatingRect() {
		float angle = radians(frameCount);
		translate(this.width / 2, this.height / 2);
		rotate(angle);
		noFill();
		stroke(244);
		rect(390, 150, 500, 500);
	}
}
