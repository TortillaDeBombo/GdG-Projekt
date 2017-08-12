package objects;

import java.util.ArrayList;
import controller.CustomAnimation;
import controller.CustomAnimationCircle;
import controller.CustomAnimationColor;
import de.uulm.mi.gdg.Equalizer;
import processing.core.PApplet;
import processing.core.PVector;
import de.uulm.mi.gdg.*;

public class ParticleCircle extends Equalizer implements Entity {
	private static PApplet canvas;
	private float transparency;
	private float radius;
	private int c;
	private PVector velocity;
	private PVector position;
	public boolean access;

	public ParticleCircle(float r, float t, PApplet papa, ArrayList<CustomAnimation> anis,
			ArrayList<CustomAnimationCircle> anis2, ArrayList<CustomAnimationColor> anis4, int i) {
		radius = 19;
		c = color(anis4.get(i).getCR(), anis4.get(i).getCG(), anis4.get(i).getCB());
		transparency = 200;

		canvas = papa;

		position = new PVector(anis2.get(i).getXPos(), anis2.get(i).getYPos());
		velocity = new PVector(-15f, 0);

	}

	public void update() {
		position.add(velocity);
		move();
		if (radius <= 90) {
			radius++;
		} else {
			radius = radius + 0;
		}
		if (transparency > 0) {
			transparency = (float) (transparency - 0.9);
		} else if (transparency <= 0) {

		}
	}

	public void display() {
		canvas.fill(c, transparency - 5);
		canvas.stroke(c, transparency + 20);
		canvas.strokeWeight(1.5f);
		canvas.ellipse(position.x, position.y, radius, radius);
	}

	public void move() {
		access = acc;
		if (access) {
			if ((position.x > canvas.width) || (position.x < 0)) {
				velocity.x = velocity.x * -1;
			}
			if ((position.y > canvas.height) || (position.y < 0)) {
				velocity.y = velocity.y * -1;
			}
		} else {
		}
	}
}
