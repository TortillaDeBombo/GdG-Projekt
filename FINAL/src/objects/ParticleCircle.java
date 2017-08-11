package objects;

import java.util.ArrayList;
import controller.CustomAnimation;
import controller.CustomAnimationCircle;
import controller.CustomAnimationColor;
import controller.CustomAnimationVelocity;
import de.uulm.mi.gdg.Equalizer;
import processing.core.PApplet;
import processing.core.PVector;
import processing.core.PShape;

public class ParticleCircle extends Equalizer implements Entity {
	private static PApplet canvas;
	private float transparency;
	private float radius;
	private int c;
	private PVector velocity;
	private PVector position;

	public ParticleCircle(float r, float t, PApplet papa, ArrayList<CustomAnimation> anis,
			ArrayList<CustomAnimationCircle> anis2,ArrayList<CustomAnimationVelocity> anis3, ArrayList<CustomAnimationColor> anis4, int i) {
		radius = 0;
		self = canvas.createShape();
                self.beginShape();
		self.stroke(anis4.get(i).getCR(),anis4.get(i).getCG(),anis4.get(i).getCB(),transparency);
                self.strokeWeight(anis2.get(i).getWeight());
		self.vertex(0, 0);
                self.vertex(1, 0);

                self.endShape();
        

		transparency = 200f;

		canvas = papa;

		position = new PVector(anis2.get(i).getXPos(), anis2.get(i).getYPos());
		velocity = new PVector(anis3.get(i).getX(),anis3.get(i).getY());

	}

	public void update() {
		position.add(velocity);
    	        transparency--;
	}

	public void display() {
		canvas.pushMatrix();
                canvas.translate(position.x, position.y);
                 canvas.shape(self);
                canvas.popMatrix();
	}
	public boolean checkEdges(){
    	if (position.y >= canvas.height+200 && velocity.y > 0) {
            return true;
        } else if (position.y <= -200 && velocity.y < 0) {
            return true;
        } else if (position.x >= canvas.width+200 && velocity.x > 0) {
            return true;
        } else if (position.x <= -200 && velocity.x < 0) {
            return true;
        }
        return false;
    }
    
    public void Bouncing(){
    	if (position.y >= canvas.height-12.5 && velocity.y > 0) {
            velocity.y = velocity.y*(-1);
        } else if (position.y <= 12.5 && velocity.y < 0) {
            velocity.y = velocity.y*(-1);
        } else if (position.x >= canvas.width-12.5 && velocity.x > 0) {
        	velocity.x = velocity.x*(-1);
        } else if (position.x <= 12.5 && velocity.x < 0) {
        	velocity.x = velocity.x*(-1);
        }
        
    }
	
	
	

	
	
}
