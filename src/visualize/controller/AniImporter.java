package controller;

import de.looksgood.ani.AniConstants;
import de.looksgood.ani.easing.Easing;
import processing.core.PApplet;
import processing.data.JSONArray;
import processing.data.JSONObject;
import java.util.ArrayList;
import processing.core.PVector;

public class AniImporter {
	public static ArrayList<CustomAnimation> importAnimation(PApplet parent, String filePath, String type){
		JSONObject file = parent.loadJSONObject(filePath);
		JSONArray backgroundAnimations = file.getJSONArray(type);
		
		ArrayList<CustomAnimation> anis = new ArrayList<>();
		for (int i = 0; i < backgroundAnimations.size(); i++){
			JSONObject o = backgroundAnimations.getJSONObject(i);
			float start = o.getFloat("start");
			float duration = o.getFloat("duration");
			int value = o.getInt("value");
			String easingString = o.getString("easing");
			Easing easing = determineEasing(easingString);
			
			anis.add(new CustomAnimation(start, duration, type, value, easing));
		
		}
		return anis;
	}
	
	public static ArrayList<CustomAnimationCircle> importAnimationData(PApplet parent, String filePath, String type){
		JSONObject file = parent.loadJSONObject(filePath);
		JSONArray backgroundAnimations = file.getJSONArray(type);
		
		ArrayList<CustomAnimationCircle> anis2 = new ArrayList<>();
		for (int i = 0; i < backgroundAnimations.size(); i++){
			JSONObject o = backgroundAnimations.getJSONObject(i);
			int xPos = o.getInt("xPos");
			int yPos = o.getInt("yPos");
			int color = o.getInt("color");
			float radius = o.getFloat("radius");
			float weight = o.getFloat("weight");
			
			
			
			
			//anis2.add(new CustomAnimationCircle(start, duration, type , value, easing, xPos, yPos, color, radius));
			anis2.add(new CustomAnimationCircle(xPos, yPos, color, weight, radius, type));
		}
		return anis2;
	}
	
	
	public static ArrayList<CustomAnimationVelocity> importAnimationVelocity(PApplet parent, String filePath, String type){
		JSONObject file = parent.loadJSONObject(filePath);
		JSONArray backgroundAnimations = file.getJSONArray(type);
		
		ArrayList<CustomAnimationVelocity> anis3 = new ArrayList<>();
		for (int i = 0; i < backgroundAnimations.size(); i++){
			JSONObject o = backgroundAnimations.getJSONObject(i);
			int xPos = o.getInt("x");
			int yPos = o.getInt("y");		
			
			//anis2.add(new CustomAnimationCircle(start, duration, type , value, easing, xPos, yPos, color, radius));
			anis3.add(new CustomAnimationVelocity(xPos, yPos, type));
		}
		return anis3;
	}
	
	
	
	
	
	
	private static Easing determineEasing(String ease){
		Easing e;
		switch (ease){
		case "sine_in":
			e = AniConstants.SINE_IN;
			break;
		case "sine_out":
			e = AniConstants.SINE_OUT;
			break;
		default:
			e = AniConstants.LINEAR;
			break;
			
		}
		return e;
	}

}
