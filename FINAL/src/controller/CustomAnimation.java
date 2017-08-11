package controller;

import de.looksgood.ani.easing.Easing;

public class CustomAnimation {
	
	public float start;
	public float duration;
	public int value;
	public String params;
	public Easing mode;
	
	CustomAnimation(float start, float duration, String params, int value, Easing mode){
		
		this.start = start;
		this.duration = duration;
		this.params = params;
		this.value = value;
		this.mode = mode;
	}
	
	
	
	
}
