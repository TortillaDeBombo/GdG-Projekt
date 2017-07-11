package proc;

import java.util.ArrayList;

import processing.core.PApplet;

public class ExpandingCircle {
	private static PApplet parent;
	private float x, y;
	private float radius;
	private int c;
	boolean transparencyOn;
	private float transparency;
	ArrayList<ExpandingCircle> circles = new ArrayList<ExpandingCircle>();

	public ExpandingCircle(PApplet p, float x, float y, boolean transparencyOn) {
		ExpandingCircle.parent = p;
		this.x = x;
		this.y = y;
		this.transparencyOn = transparencyOn;
		c = parent.color(parent.random(255), parent.random(255), parent.random(255), parent.random(255));
		transparency = 255;
	}

	public void update() {
		radius++;
		x--;
		if (transparency > 0) {
			transparency = (float) (transparency - 0.5);
		}
	}

	public void display() {
		parent.fill(c, transparency - 25);
		parent.strokeWeight(2);
		parent.stroke(c, transparency);
		parent.ellipse(x, y, radius, radius);

	}
}