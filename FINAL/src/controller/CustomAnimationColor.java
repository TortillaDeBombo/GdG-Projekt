package controller;

import de.looksgood.ani.easing.Easing;

public class CustomAnimationColor {
	
	public float start;
	public float duration;
	public int value;
	public float radius;
	public int cR;
	public int cB;
	public int cG;
	public String params;
	public Easing mode;
	public float weight;
	
	CustomAnimationColor(int cR, int cB, int cG, String params){
		
		this.cR = cR;
		this.cB = cB;
		this.cG = cG;
		this.params = params;
		
	}
	
	public int getCR(){
		return cR;
	}
	
	public int getCB(){
		return cB;
	}
	
	public int getCG(){
		return cG;
	}
	


}
