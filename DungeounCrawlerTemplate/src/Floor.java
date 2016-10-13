import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Floor extends GameObject {
	
	public static int WIDTH = 16, HEIGHT = 16;


	public Floor(int x, int y, ID id) {
		super(x, y, id);
	}

	public void tick() {
		
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}

	public Rectangle getBounds() {
		return null;
	}

}
