package controller;

import de.looksgood.ani.AniConstants;
import de.looksgood.ani.easing.Easing;
import de.uulm.mi.gdg.Equalizer.GUI;
import processing.core.PApplet;
import processing.data.JSONArray;
import processing.data.JSONObject;
import java.util.ArrayList;
import processing.core.PVector;

public class AniImporter {
	public static ArrayList<CustomAnimation> importAnimation(PApplet parent, String filePath, String type) {
		JSONObject file = parent.loadJSONObject(filePath);
		JSONArray backgroundAnimations = file.getJSONArray(type);

		ArrayList<CustomAnimation> anis = new ArrayList<>();
		for (int i = 0; i < backgroundAnimations.size(); i++) {
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

	public static ArrayList<CustomAnimationCircle> importAnimationData(PApplet parent, String filePath, String type) {
		JSONObject file = parent.loadJSONObject(filePath);
		JSONArray backgroundAnimations = file.getJSONArray(type);

		ArrayList<CustomAnimationCircle> anis2 = new ArrayList<>();
		for (int i = 0; i < backgroundAnimations.size(); i++) {
			JSONObject o = backgroundAnimations.getJSONObject(i);
			int xPos = o.getInt("xPos");
			int yPos = o.getInt("yPos");
			/*
			 * int color = o.getInt("color"); float radius = o.getFloat("radius"); float
			 * weight = o.getFloat("weight");
			 */
			// anis2.add(new CustomAnimationCircle(start, duration, type , value, easing,
			// xPos, yPos, color, radius));
			anis2.add(new CustomAnimationCircle(xPos, yPos, type));
		}
		return anis2;
	}

	public static ArrayList<CustomAnimationColor> importAnimationColor(PApplet parent, String filePath, String type){
		JSONObject file = parent.loadJSONObject(filePath);
		JSONArray backgroundAnimations = file.getJSONArray(type);
		
		ArrayList<CustomAnimationColor> anis4 = new ArrayList<>();
		for (int i = 0; i < backgroundAnimations.size(); i++){
			JSONObject o = backgroundAnimations.getJSONObject(i);
			int cR = o.getInt("cR");
			int cB = o.getInt("cB");	
			int cG = o.getInt("cG");
			
			//anis2.add(new CustomAnimationCircle(start, duration, type , value, easing, xPos, yPos, color, radius));
			anis4.add(new CustomAnimationColor(cR, cB, cG, type));
		}
		return anis4;
	}


	private static Easing determineEasing(String ease) {
		Easing e;
		switch (ease) {
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
