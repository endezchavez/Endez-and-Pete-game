import java.awt.Graphics;
import java.awt.Shape;

public abstract class GameObject {
	
	protected int x, y;
	protected ID id;
	protected int velX, velY;
	protected int width;
	protected int height;
	
	public GameObject(int x, int y, ID id){
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	//abstract means these methods will need to be used for classes inheriting this class
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Shape getBounds();
	
	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
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
