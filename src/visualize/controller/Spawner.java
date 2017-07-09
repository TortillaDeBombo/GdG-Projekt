package controller;

import de.looksgood.ani.Ani;
import objects.Entity;
import objects.Particle;
import processing.core.PApplet;
import processing.core.PVector;
import java.util.ArrayList;




public class Spawner implements Entity {
	private static PApplet canvas;
	private static ArrayList<Particle> particles;
	private static ArrayList<Particle> deadParticles;
	private volatile ArrayList<CustomAnimation> anis;
	private CustomAnimation ani;
	private int particlesToSpawn = 0;
	
	public Spawner(PApplet _parent){
		canvas = _parent;
		particles = new ArrayList<Particle>();
		deadParticles = new ArrayList<Particle>();
		
		startAnimation();
	}
	
	public void startAnimation(){
		anis = AniImporter.importAnimation(canvas, "./data/timing/timing.json", "particlesToSpawn");
	}
	
	public void spawn(){
		PVector position = new PVector(canvas.width / 2 , canvas.height / 2);
		float weight = 5.0f;
		int color = canvas.color(128,128,64);
		
		for(; particlesToSpawn > 0; particlesToSpawn--){
			particles.add(new Particle(canvas, position, weight, color));
		}
	
	}

	
	public void display(){
		for(Particle p : particles){
			p.display();
		}
	}
	
	public void update(){
		for(Particle p : particles ){
			p.update();
			if(p.checkEdges()){
				deadParticles.add(p);
			}
		}
		particles.removeAll(deadParticles);
		deadParticles.clear();
		
	}
	
	public void update(float val){
		if(anis.size() != 0 ){
			if ( val / 1000 > anis.get(0).start){
				ani = anis.remove(0);
			}
		}
		if ( ani != null){
			Ani.to(this, ani.duration, ani.params,ani.value, ani.mode);
			ani = null;
		}
		spawn();
		update();
	}
}
