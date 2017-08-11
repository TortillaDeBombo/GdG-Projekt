package objects;

import java.util.ArrayList;
import controller.CustomAnimation;
import controller.CustomAnimationCircle;
import de.uulm.mi.gdg.Equalizer;
import processing.core.PApplet;
import processing.core.PVector;

public class ParticleCircle extends Equalizer implements Entity {
	private static PApplet canvas;
	private float transparency;
	private float radius;
	private int c;
	private PVector velocity;
	private PVector position;

	public ParticleCircle(float r, float t, PApplet papa, ArrayList<CustomAnimation> anis,
			ArrayList<CustomAnimationCircle> anis2, int i) {
		radius = 0;
		c = color(random(25, 200), random(50, 200), random(120, 255), random(5, 255));
		transparency = 200;

		canvas = papa;

		position = new PVector(canvas.second()%2==0?1000:canvas.random(canvas.width/1.2f,1100), anis2.get(i).getYPos());
		velocity = new PVector(random(-3,-1), random(-1, 1));

	}

	public void update() {
		position.add(velocity);
		if ((position.x > canvas.width) || (position.x < 0)) {
			velocity.x = velocity.x * -1 ;
		}
		if ((position.y > canvas.height) || (position.y < 0)) {
			velocity.y = velocity.y * -1 ;
		}
		radius++;
		if (transparency > 0) {
			transparency = (float) (transparency - 0.9);
		}
	}

	public void display() {
		canvas.fill(c, transparency - 29);
		canvas.stroke(c, transparency );
		canvas.strokeWeight(1.5f);
		canvas.ellipse(position.x, position.y, radius, radius);
	}
}
