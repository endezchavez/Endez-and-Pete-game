import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Door extends GameObject {
	
	private boolean isOpen;
	private BufferedImage tex;
	BufferedImageLoader loader;

	private float rotation;
	private AffineTransform at;

	public Door(int x, int y, ID id, float rotation) {
		super(x, y, id);
		
		this.x = x;
		this.y = y;
		
		width = 16;
		height = 4;
		
		this.rotation = rotation;
		
		loader = new BufferedImageLoader();
		tex = loader.loadImage("textures/door.png");
		
		isOpen = false;
		
		at = new AffineTransform();
		at.translate(x + tex.getWidth() / 2, y + tex.getHeight() / 2);
		at.rotate(Math.toRadians(rotation));
		at.translate(-tex.getWidth()/2, -tex.getHeight()/2);
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public void tick() {
	}
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		
			
		g2d.drawImage(tex, at, null);
		
		g2d.setColor(Color.CYAN);
		g2d.draw(getBounds());
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, tex.getWidth(), tex.getHeight());
	}
	
	

}
