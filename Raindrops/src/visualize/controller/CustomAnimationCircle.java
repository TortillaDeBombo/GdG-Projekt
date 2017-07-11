package controller;

import de.looksgood.ani.easing.Easing;

public class CustomAnimationCircle {
	
	public float start;
	public float duration;
	public int value;
	public int color;
	public float radius;
	public int xPos;
	public int yPos;
	public String params;
	public Easing mode;
	public float weight;
	
	CustomAnimationCircle(int xPos, int yPos, int color, float weight, float radius, String params){
		
		this.xPos = xPos;
		this.yPos = yPos;
		this.color = color;
		this.weight = weight;
		this.radius = radius;
		this.params = params;
		
	}
	
	public int getXPos(){
		return xPos;
	}
	
	public int getYPos(){
		return yPos;
	}
	
	public int getColor(){
		return color;
	}
	
	public float getWeight(){
		return weight;
	}
	
	public float getRadius(){
		return radius;
	}

	
	
}
