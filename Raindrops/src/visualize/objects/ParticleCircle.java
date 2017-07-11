package objects;

import java.util.ArrayList;

import controller.AniImporter;
import controller.CustomAnimation;
import controller.CustomAnimationCircle;
import controller.CustomAnimationVelocity;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PShape;
import processing.core.PVector;


public class ParticleCircle  implements Entity {
	private static PApplet canvas;
    private PShape self;
    private PVector velocity;
    private PVector position;
    
    
    public ParticleCircle(PApplet papa, ArrayList<CustomAnimation> anis, ArrayList<CustomAnimationCircle> anis2, ArrayList<CustomAnimationVelocity> anis3, int i){
    	
    	
    	
    	canvas = papa;
    	
    	position = new PVector(anis2.get(i).getXPos(), anis2.get(i).getYPos());
    	
    	float orientation = canvas.random(-1, 0);
        velocity = new PVector(anis3.get(i).getX(),anis3.get(i).getY());
        
        self = canvas.createShape();
        self.beginShape();

        self.stroke(anis2.get(i).getColor());
        self.strokeWeight(anis2.get(i).getWeight());

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
