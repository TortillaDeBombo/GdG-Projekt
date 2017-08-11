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
	
	CustomAnimationCircle(int xPos, int yPos, float weight, String params){
		
		this.xPos = xPos;
		this.yPos = yPos;
		this.weight = weight;
		this.params = params;
		
	}
	
	public int getXPos(){
		return xPos;
	}
	
	public int getYPos(){
		return yPos;
	}
	
	public float getWeight(){
		return weight;
	}
	

	
	
}
