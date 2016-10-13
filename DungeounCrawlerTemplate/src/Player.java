import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {
	
	private Handler handler;
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		width = 16;
		height = 16;
	}

	
	public void tick() {
		x += velX;
		y += velY;
		
		collision();
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}
	public Rectangle getBoundsRight() {
		return new Rectangle(x + width - 5, y + 5, 5, height - 10);
	}
	public Rectangle getBoundsLeft() {
		return new Rectangle(x, y + 5, 5, height - 10);
	}
	public Rectangle getBoundsTop() {
		return new Rectangle(x + (width/2) - (width/2)/2, y, width/2, height/2);
	}
	public Rectangle getBoundsBottom() {
		return new Rectangle(x + (width/2) - (width/2)/2, y + (height/2), width/2, height/2);
	}
	
	public void collision(){
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			if(handler.object.get(i).getID() == ID.Block){
				//collison with walls
				if(tempObject.getBounds().intersects(getBoundsLeft())){
					int distanceInWall = (tempObject.getX() + tempObject.getWidth() - x);
					x += distanceInWall;
				}else if(tempObject.getBounds().intersects(getBoundsRight())){
					int distanceInWall = ((x + width) - tempObject.getX());
					x -= distanceInWall;
				}else if(tempObject.getBounds().intersects(getBoundsTop())){
					int distanceInWall = (tempObject.getY() + tempObject.getHeight() - y);
					y += distanceInWall ;
				}else if(tempObject.getBounds().intersects(getBoundsBottom())){
					int distanceInWall = ((y + height) - tempObject.getY());
					y -= distanceInWall;
				}
			}
			//door collision
			else if(handler.object.get(i).getID() == ID.Door){
				Door tempDoor = (Door)handler.object.get(i);
				if(!tempDoor.isOpen()){
					if(tempDoor.getBounds().intersects(getBoundsLeft())){
						int distanceInWall = (tempDoor.getX() + tempDoor.getWidth() - x);
						x += distanceInWall;
					}else if(tempDoor.getBounds().intersects(getBoundsRight())){
						int distanceInWall = ((x + width) - tempDoor.getX());
						x -= distanceInWall;
					}else if(tempDoor.getBounds().intersects(getBoundsTop())){
						int distanceInWall = ((tempDoor.getY() + tempDoor.getHeight() - y));
						y += distanceInWall;
					}else if(tempDoor.getBounds().intersects(getBoundsBottom())){
						int distanceInWall = ((y + height) - tempDoor.getY());
						y -= distanceInWall;
						
					}
				}
			}
		}
	}
	
	public void render(Graphics g) {		
		g.setColor(Color.GREEN);
		g.fillRect(x, y, width, height);
		
		//g2d.setPaint(Color.BLUE);
		//g2d.draw(getBoundsLeft());
		//g2d.draw(getBoundsTop());
		//g2d.draw(getBoundsBottom());
		//g2d.draw(getBoundsRight());
	}
}
