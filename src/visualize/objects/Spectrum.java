package objects;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PShape;
import processing.core.PVector;

public class Spectrum implements Entity{

	
	private static PApplet canvas;
	private int bands;
	private PShape shape;
	private PVector position;
	private float radius;
	
	public Spectrum(PApplet papa, PVector position, float radius, float weight, int color, int bands, PVector orientation){
		
		canvas = papa;
		this.bands = bands;
		this.position = position;
		this.radius = radius;
		
		shape = canvas.createShape();
		shape.beginShape();
		
		shape.stroke(color);
		shape.strokeWeight(weight);
		shape.noFill();
		
		shape.rotate(orientation.x);
		shape.scale(orientation.y,1);
		
		float step = PConstants.PI / bands;
		
		for( float a = 0; a < PConstants.PI; a += step){
			shape.vertex(PApplet.cos(a) * radius, PApplet.sin(a) * radius);
		}
		
		shape.endShape();
		
	}
	
	public void display(){
		canvas.pushMatrix();
		canvas.translate(position.x, position.y);
		canvas.shape(shape);
		canvas.popMatrix();
	}
	
	
	public void update(){
		
	}
	
	public void update(int band, float value){
		PVector vertex = shape.getVertex(band);
		vertex.x = PApplet.cos((band * (PConstants.PI / bands)))* (radius + value);
		vertex.y = PApplet.sin((band * (PConstants.PI / bands)))* (radius + value);
		shape.setVertex(band, vertex);
	}
	
	
}
