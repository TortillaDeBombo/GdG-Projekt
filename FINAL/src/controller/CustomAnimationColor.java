package controller;

import de.looksgood.ani.easing.Easing;

public class CustomAnimationColor {
	
	public int cR;
	public int cB;
	public int cG;
	public String params;
	
	
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
