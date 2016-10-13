import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Block extends GameObject {
	public Block(int x, int y, ID id) {
		super(x, y, id);
		
		this.x = x;
		this.y = y;
		
		width = 16;
		height = 16;
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g.setColor(Color.lightGray);
		g.fillRect(x, y, width, height);
		
		g2d.setPaint(Color.BLUE);
		//g2d.draw(getBounds());
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}
	
	
}
