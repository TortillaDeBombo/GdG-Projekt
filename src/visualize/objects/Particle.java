package objects;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PShape;
import processing.core.PVector;


public class Particle  implements Entity {
	private static PApplet canvas;
    private PShape self;
    private PVector position;
    private PVector velocity;
    
    public Particle(PApplet papa, PVector position, float weight, int color){
    	canvas = papa;
    	
    	this.position = position.copy();
    	
    	float orientation = canvas.random(0, PConstants.TWO_PI);
        velocity = new PVector(20 * PApplet.sin(orientation), 20 * PApplet.cos(orientation));
        
        self = canvas.createShape();
        self.beginShape();

        self.stroke(color);
        self.strokeWeight(weight);

        self.vertex(0, 0);
        self.vertex(1, 0);

        self.endShape();
    }

    public void display(){
    	canvas.pushMatrix();
        canvas.translate(position.x, position.y);
        canvas.shape(self);
        canvas.popMatrix();
    }
    
    public void update(){
    	position.add(velocity);
    }
    
    public boolean checkEdges(){
    	if (position.y >= canvas.height && velocity.y > 0) {
            return true;
        } else if (position.y <= 0 && velocity.y < 0) {
            return true;
        } else if (position.x >= canvas.width && velocity.x > 0) {
            return true;
        } else if (position.x <= 0 && velocity.x < 0) {
            return true;
        }
        return false;
    }
    
    
    
}
