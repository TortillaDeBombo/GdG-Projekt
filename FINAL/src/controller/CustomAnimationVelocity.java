package controller;


public class CustomAnimationVelocity {
	
	
	public int xPos;
	public int yPos;
	public String params;
	
	
	public CustomAnimationVelocity(int xPos, int yPos, String params){
		
		this.xPos = xPos;
		this.yPos = yPos;
		this.params = params;
		
	}
	
	public int getX(){
		return xPos;
	}
	
	public int getY(){
		return yPos;
	}
	
	

	
	
}