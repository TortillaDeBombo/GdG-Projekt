package objects;

import processing.core.PVector;

import java.util.ArrayList;

import controller.AniImporter;
import controller.CustomAnimation;
import controller.CustomAnimationCircle;
import de.looksgood.ani.Ani;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PShape;
import objects.ParticleCircle;

public class Circle implements Entity {

	private static PApplet canvas;
	private static ArrayList<ParticleCircle> circles;
	private static ArrayList<ParticleCircle> deadCircles;
	private ArrayList<CustomAnimation> anis;
	private ArrayList<CustomAnimationCircle> anis2;
	private CustomAnimation ani;
	private int Circles = 0;
	int i = 0;
	
	public Circle(PApplet _parent) {

		circles = new ArrayList<ParticleCircle>();
		deadCircles = new ArrayList<ParticleCircle>();
		canvas = _parent;

		startAnimation();

	}

	public void startAnimation() {
		anis = AniImporter.importAnimation(canvas, "./data/timing/timing.json", "Circles");
		anis2 = AniImporter.importAnimationData(canvas, "./data/timing/timing.json", "Data");
	}

	public void spawn() {
		for (; Circles > 0; Circles--) {
			circles.add(new ParticleCircle(0,200,canvas, anis, anis2, i));
			if (i < anis2.size()) {
				i++;
			}
		}
	}

	public void display() {

		for (ParticleCircle c : circles) {
			c.display();
		}
	}

	public void update() {
		for (ParticleCircle p : circles) {
			p.update();
		}
		circles.removeAll(deadCircles);
		deadCircles.clear();

	}

	public void update(float val) {
		if (anis.size() != 0) {
			if (val / 1000 > anis.get(0).start) {
				ani = anis.remove(0);
			}
		}
		if (ani != null) {
			Ani.to(this, ani.duration, ani.params, ani.value, ani.mode);

			ani = null;
		}
		update();
		spawn();

	}

}
