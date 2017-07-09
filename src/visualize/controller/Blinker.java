package controller;

import de.looksgood.ani.Ani;
import de.looksgood.ani.AniConstants;
import de.looksgood.ani.easing.Easing;
import objects.Entity;
import processing.core.PApplet;
import java.util.ArrayList;
import processing.data.JSONArray;
import processing.data.JSONObject;

public class Blinker implements Entity{
	
	private static PApplet aniObject;
	private volatile ArrayList<CustomAnimation> anis;
	private CustomAnimation ani;
	
	public Blinker(PApplet papa){
		aniObject = papa;
		startAnimation();
	}
	
	public void startAnimation(){
		anis = AniImporter.importAnimation(aniObject, "./data/timing/timing.json", "background");
		
		
	}
	
	public void display(){
		if(ani == null){
			return;
		}
		
		Ani.to(aniObject, ani.duration, ani.params, ani.value, ani.mode);
		ani = null;
	}
	
	public void update(){
		
	}
	
	public void update(float val){
		if(anis.size() == 0){
			return;
		}
		if (val / 1000 < anis.get(0).start){
			return;
		}
		ani = anis.remove(0);
	}

}
