import java.awt.Graphics;
import java.util.LinkedList;

//class that updates and renders all object in game


public class Handler {
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick(){
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
	}
	
	public void render(Graphics g){
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);			
			tempObject.render(g);
		}
	}
	

	
	public void addObject(GameObject object){
		this.object.add(object);
	}
	
	public void addObject(GameObject object, int i){
		this.object.add(i, object);
	}
	
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
	public GameObject getObjectAt(int x, int y){
		for(int i = 0; i < object.size(); i++){
			if(object.get(i).x == x && object.get(i).y == y){
				return object.get(i);
			}
		}return null;
	}
	
	
}
