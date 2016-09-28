package epsoftworks;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Player extends GameObject {
	
	Random r;

	public Player(int x, int y, ID id) {
		super(x, y, id);
		
		r = new Random();
		
		//velX = r.nextInt(5) + 1;
		//velY = r.nextInt(5) + 1;
	}

	
	public void tick() {
		x += velX;
		y += velY;
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 10, 10);
	}

}
