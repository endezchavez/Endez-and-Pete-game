//Class that loops through all game objects

package epsoftworks;

import java.awt.Graphics;

public abstract class GameObject {
	
	protected int x, y;
	protected ID id;
	protected int velX, velY;
	
	public GameObject(int x, int y, ID id){
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	//abstract means these methods will need to be used for classes inheriting this class
	public abstract void tick();
	public abstract void render(Graphics g);
	
	
	//because these methods are not abstract they can be used in the player class although they can not be seen there
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setID(ID id){
		this.id = id;
	}
	
	public ID getID(){
		return id;
	}
	
	public void setVelX(int velX){
		this.velX = velX;
	}
	
	public int getVelX(){
		return velX;
	}
	
	public void setVelY(int velY){
		this.velY = velY;
	}
	
	public int getVelY(){
		return velY;
	}
	
	

}
