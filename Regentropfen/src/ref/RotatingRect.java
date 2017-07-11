package ref;

import processing.core.PApplet;

public class RotatingRect {
	private static PApplet parent;

	public RotatingRect(PApplet p) {
		this.parent = p;
		parent.noFill();
		parent.stroke(0,0);
		
	}

	public void rotate() {
		float angle = parent.radians(parent.frameCount);
		parent.translate(parent.width / 2, parent.height / 2);
		parent.rotate(angle);
		parent.rect(0, 0, 1280, 720);

	}
}
